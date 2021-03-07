//建立監聽池
document.addEventListener("DOMContentLoaded",function(){
    switchBtn = true;//控制四個function的開關，開始設true(over跟out都設true，因為一開始進入就要執行)
    imglist = document.querySelectorAll("img");
    
    // console.log(imglist);
    imglen = imglist.length;            
    for (let i =0;i<imglen;i++){
        imglist[i].addEventListener("mouseover",enLight);
        imglist[i].addEventListener("mouseout",offLight);
        imglist[i].addEventListener("click",clickAction);
        imglist[i].addEventListener("dblclick",dblclickAction);
    }
});

//mouseover,switchbtn為true
function enLight(e){
    if (switchBtn){
        for (let i =0;i<this.id.substr(1);i++){
            imglist[i].index = i+1;
            imglist[i].src="Images/chngstar.gif"
        }
        document.getElementById("wait").innerHTML=`Please Wait <i class="fa fa-spinner fa-spin" style="font-size:24px"></i>`;
        document.getElementById("score").innerHTML=`Score: ${this.index}`;
    }
}
//mouseout
function offLight(e){
    if (switchBtn){
        for (let i =0;i<event.target.id.substr(1);i++){
            imglist[i].src="Images/star.gif";//把原本亮轉暗
        }
        document.getElementById("wait").innerHTML=`Please Wait <i class="fa fa-spinner fa-spin" style="font-size:24px"></i>`;
        document.getElementById("score").innerHTML=`Score: 0`;
    }
}

//click
function clickAction(e){
    if (switchBtn && e.src !="Images/star.gif"){//true且是亮的話
        document.getElementById("wait").innerHTML=`Finished`;
        document.getElementById("score").innerHTML=`Score:${event.target.id.substr(1)}(Double Click Reset)`;
        switchBtn = false;//關掉
    }
}
//dblclick
function dblclickAction(){
    switchBtn = true;//開關打開
    for (let i =0;i<=imglen;i++){
        imglist[i].src="Images/star.gif";
    }
    document.getElementById("wait").innerHTML=``;
    document.getElementById("score").innerHTML=`Score: 0`;
}