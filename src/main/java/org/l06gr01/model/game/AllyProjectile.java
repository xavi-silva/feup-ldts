package org.l06gr01.model.game;

public class AllyProjectile extends Projectile {

    public AllyProjectile(int x, int y) {
        super(x, y);setTeam(true);
    }
    @Override
    protected int defineYVelocity() {
        return -1;
    }
}
