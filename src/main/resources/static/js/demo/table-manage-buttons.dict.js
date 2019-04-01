/*
Template Name: Color Admin - Responsive Admin Dashboard Template build with Twitter Bootstrap 4
Version: 4.2.0
Author: Sean Ngu
Website: http://www.seantheme.com/color-admin-v4.2/admin/
*/

var handleDataTableButtons = function() {
	"use strict";
    
	if ($('#data-table-buttons').length !== 0) {
		table = $('#data-table-buttons').DataTable({
			dom: 'Bftip',
			buttons: [
				{ extend: 'add', className: 'btn-sm btn-primary' },
				{ extend: 'edit', className: 'btn-sm btn-info' },
				{ extend: 'delete', className: 'btn-sm btn-danger' },
				{ extend: 'check', className: 'btn-sm btn-green' },
				{ extend: 'empty', className: 'btn-sm disabled' },
				{ extend: 'copy', className: 'btn-sm' },
				{ extend: 'csv', className: 'btn-sm' },
				{ extend: 'excel', className: 'btn-sm' },
				{ extend: 'pdf', className: 'btn-sm' },
				{ extend: 'print', className: 'btn-sm' }
			],
			responsive: true,
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
                "data": 'dictId'
            },{
                "targets": 1,
                "data": 'typeName'
            },{
                "targets": 2,
                "data": 'dictName'
            },{
                "targets": 3,
                "data": 'dictShortName'
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
                "data": '',
                "render":function(data, type, row, meta){
                    return "";
                }
            }],
			ajax: {
				"url": "/admin/dict/manage/json",
				"data": function () {
					var data = {};
					data.typeId = $('#data-table-type .selected').data('typeid');
					return data;
				},
				"type":'post',
				"success":function(data){
					jsonData = data;
					table.clear();
					for(var obj in data){
						table.row.add(data[obj]);
					}
					table.draw(false);
				}
			}
		});
	}
};

$.fn.dataTable.ext.buttons.add = {
	text: '新增',
	action: function ( e, dt, node, config ) {
		layer.open({
			title:'增加數據字典',
			type: 1,
			resize: true,
			skin: 'layui-layer-rim', //加上边框
			area: [formSize.width, formSize.height], //宽高
			content: $('#addAndEditForm').html(),
			btn: ['保存', '取消'],
			yes:function(){

				PublicFunc.save(target,'/admin/dict/insert');
			},
			btn2:function(){
				layer.closeAll();
			}
		});
	}
};
$.fn.dataTable.ext.buttons.edit = {
	text: '修改',
	action: function ( e, dt, node, config ) {
		layer.open({
			title:'修改數據字典',
			type: 1,
			skin: 'layui-layer-rim', //加上边框
			area: ['420px', '240px'], //宽高
			content: 'html内容'
		});
	}
};
$.fn.dataTable.ext.buttons.delete = {
	text: '刪除',
	action: function ( e, dt, node, config ) {
		PublicFunc.delete(target,'/admin/dict/delete');
	}
};
$.fn.dataTable.ext.buttons.check = {
	text: '審核',
	action: function ( e, dt, node, config ) {
		PublicFunc.check(target,'/admin/dict/check');
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
			table.ajax.reload();
			layer.close(ii);
		}
	};
}();