import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("AI Road Damage Detection System");

        System.out.println("Enter image path (example: images/road.jpg): ");
        String path = scanner.nextLine();

        DamageDetector detector = new DamageDetector();

        boolean result = detector.detectDamage(path);

        if (result) {
            System.out.println("⚠ Road Damage Detected!");
            detector.reportDamage(path);
        } else {
            System.out.println("✅ Road is Good.");
        }

        scanner.close();
    }
}