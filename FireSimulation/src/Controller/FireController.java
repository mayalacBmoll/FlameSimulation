package Controller;

import Model.FireModel;
import View.FireView;

public class FireController {

    private final FireModel model;
    private final FireView view;
    private boolean running = true;

    public FireController(FireModel model, FireView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        Thread loop = new Thread(() -> {
            while (running) {

                model.addSparks(0.009);        
                model.update();         

                view.repaint();

                try { Thread.sleep(30); }
                catch (InterruptedException ignored) {}
            }
        });

        loop.start();
    }

    public void stop() {
        running = false;
    }
}
