/*
Template Name: Color Admin - Responsive Admin Dashboard Template build with Twitter Bootstrap 4
Version: 4.2.0
Author: Sean Ngu
Website: http://www.seantheme.com/color-admin-v4.2/admin/
*/
var tableconst = {};
tableconst.buttons = [
    { extend: 'add', className: 'btn-sm btn-primary' },
    { extend: 'edit', className: 'btn-sm btn-info' },
    { extend: 'delete', className: 'btn-sm btn-danger' },
    { extend: 'check', className: 'btn-sm btn-green' },
    { extend: 'empty', className: 'btn-sm disabled' },
    { extend: 'excel', className: 'btn-sm' },
    { extend: 'pdf', className: 'btn-sm' },
    { extend: 'print', className: 'btn-sm' }
];
var handleDataTableButtons = function() {
	"use strict";
    
	if ($('#data-table-buttons').length !== 0) {
		table = $('#data-table-buttons').DataTable({
			dom: 'Bftip',
			buttons: tableconst.buttons,
			responsive: true,
            order:[[0, "des"]],
			oLanguage: {
				"sLengthMenu": "每页显示 _MENU_ 条记录",
				"sZeroRecords": "抱歉， 没有找到數據",
				"sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
				"sInfoEmpty": "0條記錄",
				"sInfoFiltered": "(从 _MAX_ 条数据中检索)",
				"sSearch": "搜索:",
				"oPaginate": {
					"sFirst": "首页",
					"sPrevious": "前一页",
					"sNext": "后一页",
					"sLast": "尾页"
				}
			},
            columnDefs: [{
                "targets": 0,
                "width": '50px',
                "data": 'typeId'
            },{
                "targets": 1,
                "data": 'typeName'
            },{
                "targets": 2,
                "data": 'createBy',
                "render":function(data, type, row, meta){
                    return data;
                }
            },{
                "targets": 3,
                "data": 'createAt',
                "render":function(data, type, row, meta){
                    return data;
                }
            },{
                "targets": 4,
                "data": 'flag',
                "render":function(data, type, row, meta){
                    if (data === 0) {
                        return '<span class="text-danger">未審核</span>';
                    } else if (data === 1) {
                        return '<span class="text-success">已審核</span>';
                    } else {
                        return "";
                    }
                }
            },{
                "targets": 5,
                "data": 'checkBy',
                "render":function(data, type, row, meta){
                    return data;
                }
            },{
                "targets": 6,
                "data": 'checkAt',
                "render":function(data, type, row, meta){
                    return data;
                }
            },{
                "targets": 7,
                "data": 'memo',
                "render":function(data, type, row, meta){
                    return data;
                }
            }],
			ajax: {
				"url": "/admin/dicttype/manage/json",
				"data": function () {
					var data = {};
					data.typeId = $('#data-table-type .selected').data('typeid');
					return data;
				},
				"type":'post',
				"success":function(data){
					jsonData = data.data;
					table.clear();
                    table.rows.add(data.data);
                    table.draw(true);
				}
			}
		});
	}
};

