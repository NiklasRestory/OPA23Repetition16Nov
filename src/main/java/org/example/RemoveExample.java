package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveExample {
    ArrayList<Train> trainList = new ArrayList<>();

    public RemoveExample() {
        trainList.add(new Train(1, "Happy Train", 5, 50, true));
        trainList.add(new Train(2, "Fast Train", 1, 500900, true));
        trainList.add(new Train(3, "Underground Train", 10, 25, false));
        trainList.add(new Train(4, "Space Train", 999, 999999, true));
        trainList.add(new Train(64, "Fantasy Train", -50, -50, true));
    }
    Scanner scanner = new Scanner(System.in);
    public void menu() {
        System.out.println("List as it looks before");
        showTrains();

        System.out.println("Which ID would you like to remove?");
        String inputString = scanner.nextLine().toLowerCase();
        try {
            int input = Integer.parseInt(inputString);

            // foreach loop is very determined to run once per item in the list/array
            // If a list changes size while it is being foreached over, it will crash.
            /*for (Train train: trainList) {
                if (input == train.getId()) {
                    trainList.remove(train); // Throws a ConcurrentModificationException!
                }
            }*/

            boolean found = false;

            // So if you're going to remove an item from the list being looped over,
            // use a for-loop instead.
            for(int i = 0; i < trainList.size(); i++) {
                if (input == trainList.get(i).getId()) {
                    found = true;
                    trainList.remove(i);
                    i--; // If we remove the item at index 2, the item at index 3 is the new index 2.
                    // To ensure we don't jump over the new index 2 when i++ happens, reduce i with 1
                    // when we remove an item.
                    // break; // Or, if we only wanted to remove one item, end the loop with break.
                    System.out.println("Train with id " + input + " has been removed!");
                }
            }

            if (found == false) {
                System.out.println("No item with that ID was found.");
            }

        }
        catch (Exception ex) {
            System.out.println(ex);
        }

        System.out.println("List as it looks after");
        showTrains();
    }

    private void showTrains() {
        for (Train train: trainList) {
            System.out.println(train.toString());
        }
    }
}
