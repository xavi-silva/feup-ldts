package org.l06gr01.viewer.game;

import org.l06gr01.GUI.GUI;
import org.l06gr01.model.game.Element;
import org.l06gr01.model.game.InvaderShip;

public class InvaderShipViewer implements ElementViewer<InvaderShip>{
    @Override
    public void draw(InvaderShip ship, GUI gui) {
        gui.drawInvaderShip(ship.getPosition());
    }
}
