package org.l06gr01;

import org.l06gr01.GUI.LanternaGUI;
import org.l06gr01.states.MenuState;
import org.l06gr01.states.State;

import org.l06gr01.model.menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class Game {

    private State state;
    private final LanternaGUI gui;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(90, 30);
        this.state = new MenuState(new Menu());
    }
    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }
    public void setState(State state) {
        this.state = state;
    }

    public LanternaGUI getGui() {
        return gui;
    }

    private void start() throws IOException {
        int FPS = 24;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }

}
