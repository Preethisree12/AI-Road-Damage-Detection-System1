import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;

public class DamageDetector {

    public boolean detectDamage(String path) {

        try {

            File file = new File(path);
            BufferedImage image = ImageIO.read(file);

            int width = image.getWidth();
            int height = image.getHeight();

            int darkPixels = 0;

            for (int x = 0; x < width; x++) {

                for (int y = 0; y < height; y++) {

                    int rgb = image.getRGB(x, y);

                    int r = (rgb >> 16) & 0xff;
                    int g = (rgb >> 8) & 0xff;
                    int b = rgb & 0xff;

                    int brightness = (r + g + b) / 3;

                    // Detect only very dark pixels
                    if (brightness < 60) {

                        darkPixels++;

                        // mark pothole area red
                        image.setRGB(x, y, Color.RED.getRGB());

                    }

                }

            }

            int totalPixels = width * height;

            double ratio = (double) darkPixels / totalPixels;

            // Only detect damage if dark pixels are enough
            if (ratio > 0.05) {

                ImageIO.write(image, "jpg", new File("detected_damage.jpg"));
                return true;

            }

        } catch (Exception e) {

            System.out.println("Error reading image: " + e.getMessage());

        }

        return false;
    }

    public void reportDamage(String imagePath) {

        try {

            FileWriter writer = new FileWriter("report.txt", true);

            writer.write("Road damage detected in image: " + imagePath + "\n");

            writer.close();

            System.out.println("Report saved for authorities.");

        } catch (IOException e) {

            System.out.println("Error saving report.");

        }
    }
}