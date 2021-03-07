
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("account1").addEventListener("blur",checkname);  //事件繫結，焦點離開
    document.getElementById("pwd1").addEventListener("blur",checkPwd);  
    document.getElementById("date1").addEventListener("blur",checkdate);   
});

        // document.getElementById("account1").onblur=checkname;
        // document.getElementById("pwd1").onblur=checkPwd;

        function checkdate(){
            let dateVal = document.getElementById("date1").value;
            let sp3 = document.getElementById("idsp3");
            let dateValength = dateVal.length;
            let flag2 = false ;
            // re = /^((19|20)?[0-9]{2}[- /.](0?[1-9]|1[012])[- /.](0?[1-9]|[12][0-9]|3[01]))*$/;
            re = /^(?:\d{4}\/(?:(?:(?:(?:0[13578]|1[02])\/(?:0[1-9]|[1-2][0-9]|3[01]))|(?:(?:0[469]|11)\/(?:0[1-9]|[1-2][0-9]|30))|(?:02\/(?:0[1-9]|1[0-9]|2[0-8]))))|(?:(?:\d{2}(?:0[48]|[2468][048]|[13579][26]))|(?:(?:[02468][048])|[13579][26])00)\/02\/29)$/;
            if (dateValength==""){
                sp3.innerHTML = "<i class="+'"fas fa-times-circle"'+"style="+"color:red"+"></i> <font color=red><em>must enter</em></font>";
                date1.style.border="2px solid red";
            }
            else if (dateValength>=10){
                if (re.test(dateVal)){
                    flag2 = true;
                }
                if (flag2){
                    sp3.innerHTML = "<i class="+'"fas fa-check-circle"'+"style="+"color:green"+"></i> correct";
                    date1.style.border="2px solid green";
                }
                else {
                    sp3.innerHTML = "<i class="+'"fas fa-times-circle"'+"style="+"color:red"+"></i> <font color=red><em>incorrect</em></font>";
                    date1.style.border="2px solid red";
                }
            }
            else {
                sp3.innerHTML = "<i class="+'"fas fa-times-circle"'+"style="+"color:red"+"></i> <font color=red><em>格式輸入不正確(月份、日期請加 0 ) e.g 2020/02/07</em></font>";
                date1.style.border="2px solid red";
            }
        }


        function checkPwd(){
            let thePwdObjVal=document.getElementById("pwd1").value;
            //判斷元素值是否為空白，密碼長度是否大於6
            //如果長度是否大於6，判斷是否包含字母、數字、特殊符號
            let sp2=document.getElementById("idsp2");
            let thePwdObjValLen=thePwdObjVal.length;
            let flag1=false;
            re = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[#^@$!%*?&])[A-Za-z\d#^@$!%*?&]{6,}$/;
            if(thePwdObjVal==""){
                sp2.innerHTML="<i class="+'"fas fa-times-circle"'+"style="+"color:red"+"></i> <font color=red><em>must enter</em></font>"; 
                pwd1.style.border="2px solid red";
            }
            else if(thePwdObjValLen>=6){
                if (re.test(thePwdObjVal)){
                    flag1 = true;
                }
                if(flag1){
                    sp2.innerHTML="<i class="+'"fas fa-check-circle"'+"style="+"color:green"+"></i> correct";
                    pwd1.style.border="2px solid green";
                }
                else{
                    sp2.innerHTML="<i class="+'"fas fa-times-circle"'+"style="+"color:red"+"></i> <font color=red><em>incorrect</em></font>";
                    pwd1.style.border="2px solid red";
                }    
            }else{
                sp2.innerHTML="<i class="+'"fas fa-times-circle"'+"style="+"color:red"+"></i> <font color=red><em>密碼長度必須大於6</em></font>";
                
            }     
        }    

        
        function checkname(){
            let nameval = document.getElementById("account1").value;
            let sp = document.getElementById("idsp");
            let namevalen = nameval.length;
            let flaga =false;
            let rech = /^[\u4E00-\u9fff]{3,}$/;
            if (nameval==""){
                sp.innerHTML="<i class="+'"fas fa-times-circle"'+"style="+"color:red"+"></i> <font color=red><em>must enter</em></font>";
                account1.style.border="2px solid red";
            }
            else if (namevalen>2){
                // for (let i=0;i<namevalen;i++){
                //     let ch = nameval.charCodeAt(i);
                //     if (ch >= 0x4e00 && ch <= 0x9fff){
                //         flaga =true;
                //     }
                //     if (flaga) break;
                // }
                if (rech.test(nameval)){
                    flaga=true;
                }
                if (flaga){
                    sp.innerHTML="<i class="+'"fas fa-check-circle"'+"style="+"color:green"+"></i> correct";
                    account1.style.border="2px solid green";
                }
                else{
                    sp.innerHTML="<i class="+'"fas fa-times-circle"'+"style="+"color:red"+"></i> <font color=red><em>incorrect</em></font>";
                    account1.style.border="2px solid red";
                }
            }
            else{
                sp.innerHTML="<i class="+'"fas fa-times-circle"'+"style="+"color:red"+"></i> <font color=red><em>please enter 3 words!</em></font>";
                account1.style.border="2px solid red";
            }
        }
