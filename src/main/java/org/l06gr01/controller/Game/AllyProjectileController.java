package org.l06gr01.controller.Game;

import org.l06gr01.model.game.*;
import org.l06gr01.model.game.space.Space;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AllyProjectileController extends ProjectileController implements Observed<InvaderObserver>{
    private List<InvaderObserver> invaderObservers = new ArrayList<>();
    private boolean killed=false;

    public AllyProjectileController(Space model) {
        super(model);
    }
    public boolean getKilled(){return this.killed;}
    public void setKilled(boolean flag){this.killed=flag;}

    @Override
    public void moveProjectiles() {
        Iterator<AllyProjectile> iterator = getModel().getAllyProjectiles().iterator();
        while (iterator.hasNext()) {
            AllyProjectile p = iterator.next();
            if (getModel().isWithinBounds(p.nextPosition())) {
                p.setPosition(p.nextPosition());

            } else {
                iterator.remove();
            }
        }
    }

    @Override
    public void checkCollisions() {
        Iterator<AllyProjectile> iterator = getModel().getAllyProjectiles().iterator();

        while (iterator.hasNext()) {

            AllyProjectile p = iterator.next();

            Barrier b = getModel().isBarrier(p.getPosition());
            if (b != null) {
                getModel().getBarriers().remove(b);
                iterator.remove();
            }

            InvaderShip i = getModel().isInvader(p.getPosition());
            if (i != null) {
                getModel().getInvaderShips().remove(i);
                iterator.remove();
                setKilled(true);
                notifyObservers();
            }
        }

    }
    public void notifyObservers(){
        for (InvaderObserver obs : invaderObservers){
            obs.onInvaderDeath();
        }
    }
    public void addObserver(InvaderObserver obs){
        invaderObservers.add(obs);
    }
    public void removeObserver(InvaderObserver obs){
        invaderObservers.remove(obs);
    }
}
