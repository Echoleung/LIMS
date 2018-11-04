var EventUtil = {
    addHandler:function(element,type,handler){
        if(element.addEventListener){
            element.addEventListener(type,handler,false);
        }else if(element.attachEvent){
            element.attachEvent("on"+type,handler);
        }else{
            element["on"+type]=handler;
        }
    },

    getEvent:function(event){
        return event?event:window.event;
    },

    getTarget:function(event){
        return event.target||event.srcElement;
    },

    preventDefault:function(event){
        if(event.preventDefault){1
            event.preventDefault();
        }else{
            event.returnValue=false;
        }
    },

    removeHandler:function(element,type,handler){
        if(element.removeEventListener){
            element.removeEventListener(type,handler,false);
        }else if(element.detachEvent){
            element.datachEvent("on"+type,handler);
        }else{
            element["on"+type]=null;
        }
    },
    stopPropagation:function(event){
        if(event.stopPropagation){
            event.stopPropagation();
        }else{
            event.cancelBubble=true;
        }
    }
};

//global variables
var btn_submit=document.getElementsByName("account")[0];


//event
EventUtil.addHandler(btn_submit,'click',function () {
   var nickname=document.getElementsByName("nickname")[0].value;
   var realname=document.getElementsByName("realname")[0].value;
   var password=document.getElementsByName("password")[0].value;
   var age=parseInt(document.getElementsByName("age")[0].value);
   var passwordcheck=document.getElementsByName("passwordcheck")[0].value;

   var account=document.getElementById("account").getAttribute("account");
   var txt_accout=document.getElementsByName("account")[0];
   txt_accout.value=account;

   if(!(password===passwordcheck&&(password!=""||password!=null))) {
       alert("password not checked, reput agin");
       return false;
   }
   else if (nickname==""||nickname==null){
       alert("nickname needed");
       return false;
   }
   else if (realname==""||realname==null){
       alert("realname needed");
       return false;
   }
   else if (age!=age){
       alert("legal integer age needed");
       return false;
   }
});