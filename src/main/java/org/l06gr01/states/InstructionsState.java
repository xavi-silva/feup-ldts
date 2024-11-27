package org.l06gr01.states;

import org.l06gr01.controller.Controller;
import org.l06gr01.controller.instructions.instructionsController;
import org.l06gr01.model.game.Element;
import org.l06gr01.viewer.Viewer;
import org.l06gr01.viewer.instructions.instructionsViewer;

public class InstructionsState extends State<Element>{
    public InstructionsState(Element model) {
        super(model);
    }

    @Override
    protected Viewer<Element> getViewer() {
        return new instructionsViewer(getModel());
    }

    @Override
    protected Controller<Element> getController() {
        return new instructionsController(getModel());
    }
}
