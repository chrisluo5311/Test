document.addEventListener("DOMContentLoaded", function() {
    document.querySelector("#idSelectYear").addEventListener("change", setDate)
    document.querySelector("#idSelectMonth").addEventListener("change", setDate)
    document.querySelector("#idSelectDate").addEventListener("change", wordsChange)

    for(let i =2020; i<=2025 ; i++){
        let opt = document.createElement("option")
        opt.setAttribute("value", i);
        let optTXT = document.createTextNode(i);
        opt.appendChild(optTXT);

        document.getElementById("idSelectYear").appendChild(opt);
    }

    for(let i = 1; i<=12; i++){
        let opt = document.createElement("option");
        opt.setAttribute("value", i);
        let optTXT = document.createTextNode(i);
        opt.appendChild(optTXT);
        document.getElementById("idSelectMonth").appendChild(opt);
    }
});
let yy,mm
function setDate(){
    // $("#idSelectDate").empty();
    document.getElementById("idSelectDate").innerHTML="";
    yy=document.querySelector("#idSelectYear").value;
    mm= document.querySelector("#idSelectMonth").value;
    console.log(yy)
    console.log(mm)
    let d = new Date(yy,mm,0).getDate();
    console.log(d);
    for(let i =1; i<=d; i++){
    let opt = document.createElement("option");
    opt.setAttribute("value", i );
    let optTXT = document.createTextNode(i);
    opt.appendChild(optTXT);
    document.getElementById("idSelectDate").appendChild(opt);
    }
}

function wordsChange(){
    let y =document.getElementById("idSelectYear").value;
    let m =document.getElementById("idSelectMonth").value;
    let d =document.getElementById("idSelectDate").value;
    document.getElementById("idwords2").innerHTML=`你選擇的日期為${y}年${m}月${d}日`
}