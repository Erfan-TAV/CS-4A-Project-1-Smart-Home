package org.cs4a.project1;

//import org.cs4a.project1.exceptions.RoomNotFoundException;
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
            while(mainChoice != 5){
                    System.out.println();
                    System.out.println("SMART HOME CONTROLS");

            // main menu
                System.out.println("\n----- Main Menu -----");
                System.out.println("What would you like to do? ");
                System.out.println("1. Add a Room ");
                System.out.println("2. Remove a Room ");
                System.out.println("3. Manage Devices ");
                System.out.println("4. List Rooms & Devices ");
                System.out.println("5. Exit");
                System.out.print("Selection: ");

                mainChoice = getIntInput(input);
                // menu options
                switch (mainChoice) {
                    case 1: //Add a room
                        System.out.println("Enter room name:");
                        roomManager.addRoom(new Room(input.nextLine()));
                        System.out.println("Room added successfully.");
                        pause(input);
                        break;
                    case 2: //Remove a room
                        System.out.print("Enter name of room to remove: ");
                        try {
                            roomManager.removeRoom(input.nextLine());
                            System.out.println("Room removed.");
                        } catch (RoomNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3: //manage devs by room
                        System.out.println("Entering Device Management...");
                        clearScreen(); //idk if this is actually doingn anything, hard to tell in my IDE
                        roomManager.printAllRooms(roomManager);
                        manageRoomDevices(roomManager, input);
                        break;
                    case 4: // list all the stuff as liong as it's not empty
                        if (roomManager.getRoomList().isEmpty()) {
                            System.out.println("No rooms found.");
                        } else {
                            displayAll(roomManager);
                        }
                        break;
                    case 5:// exit the program
                        System.out.println("Exiting... Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        break;
                }


            }
    }
    // function for managing the submenu to add a specific device
    private static void manageRoomDevices(Manager manager, Scanner input) {
        clearScreen();
        System.out.print("Enter Room Name to Manage:  ");
        String roomName = input.nextLine();

        try {
            Room selectedRoom = manager.getRoom(roomName);
            int deviceChoice = 0;

            while (deviceChoice != 4) {
                //print management menu
                System.out.println("\n--- Managing " + selectedRoom.getName() + " ---");
                System.out.println("1. Add Smart Light");
                System.out.println("2. Add Fan");
                System.out.println("3. Add Motion Sensor");
                System.out.println("4. Add Thermostat");
                System.out.println("5. Add Door Lock");
                System.out.println("6. Remove a Device");
                System.out.println("7. Back to Main Menu");
                System.out.print("Selection: ");

                deviceChoice = getIntInput(input);
                // device managemtn choices
                if (deviceChoice == 1) {
                    System.out.print("Enter Light Name: ");
                    String name = input.nextLine();
                    selectedRoom.addDeviceToRoom(new SmartLight(true, name, true, 100, 1)); //light is on and 100% brightneess
                } else if (deviceChoice == 2) {
                    System.out.print("Enter Fan Name: ");
                    String name = input.nextLine();
                    selectedRoom.addDeviceToRoom(new Fan(true, name, 50)); // i defaulted to on and at half speed
                } else if (deviceChoice ==3){
                    System.out.print("Enter Motion Sensor Name: ");
                    String name = input.nextLine();
                    selectedRoom.addDeviceToRoom(new MotionSensor(name, false)); //default to not sensing anything
                } else if (deviceChoice ==4){
                    System.out.print("Enter Thermostat Name: ");
                    String name = input.nextLine();
                    selectedRoom.addDeviceToRoom(new Thermostat(false, name, 10, 65)); // i guess set to off default

                }else if (deviceChoice ==5){
                    System.out.print("Enter Door Lock Name: ");
                    String name = input.nextLine();
                    selectedRoom.addDeviceToRoom(new DoorLock(name, true, true)); //i figured just default door to on and open
                } else if (deviceChoice == 6) {
                    System.out.print("Enter device name to remove: ");
                    selectedRoom.removeDeviceFromRoom(input.nextLine());
                    System.out.println("Device removed.");
                } else if (deviceChoice == 7){
                    System.out.println("\nReturning to Main Menu\n");
                    pause(input);
                    break;
                }

            }
        } catch (RoomNotFoundException | DeviceNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //UTILITIES
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
    // i used same thing that barnett taught us to do for serendipity lol
    public static void clearScreen(){
        System.out.print("\033[H\033[2J"); //use ansi excape code for terminal clear
    }
    // just a screen pause basically
    public static void pause(Scanner input){
        System.out.println("\n(Press Enter to Continue...)");
        input.nextLine();
    }
    //displays both rooms and devices
    private static void displayAll(Manager m){
        System.out.println("\n ***** ALL ROOMS & DEVICES *****");
        for (Room r: m.getRoomList()){
            System.out.println("Room: " + r.getName());
            for (Device d : r.getDeviceList()){
                System.out.println("  > " + d.getName() + " | Power Status: " + (d.getStatus() ? "ON" : "OFF"));
            }
        }
    }
}