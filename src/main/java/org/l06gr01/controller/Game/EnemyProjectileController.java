package org.l06gr01.controller.Game;

import org.l06gr01.GUI.GUI;
import org.l06gr01.Game;
import org.l06gr01.model.game.AllyProjectile;
import org.l06gr01.model.game.Barrier;
import org.l06gr01.model.game.InvaderShip;
import org.l06gr01.model.game.PlayerShip;
import org.l06gr01.model.game.projectiles.EnemyProjectile;
import org.l06gr01.model.game.space.Space;

import java.io.IOException;
import java.util.Iterator;

public class EnemyProjectileController extends ProjectileController{


    public EnemyProjectileController(Space model) {
        super(model);
    }

    @Override
    public void moveProjectiles() {
        Iterator<EnemyProjectile> iterator = getModel().getEnemyProjectiles().iterator();
        while (iterator.hasNext()) {
            EnemyProjectile p = iterator.next();
            if (getModel().isWithinBounds(p.nextPosition())) {
                p.setPosition(p.nextPosition());
            }
            else {
                iterator.remove();
            }
        }
    }

    @Override
    public void checkCollisions() {
        Iterator<EnemyProjectile> iterator = getModel().getEnemyProjectiles().iterator();
        while (iterator.hasNext()) {
            EnemyProjectile p = iterator.next();
            Barrier b = getModel().isBarrier(p.getPosition());
            if (b != null) {
                getModel().getBarriers().remove(b);
                iterator.remove();
            }

            if (getModel().getPlayerShip().getPosition().equals(p.getPosition())) {
                getModel().getPlayerShip().decreaseHealth();
                iterator.remove();

                System.out.println(getModel().getPlayerShip().getHealth());

                //TODO: Check for state changes

            }



        }

    }
}
