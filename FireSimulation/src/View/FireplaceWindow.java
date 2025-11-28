package View;

import Model.FireModel;
import Model.FireColor;

import javax.swing.*;
import java.awt.*;

public class FireplaceWindow {

    private final FireView fireView;

    public FireplaceWindow(FireModel model, FireColor colors, int pixelSize) {

        this.fireView = new FireView(model, colors, pixelSize);
        BackgroundPanel background = new BackgroundPanel("fireplace.png");

        int fireX = 215;
        int fireY = 440;
        int fireW = 320;
        int fireH = 70;

        int BG_WIDTH = 768;
        int BG_HEIGHT = 768;

        JLayeredPane layers = new JLayeredPane();
        layers.setLayout(null);
        layers.setPreferredSize(new Dimension(BG_WIDTH, BG_HEIGHT));

        background.setBounds(0, 0, BG_WIDTH, BG_HEIGHT);
        fireView.setBounds(fireX, fireY, fireW, fireH);

        layers.add(background, JLayeredPane.DEFAULT_LAYER);
        layers.add(fireView, JLayeredPane.PALETTE_LAYER);

        JFrame frame = new JFrame("Llamita");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setContentPane(layers);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public FireView getFireView() {
        return fireView;
    }
}
