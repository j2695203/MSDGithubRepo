"use strict"

let xTA = document.getElementById("xTA");
let yTA = document.getElementById("yTA");
let addBtn = document.getElementById("addBtn");
let resultTA = document.getElementById("resultTA");
let wsResultTA = document.getElementById("wsResultTA");

// choice 1: using AJAX
xTA.addEventListener("keypress", handleKeyPressCB );
yTA.addEventListener("keypress", handleKeyPressCB);
addBtn.addEventListener("click", handleKeyPressCB);

// choice 2: using WebSocket
let ws = new WebSocket("ws://localhost:8080");
ws.onopen = handleConnectCB;
ws.onmessage = handleMessageFromWsCB;


function handleKeyPressCB( event ) {
    if( event.type == "click" || event.keyCode == 13 ){
        // display data in the TA
        event.preventDefault(); // avoid changing lines when press enter

        let x = parseFloat( xTA.value );
        if( isNaN(x) ){
            alert("Please make sure x is a number");
            xTA.value = "<Enter a number>";
            xTA.select();
            return;
        }

        let y = parseFloat( yTA.value );
        if( isNaN(y) ){
            alert("Please make sure y is a number");
            yTA.value = "<Enter a number>";
            yTA.select();
            return;
        }

        // choice 1 AJAX: Make AJAX request to get the calculation
        let request = new XMLHttpRequest();
        request.open("GET","http://localhost:8080/calculate?x=" + x + "&y=" + y );
        request.addEventListener("error", handleAjaxErrorCB );
        request.addEventListener("load", handleAjaxSuccessCB );
        request.send("x+y");

        // choice 2 WebSocket: Make WebSocket request to get the calculation
        if( wsOpen ){
            // the web server is expecting a string of the form "# <space> #"
            ws.send( x + " " + y);
        }else{
            wsResultTA.value = "WS is not open...";
        }

    }

    function handleAjaxErrorCB(){
        console.log("an ajax error occurred");
    }
    function handleAjaxSuccessCB(){
        console.log("got a response from the server");
        resultTA.value = this.responseText;
    }

}

// choice 2: using WebSocket
let wsOpen = false;
function handleConnectCB( event ){
    wsOpen = true;
}

function handleMessageFromWsCB( event ){
    wsResultTA.value = event.data;
}