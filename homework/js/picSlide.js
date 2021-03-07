document.addEventListener("DOMContentLoaded",function(){
    showpic();
    let right = document.getElementsByClassName("nextright");
    let left = document.getElementsByClassName("nextleft");
    let dots = document.getElementsByClassName("dot");
    
    right[0].addEventListener("click",nextSlide);
    left[0].addEventListener("click",lastSlid);
    for (let i =0;i<dots.length;i++){
        dots[i].addEventListener("click",dotAction);
    }
    
});
var picshow = 0;
var switchF = true;
var card = document.getElementsByClassName("piCard");
var dot = document.getElementsByClassName("dot");
var cardlen = card.length;
var timeF;
//slideshow
function showpic(){
    clearTimeout(timeF);
    if (switchF){
    for (let i =0;i<cardlen;i++){
        card[i].style.display="none";
        dot[i].className = dot[i].className.replace(" active","");
    }
    picshow++;
    if(picshow>cardlen){
        picshow=1;
    };
    card[picshow-1].style.display="block";
    dot[picshow-1].className += " active";
    timeF = setTimeout(showpic,2500);
    }
    
}
//nextSlide 下一張
function nextSlide(){
    clearTimeout(timeF);
    if (switchF){
    for (let i =0;i<cardlen;i++){
        card[i].style.display="none";
        dot[i].className = dot[i].className.replace(" active","");
    }
    picshow++;
    if(picshow>cardlen){
        picshow=1;
    }
    card[picshow-1].style.display="block";
    dot[picshow-1].className += " active";
    setTimeout(showpic,10000);
    }
    
}
//lastSlid 上一張
function lastSlid(){
    clearTimeout(timeF);
    if (switchF){
        for (let i =0;i<cardlen;i++){
            card[i].style.display="none";
            dot[i].className = dot[i].className.replace(" active","");
        }
        picshow--;
        if(picshow<1){
            picshow=5;
        }
        card[picshow-1].style.display="block";
        dot[picshow-1].className += " active";
        setTimeout(showpic,10000);
        }
    
}
//dotAction
function dotAction(){
    clearTimeout(timeF);
    if (switchF){
        for (let i =0;i<cardlen;i++){
            card[i].style.display="none";
            dot[i].className = dot[i].className.replace(" active","");
        }
        card[this.id.substr(1)-1].style.display="block";
        dot[this.id.substr(1)-1].className += " active";
        // picshow++;
        // if(picshow>cardlen){
        //     picshow=1;
        // };
        // card[picshow-1].style.display="block";
        // dot[picshow-1].className += " active";
        setTimeout(showpic,10000);
        }
    
}