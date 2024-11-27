package org.l06gr01.model.game;

import org.l06gr01.model.Position;
import org.l06gr01.model.game.ShootingBehaviours.EnemyShooting;
import org.l06gr01.model.game.ShootingBehaviours.ShootingBehaviour;
import org.l06gr01.model.game.projectiles.EnemyProjectile;

public class InvaderShip extends Ship<EnemyProjectile> {
    public InvaderShip(int x, int y) {
        super(x, y);
    }

    @Override
    protected ShootingBehaviour<EnemyProjectile> createShootingBehaviour() {
        return new EnemyShooting();
    }
}
