package org.l06gr01.model.game.projectiles;


import org.l06gr01.model.game.Projectile;

public class EnemyProjectile extends Projectile {

    public EnemyProjectile(int x, int y) {
        super(x, y);setTeam(false);
    }
    @Override
    protected int defineYVelocity() {
        return 1;
    }
}
