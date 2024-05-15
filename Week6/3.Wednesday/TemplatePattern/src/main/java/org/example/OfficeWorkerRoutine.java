package org.example;

public class OfficeWorkerRoutine extends DailyRoutine {

    @Override
    public void makeBreakfast() {
        System.out.println("Drinks expensive Starbucks latte and artisan toast.");
    }

    @Override
    public void dailyActivity() {
        System.out.println("Goes to soul crushing office job.");
    }
}
