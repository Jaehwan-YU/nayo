window.addEventListener("load",function(){
    var section = document.querySelector(".food-show-area");
    var lis = section.querySelectorAll(".rest-life");
    var foodService = document.querySelector("#food-service");
    var mutipleButton = foodService.querySelector("input");

    for(var i=0; i<lis.length; i++){
        if(lis[i].textContent <= 15 && lis[i].textContent > 7)
            lis[i].style.background = "yellow";
        else if(lis[i].textContent <= 7)
            lis[i].style.background = "red";
        else if(lis[i].textContent > 15)
            lis[i].style.background= "green";

    }  
    
    var singleSelectMode = function(e){
        if(e.target.nodeName != "TD" && e.target.nodeName != "LI" && e.target.nodeName != "UL" && e.target.nodeName != "IMG") 
        return;

        alert("Single Select Mode 입니다.");
    }

    section.onclick = singleSelectMode;

    mutipleButton.onclick = function(){
        
        if(section.onclick == singleSelectMode){
            this.value = "다중선택 취소";
            
            section.onclick = function(e){
                if(e.target.nodeName != "TD" && e.target.nodeName != "LI" && e.target.nodeName != "UL" && e.target.nodeName != "IMG") 
                    return;
        
                var el = e.target;
                for(; el.nodeName != "TD"; el=el.parentElement);
                
                if(el.style.background == ""){
                el.style.background = "#FFE08C";
                e.target.dataset.checked = "true";
                }
                else{
                el.style.background = "";
                e.target.dataset.checked = "";
                }
            }
        }
         else {
            this.value = "식재료 다중선택";
            var tds = section.querySelectorAll("td");
            for(var i=0; i<tds.length; i++){
                tds[i].style.background = "";
                tds[i].dataset.checked = "";
            }
             section.onclick = singleSelectMode;
         }

    };


});
