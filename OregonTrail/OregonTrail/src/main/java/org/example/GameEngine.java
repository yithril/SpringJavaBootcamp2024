package org.example;

import java.util.Scanner;

public class GameEngine {
    private Player[] players = new Player[4];

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    //This function is responsible for setting up the team
    public void setupTeam(){
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 4; i++){
            System.out.println("Please enter your character's name:");
            String name = scanner.nextLine();
            System.out.println("What is your occupation?");
            System.out.println("Farmer, Hunter, Doctor, Pastor, Carpenter, Sheriff, Prospector");
            String occupationInput = scanner.nextLine();
            Occupation occupation = convertStringToOccupation(occupationInput);
            Player player = new Player(name, occupation);
            players[i] = player;
        }
    }

    public void displayTeam(){
        //loop through each person in team, show their name
        for(Player player : players){
            System.out.println("Name: " + player.getName());
        }
    }

    //helper function
    private Occupation convertStringToOccupation(String occupation){
        //process user input convert to occupation enum
        switch(occupation.toLowerCase()){
            case "farmer":
                return Occupation.FARMER;
            case "hunter":
                return Occupation.HUNTER;
            case "doctor":
                return Occupation.DOCTOR;
            case "pastor":
                return Occupation.PASTOR;
            case "carpenter":
                return Occupation.CARPENTER;
            case "sheriff":
                return Occupation.SHERIFF;
            case "prospector":
                return Occupation.PROSPECTOR;
        }
        return Occupation.FARMER;
    }
}
