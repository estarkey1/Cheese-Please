public interface MovementStrategy {
    boolean move(int cooksPresent);
    int getTurnCost();
}

