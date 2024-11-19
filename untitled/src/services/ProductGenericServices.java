package services;

import model.products.GamingProducts;
import utils.GamesBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductGenericServices {
    GamesBuilder gb = new GamesBuilder();

    private List<GamingProducts> listOfGames = gb.gamesLoader();

    Scanner scanner = new Scanner(System.in);

    public void add(GamingProducts item) {
        listOfGames.add(item);
    }

    // Update
    public void update(String name, GamingProducts item) {
            listOfGames.set(getGamePosition(name), item);
    }

    public Integer getGamePosition(String gameName) {
        int position = 0;

        for (int i = 0; i < listOfGames.size(); i++) {
            if (listOfGames.get(i).getName().equalsIgnoreCase(gameName)) {
                position = i;
            }
        }
        return position;
    }


    public void showList() {
        for (GamingProducts item : listOfGames) {
            System.out.println(item);
        }
    }


    public void deleteGameByName(String gameName) {
        for (int i = 0; i < listOfGames.size(); i++) {
            if (listOfGames.get(i).getName().equalsIgnoreCase(gameName)) {
                listOfGames.remove(i);
                System.out.println("Game '" + gameName + "' has been deleted.");
                return; // Exit after deleting the first match
            }
        }
        System.out.println("Game '" + gameName + "' not found.");
    }

}
