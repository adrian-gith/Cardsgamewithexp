package service;

import Entity.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class CardService {

    public List<Card> getStarterPack() {
        List<Card> starterPack = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            starterPack.add(generateCard());
        }

        return starterPack;
    }

    public Card generateCard() {
        Random random = new Random();
        String[] names = {"Fighter", "Mage", "Ninja", "Mambo", "Dragon", "Subi", "Adko", "WhiteDragon", "Snake", "Monkey"};
        String cardName = names[random.nextInt(names.length - 1)];
        int cardAttack = random.nextInt(10);
        int cardDefence = random.nextInt(10);
        return new Card(cardName, cardAttack, cardDefence);
    }
}
