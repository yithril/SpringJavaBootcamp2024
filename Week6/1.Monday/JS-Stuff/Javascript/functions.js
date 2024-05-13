//in java methods are like: public void animalSound(String animalSound) { }
//hoisting

animalSound("Bark!");

function animalSound(animalSound){
    console.log(animalSound);
}

animalSound("Roar");

function makeMoreAnimalSounds(newAnimalSound, animalSoundFunction){
    console.log(newAnimalSound + " " + animalSoundFunction(newAnimalSound));
}

makeMoreAnimalSounds("Woof", animalSound);

function addTwoNumbers(a, b){
    return a + b;
}