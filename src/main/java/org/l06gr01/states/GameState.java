package org.l06gr01.states;

import org.l06gr01.controller.Controller;
import org.l06gr01.controller.Game.SpaceController;
import org.l06gr01.model.game.space.Space;
import org.l06gr01.viewer.Viewer;
import org.l06gr01.viewer.game.GameViewer;

public class GameState extends State<Space>{
    public GameState(Space space) {
        super(space);
        }
    @Override
    protected Viewer<Space> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Space> getController() {
        return new SpaceController(getModel());
    }
}
