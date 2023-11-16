package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveExample {
    ArrayList<Train> trainList = new ArrayList<>();

    public SaveExample() {
        /*trainList.add(new Train(1, "Happy Train", 5, 50, true));
        trainList.add(new Train(2, "Fast Train", 1, 500900, true));
        trainList.add(new Train(3, "Underground Train", 10, 25, false));
        trainList.add(new Train(4, "Space Train", 999, 999999, true));
        trainList.add(new Train(64, "Fantasy Train", -50, -50, true));*/
        load();
    }

    File trainFolder = new File("trainFolder");
    File trainFile = new File("trainFolder/trainFile.txt");
    String absolutePath = "C:\\Users\\nikla\\source\\java\\OPA23Repetition16Nov";

    Scanner scanner = new Scanner(System.in);
    public void menu() {
        trainFolder.mkdir();
        showTrains();

        System.out.println("Save?");
        String input = scanner.nextLine().toLowerCase();
        if (input.equals("save")) {
            save();
        }
    }

    private void save() {
        try {
            FileWriter fileWriter = new FileWriter(trainFile/*, true*/);
            BufferedWriter bf = new BufferedWriter(fileWriter);
            bf.write("id,name,cartCount,maxSpeed,inUse"); // First column just to show what each columns mean.
            for (Train train: trainList) {
                bf.newLine();
                bf.write(train.getCSV());
            }
            bf.close();
        } catch (IOException e) {

        }
    }

    private void load() {
        try {
            FileReader fileReader = new FileReader(trainFile);
            BufferedReader bf = new BufferedReader(fileReader);

            bf.readLine(); // Just to get rid of the first line that is not an object.
            String line = bf.readLine();
            while (line != null) { // 1,Happy Train,5,50,true
                String[] variables = line.split(",");

                int id = Integer.parseInt(variables[0]);
                String name = variables[1];
                int cartCount = Integer.parseInt(variables[2]);
                int maxSpeed = Integer.parseInt(variables[3]);
                boolean inUse = Boolean.parseBoolean(variables[4]);

                Train train = new Train(id, name, cartCount, maxSpeed, inUse);
                trainList.add(train);

                line = bf.readLine();
            }

            bf.close();
        } catch (IOException e) {

        }
    }

    private void showTrains() {
        for (Train train: trainList) {
            System.out.println(train.toString());
        }
    }
}
