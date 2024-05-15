package org.example;

public class StudentRoutine extends DailyRoutine {

    @Override
    public void makeBreakfast() {
        System.out.println("Puts some cheap cereal into a bowl and eats it. Then drinks a red bull.");
    }

    @Override
    public void dailyActivity() {
        System.out.println("Sleeps during class, can't keep the eyes open.");
    }
}
