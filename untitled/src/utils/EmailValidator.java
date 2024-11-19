package utils;

import utils.exceptions.ExceptionMail;

import java.util.Scanner;

public class EmailValidator {

    public String checkMail(String mail) throws ExceptionMail {
        String validEmail = null;
        try {
            validEmail = getEmailInput();
            System.out.println("Valid email entered: " + validEmail);
        } catch (ExceptionMail e) {
            System.err.println(e.getMessage());
        }
        return validEmail;
    }

    public static String getEmailInput() throws ExceptionMail {
        Scanner scanner = new Scanner(System.in);
        String email;

        while (true) {
            System.out.print("Please enter a valid email address: ");
            email = scanner.nextLine();

            try {
                validateEmail(email);
                break; // Exit the loop if the email is valid
            } catch (ExceptionMail e) {
                System.out.println(e.getMessage());
            }
        }

        return email;
    }

    private static void validateEmail(String email) throws ExceptionMail {
        if (email.length() <= 3 || !email.contains("@")) {
            throw new ExceptionMail("Invalid email. It must be more than 3 characters and contain an '@' symbol.");
        }
    }
}
