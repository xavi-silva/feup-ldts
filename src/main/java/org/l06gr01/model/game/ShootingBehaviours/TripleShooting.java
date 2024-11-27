package org.l06gr01.model.game.ShootingBehaviours;

import org.l06gr01.model.Position;
import org.l06gr01.model.game.AllyProjectile;

import java.util.ArrayList;
import java.util.List;

public class TripleShooting  implements ShootingBehaviour<AllyProjectile>{

    @Override
    public List<AllyProjectile> shoot(Position position) {
        List<AllyProjectile> projectiles = new ArrayList<AllyProjectile>();
        projectiles.add(new AllyProjectile(position.getX() - 2, position.getY() - 1));
        projectiles.add(new AllyProjectile(position.getX() + 2, position.getY() - 1));
        projectiles.add(new AllyProjectile(position.getX(), position.getY() - 2));


        return projectiles;
    }
}


