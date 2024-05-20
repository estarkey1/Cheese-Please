import java.util.Random;
import java.util.Scanner;

public class RandomSingleton {
    private static final Random instance = new Random();

    private RandomSingleton() {}

    public static Random getInstance() {
        return instance;
    }
}

