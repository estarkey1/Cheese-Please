public class RunStrategy implements MovementStrategy {
    private static final int RUN_CHANCE = 10;
    private static final int RUN_TURN_COST = 1;

    @Override
    public boolean move(int cooksPresent) {
        int chance = RUN_CHANCE * cooksPresent;
        return RandomSingleton.getInstance().nextInt(100) >= chance;
    }

    @Override
    public int getTurnCost() {
        return RUN_TURN_COST;
    }
}