$.fn.dataTable.ext.buttons.add = {
	text: '新增',
	action: function ( e, dt, node, config ) {
		layer.open({
            id:'layer-add',
			title:'增加數據字典',
			type: 1,
			resize: true,
            shadeClose:true,
            skin: 'layui-layer-rim', //加上边框
			area: [formSize.width, formSize.height], //宽高
			content: $('#addAndEditForm').html(),
			btn: ['保存', '取消'],
            success:function(layero, index){
                layero.find('#id').val('自動獲取');
                layero.find('#typeId').val($('.dicttype.selected').text());
                layero.find('#typeId').data('typeid',$('.dicttype.selected').data('typeid'));
            },
			yes:function(index, layero){
                target.typeId = layero.find('#typeId').data('typeid');
                target.dictName = layero.find('#dictName').val();
                if (target.dictName === undefined || '' === target.dictName) {
                    layer.msg("數據字典名稱不能為空", {
                        icon:2,
                        time: 3000,
                    });
                    layero.find('#dictName').focus();
                    return;
                }
                target.dictShortName = layero.find('#dictShortName').val();
                target.dictFullName = layero.find('#dictFullName').val();
                target.memo = $(layero.find('#memo')).val();
                layer.confirm('您確定保存這條記錄嗎？',{
                    btn: ['確定','取消']
                }, function(){
                    layero.find('a.layui-layer-btn0').text('正在提交...');
                    layero.find('a.layui-layer-btn0').addClass('disabled');
                    PublicFunc.ajaxCRUD(target,'/admin/dict/insert',function(ret){
                        layer.closeAll();
                        layer.msg('增加成功', {icon: 1, time:2000});
                        table.ajax.reload().draw(true);
                        target  = undefined;
                    },function(ret,index){
                        layer.msg("增加失敗. 錯誤代碼:" + ret.status + "," + ret.msg, {
                            icon:2,
                            time: 3000,
                        });
                        layero.find('a.layui-layer-btn0').text('保存');
                        layero.find('a.layui-layer-btn0').removeClass('disabled');
                        layer.close(index);
                    });
                    layero.find('a.layui-layer-btn0').text('保存');
                    layero.find('a.layui-layer-btn0').removeClass('disabled');
                    layer.close(index);
                });
			},
			btn2:function(index, layero){
                layero.find('a.layui-layer-btn0').text('保存');
                layero.find('a.layui-layer-btn0').removeClass('disabled');
				layer.close(index);
			}
		});
	}
};
$.fn.dataTable.ext.buttons.edit = {
	text: '修改',
	action: function ( e, dt, node, config ) {
        if (target === undefined || target.length === 0){
            layer.msg("請選擇一行數據", {
                icon:0,
                time: 2000,
            });
            return;
        }
        if (1 === target.flag) {
            layer.msg("該記錄已經審核,不可修改", {
                icon:0,
                time: 3000,
            });
            return;
        }
        layer.open({
            id:'layer-edit',
            title:'修改數據字典',
            type: 1,
            resize: true,
            shadeClose:true,
            skin: 'layui-layer-rim', //加上边框
            area: [formSize.width, formSize.height], //宽高
            content: $('#addAndEditForm').html(),
            btn: ['保存', '取消'],
            success:function(layero, index){
                console.log(target.typeName);
                layero.find('#id').val(target.dictId);
                layero.find('#typeId').val(target.typeName);
                layero.find('#dictName').val(target.dictName);
                layero.find('#dictShortName').val(target.dictShortName);
                layero.find('#dictFullName').val(target.dictFullName);
                layero.find('#memo').val(target.memo);
            },
            yes:function(index, layero){
                layer.confirm('您確定保存所有的修改嗎？',{
                    btn: ['確定','取消']
                }, function(){
                    target.typeId = layero.find('#typeId').data('typeid');
                    target.dictName = layero.find('#dictName').val();
                    if (target.dictName === undefined || '' === target.dictName) {
                        layer.msg("數據字典名稱不能為空", {
                            icon:2,
                            time: 3000,
                        });
                        layero.find('#dictName').focus();
                        return;
                    }
                    target.dictShortName = layero.find('#dictShortName').val();
                    target.dictFullName = layero.find('#dictFullName').val();
                    target.memo = $(layero.find('#memo')).val();
                    layero.find('a.layui-layer-btn0').text('正在提交...');
                    layero.find('a.layui-layer-btn0').addClass('disabled');
                    PublicFunc.ajaxCRUD(target,'/admin/dict/update',function(ret){
                        layer.closeAll();
                        layer.msg('修改成功', {icon: 1, time:2000});
                        table.ajax.reload().draw(true);
                        target = undefined;
                    },function(ret){
                        layer.msg("修改失敗. 錯誤代碼:" + ret.status + "," + ret.msg, {
                            icon:2,
                            time: 3000,
                        });
                        layero.find('a.layui-layer-btn0').text('保存');
                        layero.find('a.layui-layer-btn0').removeClass('disabled');
                        layer.close(index);
                    });
                    layero.find('a.layui-layer-btn0').text('保存');
                    layero.find('a.layui-layer-btn0').removeClass('disabled');
                    layer.close(index);
                });
            },
            btn2:function(index, layero){
                layero.find('a.layui-layer-btn0').text('保存');
                layero.find('a.layui-layer-btn0').removeClass('disabled');
                layer.close(index);
            }
        });
	}
};
$.fn.dataTable.ext.buttons.delete = {
	text: '刪除',
	action: function ( e, dt, node, config ) {
        if (target === undefined || target.length === 0){
            layer.msg("請選擇一行數據", {
                icon:0,
                time: 2000,
            });
            return;
        }
        if (1 === target.flag) {
            layer.msg("該記錄已經審核,不可刪除", {
                icon:0,
                time: 3000,
            });
            return;
        }
        layer.confirm('您確定刪除這條記錄嗎？',{
            btn: ['確定','取消']
        }, function(){
            PublicFunc.ajaxCRUD(target,'/admin/dict/delete',function(ret){
                layer.msg('刪除成功', {icon: 1, time:2000});
                table.row(targetRow).remove().draw(false);
                target = undefined;
            });
        })
	}
};
$.fn.dataTable.ext.buttons.check = {
	text: '審核',
	action: function ( e, dt, node, config ) {
        if (target === undefined || target.length === 0){
            layer.msg("請選擇一行數據", {
                icon:0,
                time: 2000,
            });
            return;
        }
        if (undefined === target.flag) {
            layer.msg("審核需提交審核狀態值", {
                icon:0,
                time: 3000,
            });
            return;
        }
        if (1 === target.flag) {
            layer.msg("該記錄已經審核", {
                icon:0,
                time: 3000,
            });
            return;
        }
        layer.confirm('您確定審核這條記錄嗎？',{
            btn: ['確定','取消']
        }, function(){
            PublicFunc.ajaxCRUD(target,'/admin/dict/check',function(ret){
                layer.msg('審核成功', {icon: 1, time:2000});
                table.ajax.reload();
                target  = undefined;
            });
        });
	}
};
$.fn.dataTable.ext.buttons.empty = {
	text: '      ',
	action: function ( e, dt, node, config ) {

	}
};

var TableManageButtons = function () {
	"use strict";
	return {
		//main function
		init: function () {
			handleDataTableButtons();
		},
		load:function(){
			var ii = layer.load();
			table.ajax.reload().draw(true);
			layer.close(ii);
		}
	};
}();