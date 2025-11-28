
import Controller.FireController;
import Model.FireColor;
import Model.FireModel;
import View.FireplaceWindow;



public class Main {

    public static void main(String[] args) {

        int W = 100;
        int H = 100;
        int PIXEL = 4;

        FireModel model = new FireModel(W, H);
        FireColor colors = new FireColor();

        FireplaceWindow window = new FireplaceWindow(model, colors, PIXEL);
        FireController controller = new FireController(model, window.getFireView());

        controller.start();
    }
}
