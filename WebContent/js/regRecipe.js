window.addEventListener("load",function(){
    var mainIng = document.querySelector("#main-ing");
    var addArea = mainIng.querySelector("div");
    var addButton = mainIng.querySelector("input[type='button']");
    var count = 1;

    addButton.onclick = function(){
        //추가할 element 생성
        count++;
        var name = document.createElement("input");
        var quantity = document.createElement("input");
        var delButton = document.createElement("input");
        var lineSwap = document.createElement("br");

        //추가할 element 속성 지정
        name.type = "text";
        quantity.type = "text";
        delButton.type = "button";

        name.name = "main-name-"+count;
        quantity.name = "main-quantity-"+count;

        name.placeholder = "재료명 입력 (예)삼겹살";
        quantity.placeholder="필요량 입력 (예)100g";
        delButton.value = "삭제";

        delButton.onclick = function(){
            this.previousElementSibling.previousElementSibling.remove();
            this.previousElementSibling.remove();
            this.nextElementSibling.remove();
            this.remove();
        };

        addArea.appendChild(name);
        addArea.appendChild(quantity);
        addArea.appendChild(delButton);
        addArea.appendChild(lineSwap);
    }
});

window.addEventListener("load",function(){
    var subIng = document.querySelector("#sub-ing");
    var addArea = subIng.querySelector("div");
    var addButton = subIng.querySelector("input[type='button']");
    var count = 1;

    addButton.onclick = function(){
        //추가할 element 생성
        count++;

        var name = document.createElement("input");
        var quantity = document.createElement("input");
        var delButton = document.createElement("input");
        var lineSwap = document.createElement("br");

        //추가할 element 속성 지정
        name.type = "text";
        quantity.type = "text";
        delButton.type = "button";

        name.name = "sub-name-"+count;
        quantity.name = "sub-quantity-"+count;

        name.placeholder = "재료명 입력 (예)굴소스";
        quantity.placeholder="필요량 입력 (예)100g";
        delButton.value = "삭제";

        delButton.onclick = function(){
            this.previousElementSibling.previousElementSibling.remove();
            this.previousElementSibling.remove();
            this.nextElementSibling.remove();
            this.remove();
        };

        addArea.appendChild(name);
        addArea.appendChild(quantity);
        addArea.appendChild(delButton);
        addArea.appendChild(lineSwap);
    }
});

window.addEventListener("load",function(){
    var process = document.querySelector("#process");
    var addArea = process.querySelector("div");
    var addButton = process.querySelector("input[type='button']");
    var count = 1;

    addButton.onclick = function(){
        count++;
        //추가할 element 생성
        var textArea = document.createElement("textarea");
        var img = document.createElement("input");
        var delButton = document.createElement("input");
        var lineSwap = document.createElement("br");

        //추가할 element 속성 지정
        img.type = "file";
        img.accept = ".jpg, .png, .gif";
        delButton.type = "button";

        textArea.name = "process-text-"+count;
        img.name = "process-img-"+count;

        textArea.placeholder = "조리과정을 입력하세요.";
        delButton.value = "삭제";

        delButton.onclick = function(){
            this.previousElementSibling.previousElementSibling.remove();
            this.previousElementSibling.remove();
            this.nextElementSibling.remove();
            this.remove();
        };

        addArea.appendChild(textArea);
        addArea.appendChild(img);
        addArea.appendChild(delButton);
        addArea.appendChild(lineSwap);
    }
});

window.addEventListener("load", function(){
    var cancelButton = document.querySelector("#cancel-button");

    cancelButton.onclick = function(){
        history.back(-1);
    };    
});