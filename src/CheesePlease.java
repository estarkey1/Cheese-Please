import java.util.Scanner;

public class CheesePlease {
    private static final int MAX_TURNS = 5;
    private static final String[] ROOM_NAMES = {"Dish Pit", "Prep Room", "Main Kitchen", "Cheese Freezer"};
    private static final int[] MAX_COOKS = {4, 4, 6, 2};

    private int turnsLeft;
    private int currentRoomIndex;

    public CheesePlease() {
        this.turnsLeft = MAX_TURNS;
        this.currentRoomIndex = 0;
    }

    public void startGame() {
        System.out.println("Welcome to Cheese Please! You are a hungry rat.\nYou have 5 turns to make it to the cheese freezer before you starve.\n If you stealth, you have a 5% chance to be seen by each cook, but you use up 3 turns, as it's much slower.\n If you run, you use one turn, but you have a 10% chance to be seen by each cook.\n You can also wait for cooks to leave, which takes one turn. But be careful, if you wait, more cooks might enter the room!\nThe more cooks there are in a room, the likelier you are to get caught.");
        while (turnsLeft > 0 && currentRoomIndex < ROOM_NAMES.length - 1) {
            System.out.println("Current room: " + ROOM_NAMES[currentRoomIndex]);
            System.out.println("Turns left: " + turnsLeft);
            int cooksPresent = getCooksPresent();
            System.out.println("Cooks present: " + cooksPresent);
            System.out.println("Choose your movement: 1. Stealth 2. Wait 3. Run");
            int choice = getUserChoice();
            try {
                MovementStrategy strategy = MovementStrategyFactory.getStrategy(choice);
                if (strategy.move(cooksPresent)) {
                    if (!(strategy instanceof WaitStrategy)) {
                        System.out.println("Successfully moved to the next room!");
                        currentRoomIndex++;
                    }
                    turnsLeft -= strategy.getTurnCost();
                } else {
                    gameOverByCooks();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid choice, try again.");
            }
        }
        if (currentRoomIndex == ROOM_NAMES.length - 1) {
            System.out.println("Congratulations! You reached the Cheese Freezer and got your precious piece of cheese. You win!");
        } else {
            gameOverByTurns();
        }
    }

    private int getUserChoice() {
        Scanner scanner = ScannerSingleton.getInstance();
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter 1, 2, or 3.");
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextInt();
    }

    private int getCooksPresent() {
        int maxCooks = MAX_COOKS[currentRoomIndex];
        return RandomSingleton.getInstance().nextInt(maxCooks + 1);
    }

    private void gameOverByCooks() {
        System.out.println("Game over! You were caught by the cooks.");
        System.exit(0);
    }

    private void gameOverByTurns() {
        System.out.println("Game over! You ran out of turns and starved.");
        System.exit(0);
    }

    public static void main(String[] args) {
        CheesePlease game = new CheesePlease();
        game.startGame();
    }
}

