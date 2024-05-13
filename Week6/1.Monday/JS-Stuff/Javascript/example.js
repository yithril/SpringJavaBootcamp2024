//primitive data types in java: double, float, integer, long, char, boolean, byte, short

//javascript: string, boolean, number, null, undefined, bigint, symbol

//dynamic typing
//variables
let fullName = "Jonathan Hop";

fullName = 50;

fullName = true;

let isPremiumMember = true;

let redWingsFans = null;

let lionsFans;

console.log(fullName);

const apiKey = '9238223E323';

for(let i =0; i < 10; i++){
    console.log(i);
}

let j = 0;
while(j < 10){
    console.log(j);
    j++;
}

//If statements
let firstNumber = 100;
let secondNumber = 200;
let thirdNumber = "100";

//> >= < <= 
if(firstNumber < secondNumber){

}

//== ===

if(firstNumber == thirdNumber){
    console.log("First Number is equal to third number");
}

if(firstNumber === thirdNumber){
    console.log("First Number is still equal to third number");
}

//weird javascript behavior
let firstBoolean = true;
let secondBoolean = 1;

if(firstBoolean == secondBoolean){
    console.log("True is equal to infinity.");
}

//And and Or ||
if(firstNumber < secondNumber && firstBoolean === secondBoolean){

}

//string methods
let customerName = "john smith";

console.log(customerName.toUpperCase());
console.log(customerName.toLowerCase());
