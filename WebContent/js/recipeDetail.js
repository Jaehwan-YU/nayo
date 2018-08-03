window.addEventListener("load", function(){
    var section = document.querySelector("#recipe-info");
    var mainTh = section.querySelector("#main-ing-th");
    var subTh = section.querySelector("#sub-ing-th");
    var mainTrs = section.querySelectorAll(".main-ing");
    var subTrs = section.querySelectorAll(".sub-ing");

    mainTh.rowSpan = mainTrs.length;
    subTh.rowSpan = subTrs.length;
})