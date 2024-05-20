import java.util.Scanner;

public class ScannerSingleton {
    private static final Scanner instance = new Scanner(System.in);

    private ScannerSingleton() {}

    public static Scanner getInstance() {
        return instance;
    }
}
