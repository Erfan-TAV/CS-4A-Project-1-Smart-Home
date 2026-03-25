package org.cs4a.project1;

import org.cs4a.project1.exceptions.RoomNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Manager roomManager = new Manager();

        roomManager.addRoom(new Room("bathroom"));

        try {
            System.out.print(roomManager.getRoom("bathroom").getName());
        } catch (RoomNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}