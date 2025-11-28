package Model;

import java.awt.*;
import java.util.ArrayList;

public class FireColor {

    private final ArrayList<Color> palette = new ArrayList<>();

    public FireColor() {
        generate();
    }

    public Color get(int temp) {
    int index = Math.min(255, Math.max(0, temp / 4));
    Color base = palette.get(index);

    
    int alpha = temp == 0 ? 0 : Math.min(255, temp / 4);

    return new Color(base.getRed(), base.getGreen(), base.getBlue(), alpha);
}


    private void generate() {
        Color[] base = {
                new Color(0,0,0),
                new Color(120,0,0),
                new Color(255,0,0),
                new Color(255,160,0),
                new Color(255,255,0),
                new Color(255,255,255)
        };

        for (int i = 0; i < 256; i++) {
            float p = i / 255f;
            float scaled = p * (base.length - 1);
            int idx = (int) scaled;
            float t = scaled - idx;
            if (idx >= base.length - 1) idx = base.length - 2;

            Color a = base[idx], b = base[idx + 1];
            int r = (int)(a.getRed() * (1-t) + b.getRed() * t);
            int g = (int)(a.getGreen() * (1-t) + b.getGreen() * t);
            int bC = (int)(a.getBlue() * (1-t) + b.getBlue() * t);

            palette.add(new Color(r, g, bC));
        }
    }
}
