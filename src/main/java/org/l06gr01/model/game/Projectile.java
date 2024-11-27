package org.l06gr01.model.game;

import org.l06gr01.model.Position;

public abstract class Projectile extends Element{
    boolean team;
    int yVelocity;
    public Projectile(int x, int y) {
        super(new Position(x,y));
        this.yVelocity = defineYVelocity();
    }

    public void setTeam(boolean team) {
        this.team = team;
    }

    public boolean isTeam() {
        return team;
    }

    public Position nextPosition() {
        return new Position(position.getX(), position.getY() + yVelocity);
    }

    protected abstract int defineYVelocity();
}
