//grab the element you want

function changeToRed(){
    let firstTag = document.getElementById("firstTag");
    firstTag.style.backgroundColor = 'red';
    firstTag.style.fontSize = '25px';
}

//event listener
let button = document.getElementById("theButton");

//add the event listener
//takes two arguments, first is the event, the second is what do you
//do when the event fires
button.addEventListener("click", changeToRed);

function changeToGreen(){
    let otherTags = document.getElementsByClassName("otherTag");

    for(let i = 0; i < otherTags.length; i++){
        otherTags[i].style.backgroundColor = "green";
    }
}

let greenButton = document.getElementById("greenButton");

//add an event listener
greenButton.addEventListener("click", changeToGreen);

//Add submit event to the form
let form = document.getElementById("myForm");

form.addEventListener('submit', function(event) {
    //stops the page refresh from happening
    event.preventDefault();

    let testInput = document.getElementById("testInput");

    console.log(testInput.value);
})