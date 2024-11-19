package utils;

import model.people.Workers;
import utils.enums.Shifts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class WorkersBuilder {

    private static Scanner scan = new Scanner(System.in);
    private String name;

    private Integer id;

    private String lastName;

    private String email;
    private int age;
    private Integer socialSecurityNumber;

    private Shifts shift;


    private static List<Workers> newWorkersList = new ArrayList<>();

    public Workers workerCreation() {
        EmailValidator validator = new EmailValidator();

        System.out.println("So, you are a new Worker, please tell me your name");
        name = scan.nextLine();

        System.out.println("Last name?");
        lastName = scan.nextLine();

        System.out.println("Your Social Security Number?");
        socialSecurityNumber = scan.nextInt();
        scan.skip("\n");

        System.out.println("Your id?");
        id = scan.nextInt();
        scan.skip("\n");

        System.out.println("Now enter your email");
        email = validator.checkMail(scan.nextLine());

        System.out.println("And finally please tell me your age");
        age = scan.nextInt();

        if (id % 2 == 0) {
            shift = Shifts.MORNING;
        } else {
            shift = Shifts.EVENING;
        }

        Workers newUser = new Workers(socialSecurityNumber, id, name, lastName, age, email, shift);

        return newUser;
    }


    public void repeatCreation() {
        Integer answer = null;
        newWorkersList.add(workerCreation());
        System.out.println("Do you want to create a new one? Press 1 for Yes");
        answer = scan.nextInt();
        scan.skip("\n");


        if (answer == 1) {
            newWorkersList.add(workerCreation());
        }

        System.out.println("Do you want to print the added workers?Press 1 for Yes");
        answer = scan.nextInt();
        scan.skip("\n");

        if (answer == 1) {
            printCreationResults();
        }
    }

    public void printCreationResults() {
        for (Workers workers : newWorkersList) {
            System.out.println(workers);
        }
    }


}

