//in java if I have more than one of something, what collection do I use?
//in javascript we use arrays

let fruits = ["strawberry", "apple", "pomegranate"];

for(let i = 0; i < fruits.length; i++){
    console.log(fruits[i]);
}

//add to the end of the array
fruits.push("apricot");

console.log(fruits);

//to get rid of the at the end of the array
fruits.pop();

console.log(fruits);

//if you want to remove at the head of the array or add
fruits.shift();

console.log(fruits);

fruits.unshift("oranges");
console.log(fruits);

fruits.splice(0, 1);
console.log(fruits);