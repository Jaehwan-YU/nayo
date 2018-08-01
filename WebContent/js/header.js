window.addEventListener("load", function(){
    var basicMenu = document.querySelector("#basic-menu");
    var logout = basicMenu.querySelector("li:first-child > a");
    var email = document.querySelector("#email").textContent;
    if(email == null || email == "") return;
    else{
        logout.textContent = "로그아웃";
        logout.href = "/nayo/logout";
    }
});

window.addEventListener("load", function(){
    var basicMenu = document.querySelector("#basic-menu");
    var signup = basicMenu.querySelector("li:last-child > a");
    var email = document.querySelector("#email").textContent;
    if(email == null || email == "") return;
    else{
    	signup.textContent = "마이페이지";
    	signup.href = "/nayo/member/bookmark";
    }
});