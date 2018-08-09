window.addEventListener("load", function(){
	var section = document.querySelector(".daily-menu");
	// var selectYear = section.querySelector(".sel-year");
	// var selectMonth = section.querySelector(".sel-month");
	var table = section.querySelector(".menu-table");
	var thead = table.firstElementChild;
	var tbody = table.querySelector("tbody");
	
	
	
	//달력
	var firstTr = thead.firstElementChild;
	var preButton = firstTr.firstElementChild.querySelector("label");
	var nextButton = firstTr.lastElementChild.querySelector("label");
	var today = new Date();
	var date = new Date();
	    
	preButton.onclick = function(){
		today = new Date(today.getFullYear(), today.getMonth()-1, today.getDate());
		buildCalendar();
	};
	nextButton.onclick = function(){
		today = new Date(today.getFullYear(), today.getMonth()+1,today.getDate());
		buildCalendar();
	};
	     
	function buildCalendar(){
		var doMonth = new Date(today.getFullYear(), today.getMonth(),1);
		var lastDate = new Date(today.getFullYear(),today.getMonth()+1,0);
		             
		var seconTd = firstTr.firstElementChild.querySelector("span");
		seconTd.textContent = today.getFullYear()+"년"+(today.getMonth()+1)+"월"; 
		
		tbody.innerHTML = '';
		
		for(var i = 1; i<=lastDate.getDate();i++){
			col = '<tr><th>'+i+'</th>'
					+'<td value="'+i+'" name="1" ondrop="drop(event)" ondragover="dragover(event)"></td>'
					+'<td value="'+i+'" name="2" ondrop="drop(event)" ondragover="dragover(event)"></td>'
					+'<td value="'+i+'" name="3" ondrop="drop(event)" ondragover="dragover(event)"></td>'
					+'</tr>';
			tbody.innerHTML += col;
			};
		};
		buildCalendar();
});

function drag(ev){
	ev.dataTransfer.setData("text",ev.target.textContent);
	ev.dataTransfer.setData("name",ev.target.dataset.name);
};
function drop(ev){
	ev.preventDefault();
	var title = ev.dataTransfer.getData("text");
	var id = ev.dataTransfer.getData("name");
	ev.target.textContent = title;
	ev.target.id = id;
};
function dragover(ev){
	ev.preventDefault();
};
