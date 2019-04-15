var table;
var jsonData;
var target;
var targetRow;
var formSize = {};

var buttonEmun = function(){
    var buttonEmun = {};
    buttonEmun.INSERT = 2;
    buttonEmun.UPDATE = 4;
    buttonEmun.DELETE = 8;
    buttonEmun.SELECT = 16;
    buttonEmun.CHECK = 32;
    buttonEmun.SETROLES = 64;
    buttonEmun.SETAUTHS = 128;
    return buttonEmun;
}();
var getButton = function(e,c){
    var button = {};
    button.extend = e;
    button.className = c;
    return button;
}
var formReSize = function(){
    if (window.innerWidth > 1198) {
        formSize.width = '800px';
        formSize.height = '600px';
        formSize.offset = 'c';
        return;
    }
    if (window.innerWidth > 798) {
        formSize.width = '80%';
        formSize.height = '60%';
        formSize.offset = 'c';
        return;
    }
    if (window.innerWidth > 450) {
        formSize.width = '100%';
        formSize.height = '50%';
        formSize.offset = 'b';
        return;
    }
};
window.onload += formReSize();
window.onresize += formReSize();

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
        insert:function(data, url){
            console.log(url);
        },
        ajaxCRUD:function(data,url,successCallback,errorCallback){
            var load = layer.load();
            $.ajax({
                url: url,
                header: Cookies.get('token'),
                type: 'post',
                data: data,
                dataType: 'json',
                success: function (ret) {
                    layer.close(load);
                    if (ret.status === 0) {
                        successCallback(ret);
                    } else {
                        errorCallback == null ? PublicFunc.errorCallback(ret) : errorCallback(ret);
                    }
                },
                error: function (ret) {
                    layer.close(load);
                    layer.msg(ret.status + ",服務器出錯", {
                        icon:2,
                        time: 3000,
                    });
                }
            });
        },
        errorCallback:function(ret){
            layer.msg("操作失敗. 錯誤代碼:" + ret.status + "," + ret.msg, {
                icon:2,
                time: 3000,
            });
        },
        getButtonList:function(){
            var buttons = [];
            var value = $('#singleAuthValue').val();
            if (value&buttonEmun.INSERT) {
                buttons.push(getButton('add','btn-sm btn-primary'));
            }
            if (value&buttonEmun.UPDATE) {
                buttons.push(getButton('edit','btn-sm btn-info'));
            }
            if (value&buttonEmun.DELETE) {
                buttons.push(getButton('delete','btn-sm btn-danger'));
            }
            if (value&buttonEmun.CHECK) {
                buttons.push(getButton('check','btn-sm btn-green'));
            }
            if (value&buttonEmun.SETROLES) {
                buttons.push(getButton('setroles','btn-sm btn-success'));
            }
            if (value&buttonEmun.SETAUTHS) {
                buttons.push(getButton('setauths','btn-sm btn-success'));
            }
            if (buttons.length > 0) {
                buttons.push(getButton('empty','btn-sm disabled'));
            }
            buttons.push(getButton('excel','btn-sm'));
            buttons.push(getButton('pdf','btn-sm'));
            buttons.push(getButton('print','btn-sm'));
            return buttons;
        }
    }
}();
