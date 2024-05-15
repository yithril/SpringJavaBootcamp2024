package org.example;

public abstract class DailyRoutine {
    //Concrete methods
    public void washFace(){
        System.out.println("Washes their face.");
    }
    public void takeShower(){
        System.out.println("Gets in the shower and cleans up.");
    }
    public void chill(){
        System.out.println("It's Netflix time!");
    }

    public void sleep(){
        System.out.println("Good night!");
    }

    //abstract methods
    public abstract void makeBreakfast();
    public abstract void dailyActivity();

    public void doRoutine(){
        washFace();
        takeShower();
        makeBreakfast();
        dailyActivity();
        chill();
        sleep();
    }
}
