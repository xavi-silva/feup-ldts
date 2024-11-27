package org.l06gr01.viewer.game;
import org.l06gr01.GUI.GUI;
import org.l06gr01.model.Position;
import org.l06gr01.model.game.PlayerShip;

import java.io.IOException;

public class HealthViewer implements ElementViewer<PlayerShip>{
    @Override
    public void draw(PlayerShip element, GUI gui) throws IOException {
        gui.drawHealth(new Position(1,0),element.getHealth());
    }
}
