package life;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Input Universe Size: ");
        int size = scr.nextInt();
        System.out.print("Input Random Seed: ");
        long seed = scr.nextLong();
        System.out.print("Input Number of Generation: ");
        int numberOfGenerations = scr.nextInt();

        Universe universe = new Universe(size);

        // Fill universe with random stuffs
        Random random = new Random(seed);
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                universe.setAt(x, y, random.nextBoolean());
            }
        }

        boolean[][] currentState = universe.getState();
        
        refresh(1000);

        for (int i = 1; i < numberOfGenerations; i++) {
            refresh(500);
            Generator generator = new Generator(currentState);
            generator.generateNext();
            currentState = generator.getOutputState();
            universe.setState(currentState);
            System.out.println("Generation #" + i);
            System.out.println("Alive #" + universe.countAlive());
            universe.draw();
        }
    }

    private static void refresh(long delay) {
        try {
            TimeUnit.MILLISECONDS.sleep(delay);
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                // Doesn't work
                // Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException e) {}
    }
            
}

