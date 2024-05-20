public class WaitStrategy implements MovementStrategy {
    private static final int WAIT_TURN_COST = 1;

    @Override
    public boolean move(int cooksPresent) {
        // Waiting does not move the player to the next room
        System.out.println("You decide to wait to see if the cooks leave...");
        System.out.println("The cooks are filtering out...");
        return true;
    }

    @Override
    public int getTurnCost() {
        return WAIT_TURN_COST;
    }
}
