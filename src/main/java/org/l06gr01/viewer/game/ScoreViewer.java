package org.l06gr01.viewer.game;

import org.l06gr01.GUI.GUI;
import org.l06gr01.model.game.Score;

import java.io.IOException;

public class ScoreViewer implements ElementViewer<Score>{
    @Override
    public void draw(Score element, GUI gui) throws IOException {
        gui.drawScore(element.getPosition(), element.getScore());
    }
}
