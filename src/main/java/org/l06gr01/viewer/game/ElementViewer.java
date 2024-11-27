package org.l06gr01.viewer.game;


import org.l06gr01.GUI.GUI;
import org.l06gr01.model.game.Element;

import java.io.IOException;

public interface ElementViewer<T extends Element> {
        void draw(T element, GUI gui) throws IOException;
    }

