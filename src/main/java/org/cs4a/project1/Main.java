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
                        System.out.print("Enter name of room to remove: ");
                        try {
                            roomManager.removeRoom(input.nextLine());
                            System.out.println("Room removed.");
                        } catch (RoomNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3: //manage devs by room
                        System.out.println("Listing Device Statuses...");
                        manageRoomDevices(roomManager, input);
                        break;
                    case 4: // list all the stuff
                        if (roomManager.getRoomList().isEmpty()) {
                            System.out.println("No rooms found.");
                        } else {
                            for (Room r : roomManager.getRoomList()) {
                                System.out.println("[" + r.getName() + "]");
                                if (r.getDeviceList().isEmpty()) System.out.println("  (No devices)");
                                for (Device d : r.getDeviceList()) {
                                    System.out.println("  - " + d.getName() + " (" + (d.getStatus() ? "ON" : "OFF") + ")");
                                }
                            }
                        }
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
    // function for managing the submenu to add a specific device
    private static void manageRoomDevices(Manager manager, Scanner input) {
        System.out.print("Which room would you like to manage? ");
        String roomName = input.nextLine();

        try {
            Room selectedRoom = manager.getRoom(roomName);
            int deviceChoice = 0;

            while (deviceChoice != 4) {
                //print management menu
                System.out.println("\n--- Managing " + selectedRoom.getName() + " ---");
                System.out.println("1. Add SmartLight");
                System.out.println("2. Add Fan");
                System.out.println("3. Remove a Device");
                System.out.println("4. Back to Main Menu");
                System.out.print("Selection: ");

                deviceChoice = getIntInput(input);
                // device managemtn choices
                if (deviceChoice == 1) {
                    System.out.print("Enter Light Name: ");
                    String name = input.nextLine();
                    selectedRoom.addDeviceToRoom(new SmartLight(true, name, true, 100, 1));
                } else if (deviceChoice == 2) {
                    System.out.print("Enter Fan Name: ");
                    String name = input.nextLine();
                    selectedRoom.addDeviceToRoom(new Fan(true, name, 50));
                } else if (deviceChoice == 3) {
                    System.out.print("Enter device name to remove: ");
                    selectedRoom.removeDeviceFromRoom(input.nextLine());
                    System.out.println("Device removed.");
                }
            }
        } catch (RoomNotFoundException | DeviceNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
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