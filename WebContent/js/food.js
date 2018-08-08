window.addEventListener("load", function() {
	var section = document.querySelector("#food-show-area");
	var lis = section.querySelectorAll(".rest-life");
    var foodService = document.querySelector("#food-service");
    var foodForm = section.querySelector("form");
    var multipleButton = foodService.querySelector(".multiple-button");
    var recipeButton = foodService.querySelector(".recipe-button");
    var useButton = foodService.querySelector(".use-button");
    var delButton = foodService.querySelector(".del-button");
	var foodOverlay = document.querySelector(".food-overlay");
	var foodAddSection = foodOverlay.querySelector(".food-add-section");
	var foodNameInput = foodAddSection.querySelector("#food-name-input");
	var foodNameAddButton = foodAddSection.querySelector('input[type="button"]');
	var ul = foodAddSection.querySelector("ul");
	
	for (var i = 0; i < lis.length; i++) {
		if (lis[i].textContent <= 15 && lis[i].textContent > 7) 
			lis[i].style.background = "orange";
		else if (lis[i].textContent <= 7)
			lis[i].style.background = "red";
		else if (lis[i].textContent > 15)
			lis[i].style.background = "green";

	}

	var singleSelectMode = function(e) {
		if (e.target.nodeName != "TD" && e.target.nodeName != "LI"
				&& e.target.nodeName != "UL" && e.target.nodeName != "IMG")
			return;

		alert("Single Select Mode 입니다.");
	}

	section.onclick = singleSelectMode;

	multipleButton.onclick = function() {
        
			if (section.onclick == singleSelectMode) {
				multipleButton.value = "다중선택 취소";

				section.onclick = function(e) {
					if (e.target.nodeName != "TD" && e.target.nodeName != "LI"
							&& e.target.nodeName != "UL"
							&& e.target.nodeName != "IMG")
						return;

					var el = e.target;
					for (; el.nodeName != "TD"; el = el.parentElement)
						;
					var foodCheck = el.querySelector('input[type="checkbox"]');

					if (el.style.background == "") {
						el.style.background = "#FFE08C";
						foodCheck.checked = "true";
					} else {
						el.style.background = "";
						foodCheck.checked = "";
					}
				}

            }
            
			else {
				multipleButton.value = "식재료 다중선택";
				var tds = section.querySelectorAll("td");
				for (var i = 0; i < tds.length; i++) {
					tds[i].style.background = "";
					tds[i].querySelector('input[name="food-check"]').checked = "";
				}
				section.onclick = singleSelectMode;
			}
    };
    
    recipeButton.onclick = function(){
        alert("선택한 식재료로 제작 가능한 레시피");
    }
 
    useButton.onclick = function(){
        foodForm.action = "/nayo/usefood";
        foodForm.submit();
    }
    
    delButton.onclick = function(){
    	foodForm.action = "/nayo/delfood";
    	foodForm.submit();
    }
	
	foodNameAddButton.onclick = function(){
		var foodName = foodNameInput.value;
		var addHTML = '<li>'+foodName+'<img src="/nayo/images/x_button.png"></li>'

		ul.innerHTML += addHTML;

		foodNameInput.value = null;
	}

	ul.onclick = function(e){
		var el = e.target;
		if(el.nodeName != "LI" && el.nodeName != "IMG") return;
		
		if(el.nodeName == "IMG" )
			 el = el.parentElement;

		 el.remove();
	}

});
