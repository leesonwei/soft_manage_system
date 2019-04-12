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
    { extend: 'setroles', className: 'btn-sm btn-success' },
    { extend: 'empty', className: 'btn-sm disabled' },
    { extend: 'excel', className: 'btn-sm' },
    { extend: 'pdf', className: 'btn-sm' },
    { extend: 'print', className: 'btn-sm' }
];
var roles = $("#roles").val();
var index = 1;

var handleDataTableButtons = function() {
	"use strict";
    
	if ($('#data-table-buttons').length !== 0) {
		table = $('#data-table-buttons').DataTable({
			dom: 'Bftip',
            buttons:tableconst.buttons,
			responsive: true,
            order:[[0, "asc"],[4, "des"]],
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
                "data": 'userid',
                "render": function(data, type, row, meta){
                    return index++;
                }
            },{
                "targets": 1,
                "data": 'userid',
                "render": function(data, type, row, meta){
                    return data;
                }
            },{
                "targets": 2,
                "data": 'userName',
                "render":function(data, type, row, meta){
                    return data;
                }
            },{
                "targets": 3,
                "data": 'password',
                "render":function(data, type, row, meta){
                    return data;
                }
            },{
                "targets": 4,
                "data": 'email',
                "render":function(data, type, row, meta){
                    return data;
                }
            },{
                "targets": 5,
                "data": 'createAt',
                "render":function(data, type, row, meta){
                    return data;
                }
            },{
                "targets": 6,
                "data": 'lastLoginAt',
                "render":function(data, type, row, meta){
                    return data;
                }
            },{
                "targets": 7,
                "data": 'email',
                "render":function(data, type, row, meta){
                    return "";
                }
            }],
			ajax: {
				"url": "/admin/user/manage/json",
				"data": function () {
					var data = {};
					data.knowType = $('#data-table-type .selected').data('dictid');
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
			title:'增加用戶',
			type: 1,
			resize: true,
            shadeClose:true,
            skin: 'layui-layer-rim', //加上边框
			area: [formSize.width, 300], //宽高
			content: $('#addAndEditForm').html(),
			btn: ['保存', '取消'],
            success:function(layero, index){
                layero.find('#id').val('自動獲取');
                layero.find('#knowType').val($('#data-table-type .selected').data('dictid'));
            },
			yes:function(index1, layero){
                if (target === undefined) target = {};
                target.userid = layero.find('#userid').val();
                target.password = layero.find('#password').val();
                target.userName = layero.find('#userName').val();
                target.email = layero.find('#email').val();

                layer.confirm('您確定保存這條記錄嗎？',{
                    btn: ['確定','取消']
                }, function(index2,layerc){
                    layer.close(index2);
                    layero.find('a.layui-layer-btn0').text('正在提交...');
                    PublicFunc.ajaxCRUD(target,'/admin/user/insert',function(ret){
                        layer.msg('增加成功', {icon: 1, time:2000});
                        table.ajax.reload().draw(false);
                        target  = undefined;
                        layero.find('a.layui-layer-btn0').text('增加成功');
                        layer.close(index1);
                    },function(ret,index){
                        layer.close(index1);
                        layer.msg("增加失敗. 錯誤代碼:" + ret.status + "," + ret.msg, {
                            icon:2,
                            time: 3000,
                        });
                        layer.close(index);
                    });
                });
			},
			btn2:function(index3, layero){
				layer.close(index3);
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
            title:'修改用戶',
            type: 1,
            resize: true,
            shadeClose:true,
            skin: 'layui-layer-rim', //加上边框
            area: [formSize.width, 300], //宽高
            content: $('#addAndEditForm').html(),
            btn: ['保存', '取消'],
            success:function(layero, index){
                layero.find('#userid').val(target.userid);
                layero.find('#userName').val(target.userName);
                layero.find('#email').val(target.email);
                layero.find('#password').val(target.password);
                layero.find('#password2').val(target.password);
            },
            yes:function(index1, layero){
                layer.confirm('您確定保存所有的修改嗎？',{
                    btn: ['確定','取消']
                }, function(index2){
                    layer.close(index2);
                    if (target === undefined) target = {};
                    target.userid = layero.find('#userid').val();
                    target.userName = layero.find('#userName').val();
                    target.email = layero.find('#email').val();
                    target.password = layero.find('#password').val();

                    layero.find('a.layui-layer-btn0').text('正在提交...');
                    PublicFunc.ajaxCRUD(target,'/admin/user/update',function(ret){
                        layer.msg('修改成功', {icon: 1, time:2000});
                        table.ajax.reload().draw(true);
                        target = undefined;
                        layero.find('a.layui-layer-btn0').text('增加成功');
                        layer.close(index1);
                    },function(ret){
                        layer.msg("修改失敗. 錯誤代碼:" + ret.status + "," + ret.msg, {
                            icon:2,
                            time: 3000,
                        });
                        layer.close(index1);
                    });
                });
            },
            btn2:function(index, layero){
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
            PublicFunc.ajaxCRUD(target,'/admin/user/delete',function(ret){
                layer.msg('刪除成功', {icon: 1, time:2000});
                table.row(targetRow).remove().draw(false);
                target = undefined;
            });
        })
	}
};

$.fn.dataTable.ext.buttons.setroles = {
    text: '設置角色',
    action: function ( e, dt, node, config ) {
        if (target === undefined || target.length === 0){
            layer.msg("請選擇一個用戶", {
                icon:0,
                time: 2000,
            });
            return;
        }

        var htmls = '<div id="userRols" class="container" style="padding: 10px 30px">';
        $.ajax({
            url:'/admin/role/getroles',
            header:Cookies.get('token'),
            data: {userid:target.userid},
            type:'get',
            dataType:'json',
            success:function(ret){
                if (ret.status === 0) {
                    var data = ret.data;
                    for (var i in data) {
                        htmls += '<div class="checkbox checkbox-css checkbox-inline">\n' +
                            '\t\t\t\t\t<input type="checkbox" id="'+ data[i].roleId +'" ' + (data[i].selected ? 'checked':'data-check') + ' />\n' +
                            '\t\t\t\t\t<label for="'+ data[i].roleId +'">'+ data[i].roleName +'</label>\n' +
                            '\t\t\t\t</div>';
                    }
                    htmls += '</div>';
                    layer.open({
                        id:'layer-setRoles',
                        title:'設置角色',
                        type: 1,
                        resize: true,
                        shadeClose:true,
                        skin: 'layui-layer-rim', //加上边框
                        area: [formSize.width, 300], //宽高
                        content: htmls,
                        btn: ['保存', '取消'],
                        yes:function(index, layero){
                            var data = [];
                            $('#userRols input[type=checkbox]:checked').each(function(){
                                var dataSub = {};
                                dataSub.userid = target.userid;
                                dataSub.roleId = $(this).attr('id');
                                data.push(dataSub);
                            }) ;
                            $.ajax({
                                url:'/admin/user/setroles/json',
                                type:'post',
                                dataType:'json',
                                data: {json:JSON.stringify(data)},
                                success:function(ret){
                                    if (ret.status == 0) {
                                        layer.msg('設置角色成功', {icon: 1, time:2000});
                                    } else {
                                        layer.msg('設置角色失敗', {icon: 2, time:2000});
                                    }
                                },
                                error:function(ret){
                                    layer.msg("服務器出錯" + ret.status, {
                                        icon:2,
                                        time: 3000,
                                    });
                                }
                            })
                            layer.close(index);
                        },
                        btn2:function(index, layero){
                            layer.close(index);
                        }
                    });
                } else {
                    layer.msg("獲取角色列表失敗" + ret.status, {
                        icon:2,
                        time: 3000,
                    });
                }
            },
            error:function(ret){
                layer.msg("獲取角色列表失敗" + ret.status, {
                    icon:2,
                    time: 3000,
                });
            }
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