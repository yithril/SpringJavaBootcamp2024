package org.example;

public class Main {
    public static void main(String[] args) {
        double temperature = 67.5;
        String weatherCondition = "sunny";

        if(temperature > 50 && weatherCondition.equals("sunny")){
            System.out.println("Perfect day for a picnic!");
        }
        //great weather for a walk weather condition is sunny or overcast
        else if(weatherCondition.equals("sunny") || weatherCondition.equals("overcast")){
            System.out.println("Fine time to take a walk!");
        }
        else if(temperature < 0 && weatherCondition.equals("snowy")){
            System.out.println("Build a snowman!");
        }
        //Fanciness
        //If the temperature is between 50 and 65 inclusive and its either sunny or cloudy
        else if((temperature <= 65 && temperature >=50) &&
                (weatherCondition.equals("sunny") || weatherCondition.equals("cloudy"))){
            System.out.println("The temperature is between 50 and 65, AND its either sunny or cloudy");
        }
    }
}