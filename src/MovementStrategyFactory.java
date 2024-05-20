public class MovementStrategyFactory {
    public static MovementStrategy getStrategy(int choice) {
        switch (choice) {
            case 1:
                return new StealthStrategy();
            case 2:
                return new WaitStrategy();
            case 3:
                return new RunStrategy();
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }
}
