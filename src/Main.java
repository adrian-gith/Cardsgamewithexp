import service.UserService;

import java.util.Scanner;

public class Main {
    private static final String REGISTER_COMMAND = "register";
    private static final String LOGIN_COMMAND = "login";
    private static final String CARDS_COMMAND = "cards";
    private static final String POINTS_COMMAND = "points";
    private static final String DUEL_COMMAND = "duel";

    private static UserService userService;

    public static void main(String[] args) {
        userService = new UserService();

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!"stop".equals(input)) {
            String[] commandParts = input.split(" ");
            String command = commandParts[0];

            switch (command) {
                case REGISTER_COMMAND:
                    if (commandParts.length != 4) {
                        System.out.println("invalid arguments");
                    } else {
                        userService.registerUser(commandParts[1], commandParts[2], commandParts[3]);
                    }
                    break;
                case LOGIN_COMMAND:
                    userService.loginUser(commandParts[1], commandParts[2]);
                    break;
                case CARDS_COMMAND:
                    userService.printMyCards();
                    break;
                case POINTS_COMMAND:
                    userService.printMyPoints();
                    break;
                case DUEL_COMMAND:
                    userService.duel();
                    break;
                default:
                    System.out.println("No such command");
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
