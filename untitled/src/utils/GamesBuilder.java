package utils;

import model.people.Workers;
import model.products.GamingProducts;
import utils.enums.GamingConsoles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamesBuilder {
    private static Scanner scan = new Scanner(System.in);

    Scanner scanner = new Scanner(System.in);

    private Integer id;
    private String name;

    private GamingConsoles console;
    private int price;
    private int days;

    public GamingProducts gameReturning() {
        System.out.println("Returning a game? give me the name");
        name = scan.nextLine();

        System.out.println("ID of the game please");
        id = scan.nextInt();
        scan.skip("\n");

        System.out.println("Price that was paid?");
        price = scan.nextInt();
        scan.skip("\n");

        System.out.println("Finally how many days");
        days = scan.nextInt();
        scan.skip("\n");

        if (days % 2 == 0) {
            console = GamingConsoles.PS5;
        } else {
            console = GamingConsoles.XBOX;
        }

        GamingProducts newGame = new GamingProducts(id, console, name, price, days);

        return newGame;
    }


    public List<GamingProducts> gamesLoader() {
        List<GamingProducts> gamesStock = new ArrayList<>();
        GamingProducts product1 = new GamingProducts(1, GamingConsoles.PS5, "Lord", 23, 5);
        GamingProducts product2 = new GamingProducts(2, GamingConsoles.PS5, "TheOffice", 11, 4);
        GamingProducts product3 = new GamingProducts(3, GamingConsoles.PS5, "Avatar", 165, 16);
        GamingProducts product4 = new GamingProducts(4, GamingConsoles.PS5, "StarWar", 23, 12);
        GamingProducts product5 = new GamingProducts(5, GamingConsoles.PS5, "Frodo", 63, 3);

        gamesStock.add(product1);
        gamesStock.add(product2);
        gamesStock.add(product3);
        gamesStock.add(product4);
        gamesStock.add(product5);

        return gamesStock;
    }

    public String deleteGame() {
        String answer = null;
        System.out.println("Do you want to delete a Game? Please write the name\n");
        answer = scanner.nextLine();
        return answer;
    }

    public String  updateGameIndex() {
        String answer = "";
        System.out.println("\nDo you want to update a Game? Please insert the name");
        answer = scanner.nextLine();
        return answer;
    }


    public GamingProducts updateGame() {
        System.out.println("Update a game? give me the name");
        name = scan.nextLine();

        System.out.println("ID of the game please");
        id = scan.nextInt();
        scan.skip("\n");

        System.out.println("Price?");
        price = scan.nextInt();
        scan.skip("\n");

        System.out.println("Days for rent");
        days = scan.nextInt();
        scan.skip("\n");

        if (days % 2 == 0) {
            console = GamingConsoles.PS5;
        } else {
            console = GamingConsoles.XBOX;
        }

        GamingProducts newGame = new GamingProducts(id, console, name, price, days);
        return newGame;
    }


}

