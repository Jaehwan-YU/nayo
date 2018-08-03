//-------------- shopbag ---------------------------------------------------------------------------
window.addEventListener("load", function(){

    var vegbutton = document.getElementById("veg_button");	 
     
    vegbutton.onclick(function() { 

        alert("aa");

        window.open('','','scrollbars=yes,toolbar=yes,resizable=yes,width=100,height=100,left=0,top=0');
    
    
     } , 800);    
 });

//-------------- shopbagMain ---------------------------------------------------------------------------
 
 window.addEventListener("load", function(){
    
   
    var shopbagbutton = document.querySelector("#shopbag-container");	 
     
       shopbagbutton.addEventListener("click", function(){
        alert("aaaaa");
    })
});
      
