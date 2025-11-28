package Model;

import java.util.Random;

public class FireModel {

    public final int width;
    public final int height;
    public final int[] temp;
    private final Random rnd = new Random();

    public FireModel(int width, int height) {
        this.width = width;
        this.height = height;
        this.temp = new int[width * height];
    }

    public void addSparks(double chancePerColumn) {
        for (int x = 0; x < width; x++) {

            if (rnd.nextDouble() < chancePerColumn) {

                int index = (height - 1) * width + x;

                int intensity = 400 + rnd.nextInt(500);

                temp[index] = intensity;
            }
        }
    }

    public void update() {
        FireMath.update(this);
    }

}
