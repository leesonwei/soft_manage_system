var table;
var jsonData;
var target;
var targetRow;

var formSize = {};

(function(){
    if (window.innerWidth > 1198) {
        formSize.width = '800px';
        formSize.height = '600px';
    }
    if (window.innerWidth > 798) {
        formSize.width = '600px';
        formSize.height = '420px';
    }
    if (window.innerWidth > 450) {
        formSize.width = '420px';
        formSize.height = '240px';
    }
})();


var PublicFunc = function() {
    "use strict";
    return {
        gotoUrl:function(url) {
            //window.location.href = url + "?token=" + Cookies.get('token');
            window.location.href = url;
        },
        logout:function(name){
            Cookies.set(name, Cookies.get(name), -1);
            Cookies.remove(name);
            PublicFunc.gotoUrl("/user/logout");
        },
        delete:function(data,url){
            if (data === undefined || data.length === 0){
                layer.msg("請選擇一行數據", {
                    icon:0,
                    time: 2000,
                });
                return;
            }
            if (1 === data.flag) {
                layer.msg("該記錄已經審核,不可刪除", {
                    icon:0,
                    time: 3000,
                });
                return;
            }
            layer.confirm('您確定刪除這條記錄嗎？', {
                btn: ['確定','取消']
            }, function() {
                $.ajax({
                    url: url,
                    header: Cookies.get('token'),
                    type: 'post',
                    data: data,
                    dataType: 'json',
                    success: function (ret) {
                        if (ret.status === 0) {
                            layer.msg('刪除成功', {icon: 1, time:2000});
                            table.row(targetRow).remove().draw(false);
                            target = undefined;
                        } else {
                            layer.msg("刪除失敗. 錯誤代碼:" + ret.status + "," + ret.msg, {
                                icon:2,
                                time: 3000,
                            });
                        }
                    },
                    error: function (ret) {
                        layer.msg(ret.status + ",服務器出錯", {
                            icon:2,
                            time: 3000,
                        });
                    }
                });
            })
        },
        check:function(data,url){
            if (data === undefined || data.length === 0){
                layer.msg("請選擇一行數據", {
                    icon:0,
                    time: 2000,
                });
                return;
            }
            if (undefined === data.flag) {
                layer.msg("審核需提交審核狀態值", {
                    icon:0,
                    time: 3000,
                });
                return;
            }
            if (1 === data.flag) {
                layer.msg("該記錄已經審核", {
                    icon:0,
                    time: 3000,
                });
                return;
            }
            layer.confirm('您確定審核這條記錄嗎？', {
                btn: ['確定','取消']
            }, function(){
                $.ajax({
                    url:url,
                    header:Cookies.get('token'),
                    type:'post',
                    data:data,
                    dataType:'json',
                    success:function(ret){
                        if (ret.status === 0) {
                            layer.msg('審核成功', {icon: 1, time:2000});
                            table.ajax.reload();
                        } else {
                            layer.msg("審核失敗. 錯誤代碼:" + ret.status + "," + ret.msg, {
                                icon:2,
                                time: 3000,
                            });
                        }
                    },
                    error:function(ret){
                        layer.msg(ret.status + ",服務器出錯", {
                            icon:2,
                            time: 3000,
                        });
                    }
                });
            });
        }
    }
}();
