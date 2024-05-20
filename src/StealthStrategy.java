public class StealthStrategy implements MovementStrategy {
    private static final int STEALTH_CHANCE = 5;
    private static final int STEALTH_TURN_COST = 3;

    @Override
    public boolean move(int cooksPresent) {
        int chance = STEALTH_CHANCE * cooksPresent;
        return RandomSingleton.getInstance().nextInt(100) >= chance;
    }

    @Override
    public int getTurnCost() {
        return STEALTH_TURN_COST;
    }
}
