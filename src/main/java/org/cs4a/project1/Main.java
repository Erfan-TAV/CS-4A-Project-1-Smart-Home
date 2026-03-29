package org.cs4a.project1;

import org.cs4a.project1.exceptions.RoomNotFoundException;
import java.util.Scanner;
import org.cs4a.project1.exceptions.*;
import org.cs4a.project1.smart_devices.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public Main() {
        super();
    }

    public static void main(String[] args) {
        Manager roomManager = new Manager();

        //roomManager.addRoom(new Room("bathroom"));

       // System.out.print("Room name[should be bathroom]: ");
        //try {
        //    System.out.print(roomManager.getRoom("bathroom").getName());
       // } catch (RoomNotFoundException e) {
        //    System.out.println(e.getMessage());
       // }
    //input utilities
        Scanner input = new Scanner(System.in);
    // Main Program Loop
            int mainChoice = 0;
            while(mainChoice != 99){
                    System.out.println();
                    System.out.println("SMART HOME CONTROLS");

            // main menu
                System.out.println("\n----- Main Menu -----");
                System.out.println("What would you like to do? (99 to exit)");
                System.out.println("1. Add a Room ");
                System.out.println("2. Remove a Room ");
                System.out.println("3. Manage Existing Devices ");
                System.out.println("4. List Rooms & Devices ");
                System.out.println("99. Exit");
                System.out.print("Selection: ");

                mainChoice = getIntInput(input);
                // menu options
                switch (mainChoice) {
                    case 1: //Add a room
                        System.out.println("Enter room name:");
                        roomManager.addRoom(new Room(input.nextLine()));
                        System.out.println("Room added successfully.");
                        break;
                    case 2: //remove room
                        System.out.println("Listing Device Statuses...");
                        // deviceStatus(devices);
                        break;
                    case 99:// exit the program
                        System.out.println("Exiting... Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        break;
                }


            }
    }
    //helper function to manage possible input prob
    private static int getIntInput(Scanner input) {
        if (input.hasNextInt()) {
            int value = input.nextInt();
            input.nextLine();
            return value;
        }
        input.nextLine();
        return -1;
    }
}