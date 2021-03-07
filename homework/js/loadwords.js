let i =0;
        let j = 0;
        var t1 = "THE WORLD'S";
        var t2 = "BEST HOMEWORK";
        var speed =90;
        document.addEventListener("DOMContentLoaded",loadword);
        document.addEventListener("DOMContentLoaded",loadword2);
        function loadword(){
            if (i<t1.length){
            document.getElementById("txt1").innerHTML += t1.charAt(i);
            i++;
            setTimeout(loadword,speed);
        }}
        function loadword2(){
            if (j<t2.length){
            document.getElementById("txt2").innerHTML += t2.charAt(j);
            j++;
            setTimeout(loadword2,75);
        }}
        