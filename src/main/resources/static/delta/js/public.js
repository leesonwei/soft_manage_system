
function gotoUrl(url) {
    //window.location.href = url + "?token=" + Cookies.get('token');
    window.location.href = url;
}
var logout = function(name){
    Cookies.set(name, Cookies.get(name), -1);
    Cookies.remove(name);
    gotoUrl("/user/logout");
}