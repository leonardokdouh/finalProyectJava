package utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import model.people.People;
import model.people.Workers;
import services.ProductGenericServices;
import utils.exceptions.ExceptionChoose;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UsersUtils {
    private static final Scanner scanner = new Scanner(System.in);
    static File output = new File("workerFile.json");
    static ObjectMapper mapper = new ObjectMapper();

    static boolean systemIsRunning = true;

    public static void runner() throws IOException, InterruptedException {
        // intro();

        while (systemIsRunning) {
            System.out.println("\nPLEASE CHOOSE AN OPTION");
            System.out.println("1 --> FOR PRODUCT's MENU");
            System.out.println("2 --> FOR PEOPLE's MENU");
            System.out.println("3 --> FOR QUIT THE APP");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("PRODUCT'S MENU");
                    productsMenu();
                    break;
                case 2:
                    System.out.println("PEOPLE MENU");
                    personsMenu();
                    break;
                case 3:
                    System.out.println("Thanks for your visit");
                    systemIsRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        System.out.println("Closing the program..");
        scanner.close();
    }


    public static int peopleSubMenu() {
        int option = 0;

        System.out.println("\nWelcome to the Worker's database");
        System.out.println("\nChose the option below:\n" + "Opcion 1: Print registry\n"
                + "Option 2:Add a worker\n"
                + "Option 3:Add more than one worker \n" + "Option 4:Get Back to Home Menu \n ");
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You entered a wrong number");
        }
        if (option > 4) {
            throw new ExceptionChoose("\n" + "You enter a invalid option. Come back later");
        }

        return option;
    }

    public static void personsMenu() throws IOException {
        boolean getBack = true;

        while (getBack) {
            WorkersBuilder builder = new WorkersBuilder();
            switch (peopleSubMenu()) {
                case 1:
                    System.out.println("Workers Menu");
                    break;
                case 2:
                    System.out.println("Workers creation");
                    mapper.writeValue(output, builder.workerCreation());
                    People p = mapper.readValue(output, Workers.class);
                    System.out.println("Worker added successfully");
                    break;
                case 3:
                    builder.repeatCreation();
                    break;
                case 4:
                    getBack = false;
                    System.out.println("Going back to HOME MENU");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }
    }

    public static void productsMenu() {
        boolean getBack = true;
        ProductGenericServices newService = new ProductGenericServices();
        GamesBuilder gamesBuilder = new GamesBuilder();

        System.out.println("\nWELCOME TO PRODUCT's MENU");

        while (getBack) {
            System.out.println("1 --> PRINT THE AVAILABLE PRODUCTS");
            System.out.println("2 --> RENT A PRODUCT");
            System.out.println("3 --> RETURN A PRODUCT");
            System.out.println("4 --> UPDATE A PRODUCT");
            System.out.println("5 --> GET BACK TO HOME MENU");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("THIS ARE ALL THE AVAILABLE TITLES FOR RENTING");
                    newService.showList();
                    System.out.println("\nWHAT DO YOU WANT TO DO NEXT?");
                    break;
                case 2:
                    System.out.println("CHOOSE AN OPTION FOR RENT");
                    newService.showList();
                    newService.deleteGameByName(gamesBuilder.deleteGame());
                    System.out.println("\nPLEASE NOW CHOOSE ANOTHER OPTION");
                    break;
                case 3:
                    System.out.println("RETURNING A GAME? ADD IT TO THE LIST");
                    newService.add(gamesBuilder.gameReturning());
                    System.out.println("\nPLEASE NOW CHOOSE ANOTHER OPTION");
                    break;
                case 4:
                    System.out.println("CHOOSE AN OPTION TO UPDATE A GAME");
                    System.out.println("THIS ARE THE GAMES AVAILABLES NOW");
                    newService.showList();
                    newService.update(gamesBuilder.updateGameIndex(), gamesBuilder.updateGame());
                    System.out.println("\nPLEASE NOW CHOOSE ANOTHER OPTION");
                    break;
                case 5:
                    getBack = false;
                    System.out.println("Going back to HOME MENU");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


    public static void intro() throws InterruptedException {
        System.out.println("Bienvenido, aguarde que el sistema termine de cargar");
        for (int i = 1; i < 101; i++) {
            System.out.print(i + "% ... ");
            if (i % 10 == 0) {
                System.out.println();
                Thread.sleep(1000);
            }
        }
        System.out.println("Sistema cargado correctamente");
        Thread.sleep(1000);

        for (int i = 1; i < 24; i++) {
            System.out.println("");
        }
    }
}


