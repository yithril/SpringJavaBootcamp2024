import { Bird } from "./bird";

let dog = {
    name: 'Fido',
    breed: 'German Shepherd',
    isGoodBoy: true,
    age: 1
}

//System.out.printf()
console.log(`The dog's name is ${dog.name}`);

dog.favoriteToy = "Ball";

console.log(dog.favoriteToy);

class Animal {

}

class Dog extends Animal {
    constructor(name, breed, age){
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    bark(){
        console.log("Woof!");
    }
}

let bisky = new Dog("Bisky", "Poodle", 2, "red");
let rover = new Dog("Rover", "Terrier", 10);

bisky.furColor = "red";

console.log(bisky.furColor);
console.log(rover.furColor);

let tweet = new Bird();