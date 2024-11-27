package org.l06gr01.viewer.game;

import org.l06gr01.GUI.GUI;
import org.l06gr01.model.game.Element;
import org.l06gr01.model.game.space.Space;

import java.io.IOException;

public class SpaceViewer implements ElementViewer<Space>{
    @Override
    public void draw(Space space, GUI gui) throws IOException {
            try {
                gui.drawSpace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
