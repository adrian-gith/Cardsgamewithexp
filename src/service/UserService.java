package service;

import Entity.Card;
import Entity.Map;
import Entity.User;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private CardService cardService;
    private List<User> registeredUsers;
    private User loggedUser;
    private FieldService fieldService;

    public UserService() {
        this.registeredUsers = new ArrayList<>();
        this.cardService = new CardService();
        this.fieldService = new FieldService();
    }

    public void registerUser(String username, String password, String repeatPassword) {
        if (username.length() < 3) {
            System.out.println("username must be longer than 3 symbols");
            return;
        }
        if (password.length() < 3) {
            System.out.println("password must be longer that 3 symbols");
            return;
        }
        if (!repeatPassword.equals(password)) {
            System.out.println("repeatPassword must be the same as password");
            return;
        }
        User currentUser = new User(username, password);
        boolean isThisUserRegistered = checkIfThisUserExists(currentUser);
        if (isThisUserRegistered) {
            System.out.println("This user is already registered");
            return;
        }
        currentUser.setCards(this.cardService.getStarterPack());
        this.registeredUsers.add(currentUser);
        System.out.println("user is registered");
    }

    public List<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void loginUser(String username, String password) {
        Optional<User> user = registeredUsers.stream()
                .filter(currentUser -> currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password))
                .findFirst();

        if (user.isEmpty()) {
            System.out.println("invalid credentials");
            return;
        }
        if (loggedUser != null) {
            System.out.println("user already logged in");
            return;
        }
        loggedUser = user.get();
        System.out.println("logged in");
    }

    private boolean checkIfThisUserExists(User user) {
        return registeredUsers.contains(user);
    }

    public void printMyCards() {
        this.loggedUser.getCards().forEach(card -> {
            System.out.println("card name: " + card.getName() + " Attack: " + card.getAttack() + " defense: " + card.getDefense());
        });
    }

    public void printMyPoints() {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMinimumFractionDigits(2);
        decimalFormat.setMaximumFractionDigits(2);

        System.out.println("your points are: " + decimalFormat.format(this.loggedUser.getPoints()));
        System.out.println("you exp points are " + decimalFormat.format(this.loggedUser.getExperience()));
    }

    public void duel() {
        Map map = new Map();
        map.fillMap(this.fieldService.createMap(this.loggedUser));

        for (Card[] cards : map.getMap()) {
            for (Card card : cards) {
                System.out.printf("%s %d/%d | ", card.getName(), card.getAttack(), card.getDefense());
            }
            System.out.println();
        }
        FieldService.fight(map, loggedUser);
    }

}
