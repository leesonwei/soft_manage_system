var table;
var jsonData;
var target;
var targetRow;
var formSize = {};

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
        }
    }
}();
