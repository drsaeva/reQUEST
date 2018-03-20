"use strict";

function getCoffee(call){

  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(){
    console.log(xhr.readyState);
    if (xhr.readyState == 4 && xhr.status === 200) {
      console.log(xhr.responseText);
    }
  };
  xhr.open("GET", "coffee.json", true);
  xhr.send;
}

window.onload = function(){
  document.getElementById("myButton").addEventListener("click",getCoffee, false);
}
