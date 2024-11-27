package org.l06gr01.viewer.game;

import org.l06gr01.GUI.GUI;
import org.l06gr01.model.game.Element;
import org.l06gr01.model.game.PlayerShip;

public class PlayerShipViewer implements ElementViewer<PlayerShip> {
    @Override
    public void draw(PlayerShip ship, GUI gui) {
        gui.drawPlayerShip(ship.getPosition());
    }
}

