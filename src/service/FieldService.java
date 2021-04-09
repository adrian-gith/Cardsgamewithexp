package service;

import Entity.Card;
import Entity.Map;
import Entity.User;

public class FieldService {

    public static void fight(Map map, User currentUser) {
        int myPoints = 0;
        int enemyPoints = 0;
        System.out.println();
        System.out.println("FIGHT");
        currentUser.setExperienceViaDuel();
        for (int i = 0; i < 5; i++) {
            System.out.println("ROUND " + (i + 1));
            int myCardPower = map.getMyField()[i].getPower();
            int enemyCardPower = map.getEnemyField()[i].getPower();
            if (myCardPower < enemyCardPower) {
                enemyPoints++;
                System.out.println(" --- You have lost this round!");
            } else if (myCardPower > enemyCardPower) {
                myPoints++;
                System.out.println(" --- You have won this round!");
            } else {
                enemyPoints++;
                myPoints++;
                System.out.println(" --- Draw!");
            }
        }
        System.out.println();
        if (myPoints > enemyPoints) {
            System.out.println("Congratulations, you have won the duel");
            currentUser.setPointsViaDuel();
        } else if (myPoints < enemyPoints) {
            System.out.println("Sorry, you have lost this duel");
            currentUser.setPoints(currentUser.getPoints() - 10);
        } else {
            System.out.println("Your result is draw");
        }

        if(currentUser.getPoints() <= 0) {
            System.out.println("You have lost the game!");
            System.exit(0);
        }
        if(currentUser.getPoints() >= 100) {
            System.out.println("You won the game");
            System.exit(0);
        }
    }

    public Card[][] createMap(User loggedUser) {
        CardService cardService = new CardService();

        Card[][] map = new Card[2][5];
        for (int i = 0; i < 5; i++) {
            map[0][i] = loggedUser.getCards().get(i);
        }

        for (int i = 0; i < 5; i++) {
            map[1][i] = cardService.generateCard();
        }

        return map;
    }


}
