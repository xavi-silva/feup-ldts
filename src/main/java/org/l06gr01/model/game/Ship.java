package org.l06gr01.model.game;

import org.l06gr01.model.Position;
import org.l06gr01.model.game.ShootingBehaviours.ShootingBehaviour;

import java.util.List;

public abstract class Ship<T extends Projectile> extends Element{
    ShootingBehaviour<T> shootingBehaviour;

    Ship(int x, int y){
        super(new Position(x, y));
        this.shootingBehaviour = createShootingBehaviour();
    }

    public List<T> shoot() {
        return shootingBehaviour.shoot(this.position);
    }

    protected abstract ShootingBehaviour<T> createShootingBehaviour();
}
