/*$(document).ready(function() {
 
  //******************************************************************************
  // 상세검색 달력 스크립트
  //******************************************************************************
  var clareCalendar = {
   monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
   dayNamesMin: ['일','월','화','수','목','금','토'],
   weekHeader: 'Wk',
   dateFormat: 'yy-mm-dd', //형식(20120303)
   autoSize: false, //오토리사이즈(body등 상위태그의 설정에 따른다)
   changeMonth: true, //월변경가능
   changeYear: true, //년변경가능
   showMonthAfterYear: true, //년 뒤에 월 표시
   buttonImageOnly: true, //이미지표시
   buttonText: '달력선택', //버튼 텍스트 표시
   buttonImage: 'cale_bg.jpg', //이미지주소
   showOn: "both", //엘리먼트와 이미지 동시 사용(both,button)
   yearRange: '1990:2020' //1990년부터 2020년까지
  };
  $("#fromDt").datepicker(clareCalendar);
  $("#toDt").datepicker(clareCalendar);
  $("img.ui-datepicker-trigger").attr("style","margin-left:5px; vertical-align:middle; cursor:pointer;"); //이미지버튼 style적용
  $("#ui-datepicker-div").hide(); //자동으로 생성되는 div객체 숨김  
 });*/
 
  window.addEventListener("load", function(){
    var section = document.querySelector(".select-monthly");
    var selectYear = section.querySelector(".sel-year");
    var selectMonth = section.querySelector(".sel-month");
    
    var date = new Date();
    var thisYear = date.getFullYear();
    var thisMonth = date.getMonth();
    var thisDay = date.getDay();
    var idx = 0;
    
    for(var i=thisYear-3; i<thisYear+4; i++){
      if(i==thisYear)
        selectYear.add(new Option(i+"년",i,true,true),idx++);
      else
      selectYear.add(new Option(i+"년",i),idx++);
    };

    for(var i=1; i<=12; i++){
    	if(i==thisMonth+1)
    		selectMonth.add(new Option(i+"월",i,true,true),idx++);
    	else
    		selectMonth.add(new Option(i+"월",i),idx++);
    };

    /*selectYear.onchange = function(){
      var yearObj = selectYear.value;
      var idx1 = 0;
      while(selectYear.options[0]!==null) selectYear.options[0]=null;
      for(var a= yearObj-3; a< Number(yearObj)+4; a++){
        if(a==yearObj)
          selectYear.add(new Option(a+"년",a,true,true),idx1++);
        else
          selectYear.add(new Option(a+"년",a),idx1++);
      };
    };*/
    //	function dragover_handler(ev){
      //		ev.preventDefault();
      //		alert(data);
      //		ev.dataTransfer.dropEffect="move";
      //	};
      // function drop_handler(ev){
        // 	ev.preventDefault();
        // 	var data = ev.dataTransfer.getData("text");
        // 	alert(data);
        // 	//ev.target.innerHTML = data;
        // 	// ev.target.appendChild(document.getElementById(data));
        // };
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

