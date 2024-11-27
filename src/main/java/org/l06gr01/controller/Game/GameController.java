package org.l06gr01.controller.Game;

import org.l06gr01.GUI.GUI;
import org.l06gr01.Game;
import org.l06gr01.controller.Controller;
import org.l06gr01.model.game.InvaderShip;
import org.l06gr01.model.game.space.Space;

import java.io.IOException;

public abstract class GameController extends Controller<Space> {

    public GameController(Space model) {
        super(model);
    }

}
