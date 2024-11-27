package org.l06gr01.model.game;

import org.l06gr01.model.Position;
import org.l06gr01.model.game.ShootingBehaviours.DoubleShooting;
import org.l06gr01.model.game.ShootingBehaviours.RegularShooting;
import org.l06gr01.model.game.ShootingBehaviours.ShootingBehaviour;


public class PlayerShip extends Ship<AllyProjectile>{
    private int health;
    public PlayerShip(int x, int y) {
        super(x, y);
        this.health = 3;

    }
    @Override
    protected ShootingBehaviour<AllyProjectile> createShootingBehaviour() { return new RegularShooting(); }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void decreaseHealth(){ this.health--;}
    public void increaseHealth(){ if(health < 3) this.health++;}
    public void setShootingBehaviour(ShootingBehaviour shootingBehaviour) { this.shootingBehaviour = shootingBehaviour; }
}
