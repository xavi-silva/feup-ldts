package org.l06gr01.viewer.game;

import org.l06gr01.GUI.GUI;
import org.l06gr01.model.Position;
import org.l06gr01.model.game.Barrier;

import java.io.IOException;

public class BarrierViewer implements ElementViewer<Barrier> {
    @Override
    public void draw(Barrier element, GUI gui) throws IOException {
        gui.drawBarrier(element.getPosition());
    }
}
