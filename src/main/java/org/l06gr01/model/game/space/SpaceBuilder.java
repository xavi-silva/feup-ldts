package org.l06gr01.model.game.space;

import org.l06gr01.model.Position;
import org.l06gr01.model.game.*;
import org.l06gr01.model.game.projectiles.EnemyProjectile;

import java.util.List;

public abstract class SpaceBuilder {
    public Space createSpace(){
        Space space = new Space(new Position(getWidth(),getHeight()));
        space.setInvaderShips(createInvaderShips());
        space.setPlayerShip(createPlayerShip());
        space.setAllyProjectiles(createAllyProjectiles());
        space.setEnemyProjectiles(createEnemyProjectiles());
        space.setBarriers(createBarriers());
        space.setScore(createScore());
        return space;
    }
    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<InvaderShip> createInvaderShips();

    protected abstract List<Barrier> createBarriers();
    protected abstract List<AllyProjectile> createAllyProjectiles();
    protected abstract List<EnemyProjectile> createEnemyProjectiles();
    protected abstract Score createScore();

    protected abstract  PlayerShip createPlayerShip();
}
