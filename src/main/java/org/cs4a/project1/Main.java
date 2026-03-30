package org.cs4a.project1;

//import org.cs4a.project1.exceptions.RoomNotFoundException;
import java.util.Scanner;
import java.util.Vector;

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
                System.out.println("----- Main Menu -----");
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
                        roomManager.printAllRooms(roomManager);
                        System.out.println("(Press Enter to Continue...)");
                       // input.nextLine(); // extra clear
                        System.out.print("\nEnter name of room to remove: ");
                        try {
                            roomManager.removeRoom(input.nextLine());
                            System.out.println("Room removed.");
                        } catch (RoomNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3: //manage devs by room
                        System.out.println("Entering Device Management...");
                        clearScreen(); //this doesn't really work on my IDE but should with like a terminal or smthn

                        System.out.println("\n-----Device Management Menu-----");
                        System.out.println("1. Device Settings");
                        System.out.println("2. Manage Devices");
                        System.out.println("3. Return to Main Menu");
                        System.out.println("Selection: ");
                        int manageChoice = getIntInput(input);
                        if (manageChoice == 1) { // had to change this slightly so it gets a room first and then goes to manage
                            roomManager.printAllRooms(roomManager);
                           // input.nextLine();        // extra clear buffer bc the room name exception kept going off in dev mgmt
                            System.out.print("Enter Room Name to Edit: ");
                            String rName = input.nextLine();
                            try {
                                Room selectedRoom = roomManager.getRoom(rName);
                                deviceSettings(selectedRoom, input);
                            } catch (RoomNotFoundException | DeviceInactiveException e) {
                                System.out.println("Error: " + e.getMessage());
                                pause(input);
                            }
                        } else if (manageChoice ==2){
                            System.out.println("(Press Enter to Continue...)");
                            input.nextLine();
                            roomManager.printAllRooms(roomManager);
                            manageRoomDevices(roomManager, input);
                        } else if (manageChoice ==3){
                            System.out.println("Returning to Main Menu");
                            break;
                        }
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
                    selectedRoom.addDeviceToRoom(new MotionSensor(name, false)); //default to off
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

    // function for managing the submenu for changing device settings
    private static void deviceSettings(Room room, Scanner input) throws DeviceInactiveException {
        Vector<Device> devices = room.getDeviceList();
        if(devices.isEmpty()){
            System.out.println("No devices to edit.");
            return;
        }
        // list devices
        System.out.println("\nSelect a device to edit:");
        for(int i =0; i < devices.size();i++ ){
            System.out.println((i+1) + ". " + devices.get(i).getName());
        }
        int index = getIntInput(input) - 1;
        if (index < 0 || index >= devices.size()){
            System.out.println("Invalid Selection");
            return;
        }
        Device d = devices.get(index);
        // actual device submenu
        System.out.println("\nSettings for " + d.getName());
        System.out.println("1. Power (Currently " + (d.getStatus() ? "ON" : "OFF") + ")");


        // add the other things from interfaces for device specifics
        // check for speed interface
        // allows fro the current stats to be listed
        if (d instanceof org.cs4a.project1.interfaces.SpeedInterface) {
            int currentSpeed = ((org.cs4a.project1.interfaces.SpeedInterface) d).getSpeed();
            System.out.println("2. Change Speed (Currently: " + currentSpeed + "%)");
        }

        else if (d instanceof org.cs4a.project1.interfaces.TempInterface) {
            double currentTemp = ((org.cs4a.project1.interfaces.TempInterface) d).getTemp();
            System.out.println("2. Change Temperature (Currently: " + currentTemp + "°)");
        }
        System.out.println("Selection: ");

        int choice = getIntInput(input);
        try {
            if (choice == 1) {
                d.setStatus(!d.getStatus());
                System.out.println("Powered " + (d.getStatus() ? "ON" : "OFF"));
            } else if (choice == 2) {
                if (d instanceof org.cs4a.project1.interfaces.SpeedInterface) {
                    System.out.print("Enter new speed: ");
                    ((org.cs4a.project1.interfaces.SpeedInterface) d).setSpeed(getIntInput(input));
                } else if (d instanceof org.cs4a.project1.interfaces.TempInterface) {
                    System.out.print("Enter new temp: ");
                    ((org.cs4a.project1.interfaces.TempInterface) d).setTemp(Double.parseDouble(input.nextLine()));
                }
            }
        } catch (DeviceInactiveException | InvalidSpeedException | InvalidTemperatureException e) {
            System.out.println("ACTION FAILED: " + e.getMessage());
        }
        pause(input);

    }

    //UTILITIES
    //helper function to manage possible input prob
    private static int getIntInput(Scanner input) {
        try { // updated now so it won't be a problem with adding extra buffers and stuff everywhere
            return Integer.parseInt(input.nextLine()); // fixed that variable redundancy
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    // i used same thing that barnett taught us to do for serendipity lol
    public static void clearScreen(){
        System.out.print("\033[H\033[2J"); //use ansi excape code for terminal clear
    }
    // just a screen pause basically
    public static void pause(Scanner input){
        System.out.println("\n(Press Enter to Continue...)");
        if(input.hasNextLine()){
            input.nextLine();
        }
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