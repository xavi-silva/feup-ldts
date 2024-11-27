package org.l06gr01.controller.Game;

import org.l06gr01.GUI.GUI;
import org.l06gr01.Game;
import org.l06gr01.model.game.space.Space;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreController extends GameController implements InvaderObserver, Observed<ScoreObserver> {

    List<ScoreObserver> scoreObservers = new ArrayList<ScoreObserver>();
    final byte upgrageGap = 100;
    long scoreLastUpgrade = 0;
    public ScoreController(Space model) {
        super(model);
    }

    private void increaseScore(){
        getModel().getScore().increaseScore();
        notifyObservers();
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {



    }
    @Override
    public void onInvaderDeath() {
        increaseScore();
    }

    @Override
    public void notifyObservers() {

        for (ScoreObserver so : scoreObservers){
            so.updateScore(getModel().getScore().getScore());
        }

    }

    @Override
    public void addObserver(ScoreObserver obs) {
        scoreObservers.add(obs);
    }

    @Override
    public void removeObserver(ScoreObserver obs) {
        scoreObservers.remove(obs);
    }
}
