package Model;

public class FireMath {

    public static void update(FireModel model) {

        int[] temp = model.temp;
        int width = model.width;
        int height = model.height;

        for (int actualRow = height - 2; actualRow > 4; actualRow--) {

            int iniRow = width * actualRow;
            int iniBelowRow = iniRow + width;

            for (int actualCol = 2; actualCol < width - 2; actualCol++) {

                int pos = iniRow + actualCol;
                int posBelow = iniBelowRow + actualCol;

                int newTemp = (int) (
                        (temp[pos - 1] * 1.2 +
                                temp[pos] * 1.5 +
                                temp[pos + 1] * 1.2 +
                                temp[posBelow - 1] * 0.7 +
                                temp[posBelow] * 0.7 +
                                temp[posBelow + 1] * 0.7)
                                / 5.98569
                                - 1.8
                );

                if (newTemp < 0) newTemp = 0;
                if (newTemp > 1023) newTemp = 1023;

                temp[pos] = newTemp;
            }
        }
    }
}
