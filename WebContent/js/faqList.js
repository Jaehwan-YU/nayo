window.addEventListener("load", function(){
    var main = document.querySelector(".main");
    var li1 = main.querySelector("h2");
    var show1 = li1.nextElementSibling;
    var li2 = show1.nextElementSibling;
    var show2 = li2.nextElementSibling;
    var li3 = show2.nextElementSibling;
    var show3 = li3.nextElementSibling;
    
    
    var count = true;

       li1.onclick = function(){
            if(count){
                show1.style.display="block";
                count = false;
            }
            else{
                show1.style.display="none";
                count = true;
            }
        }
       li2.onclick = function(){
           if(count){
               show2.style.display="block";
               count = false;
           }
           else{
               show2.style.display="none";
               count = true;
           }
       }
       li3.onclick = function(){
           if(count){
               show3.style.display="block";
               count = false;
           }
           else{
               show3.style.display="none";
               count = true;
           }
       }
    
 });