package org.l06gr01.controller.Game;

import org.l06gr01.GUI.GUI;
import org.l06gr01.Game;
import org.l06gr01.model.game.space.Space;

import java.io.IOException;

public abstract class ProjectileController extends GameController{
    static long moveRate = 75;
    long timeLastMovement = 0;

    public ProjectileController(Space model){ super(model);}
    public abstract void moveProjectiles();
    public abstract void checkCollisions();
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - timeLastMovement > moveRate) {
            moveProjectiles();
            timeLastMovement = time;
        }
        checkCollisions();

    }
}
