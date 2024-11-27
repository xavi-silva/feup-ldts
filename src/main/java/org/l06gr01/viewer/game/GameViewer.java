package org.l06gr01.viewer.game;

import org.l06gr01.GUI.GUI;
import org.l06gr01.model.Position;
import org.l06gr01.model.game.Element;
import org.l06gr01.model.game.Score;
import org.l06gr01.model.game.space.Space;
import org.l06gr01.viewer.Viewer;

import java.io.IOException;
import java.util.List;

public class GameViewer extends Viewer<Space> {
    public GameViewer(Space space) {
        super(space);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        drawElement(gui, getModel(), new SpaceViewer());
        drawElements(gui, getModel().getInvaderShips(), new InvaderShipViewer());
        drawElement(gui, getModel().getPlayerShip(), new PlayerShipViewer());
        drawElements(gui, getModel().getBarriers(), new BarrierViewer());
        drawElements(gui, getModel().getProjectiles(), new ProjectileViewer());
        drawElement(gui, getModel().getScore(), new ScoreViewer());
        drawElement(gui, getModel().getPlayerShip(), new HealthViewer());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) throws IOException {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) throws IOException {
        viewer.draw(element, gui);
    }
}