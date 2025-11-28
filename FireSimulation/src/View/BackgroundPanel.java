package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class BackgroundPanel extends JPanel {

    private BufferedImage img;

    public BackgroundPanel(String path) {
        try {
            img = ImageIO.read(new File(path));
        } catch (Exception e) {
            System.out.println("Failed to load background image: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        }
    }
}
