package View;

import Model.FireColor;
import Model.FireModel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FireView extends JPanel {

    private final FireModel model;
    private final FireColor colors;

    public FireView(FireModel model, FireColor colors, int pixelSize) {
        this.model = model;
        this.colors = colors;
        setOpaque(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int simW = model.width;
        int simH = model.height;
        int[] temp = model.temp;

        int panelW = getWidth();
        int panelH = getHeight();

        
        int sliceHeight = 40;               
        int startRow = simH - sliceHeight;
        if (startRow < 0) startRow = 0;

        
        BufferedImage flameImage = new BufferedImage(simW, sliceHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = flameImage.createGraphics();

        for (int y = 0; y < sliceHeight; y++) {
            for (int x = 0; x < simW; x++) {

                int tempIndex = (startRow + y) * simW + x;
                Color c = colors.get(temp[tempIndex]);

                if (c.getAlpha() == 0) continue;

                flameImage.setRGB(x, y, c.getRGB());
            }
        }

        g2.dispose();

        
        Graphics2D gFinal = (Graphics2D) g;
        gFinal.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        gFinal.drawImage(flameImage, 0, 0, panelW, panelH, null);
    }
}
