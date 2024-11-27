package org.l06gr01.controller.instructions;

import org.l06gr01.GUI.GUI;
import org.l06gr01.Game;
import org.l06gr01.controller.Controller;
import org.l06gr01.model.game.Element;
import org.l06gr01.model.menu.Menu;
import org.l06gr01.states.MenuState;

import java.io.IOException;

public class instructionsController extends Controller<Element> {
    public instructionsController(Element model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(action== GUI.ACTION.QUIT){game.setState(new MenuState(new Menu()));
    }}
}
