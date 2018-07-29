window.addEventListener("load", function(){
    var main = document.querySelector(".main");
    var h = main.querySelector("ul:first-child");
    var p = h.nextSibling;
    var count = true;

    
       h.onclick = function(){
            if(count){
                p.style.display="block";
                count = false;
            }
            else{
                p.style.display="none";
                count = true;
            }
        }
    
 });