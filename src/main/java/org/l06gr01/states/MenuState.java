package org.l06gr01.states;


import org.l06gr01.controller.Controller;
import org.l06gr01.controller.menu.MenuController;
import org.l06gr01.viewer.Viewer;
import org.l06gr01.viewer.menu.MenuViewer;
import org.l06gr01.model.menu.Menu;

import java.awt.*;

public class MenuState extends State<Menu>{

    public MenuState(Menu model) {
        super(model);
    }
    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }

}
