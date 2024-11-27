package org.l06gr01.model.game.ShootingBehaviours;

import org.l06gr01.model.Position;
import org.l06gr01.model.game.AllyProjectile;
import org.l06gr01.model.game.Projectile;

import java.util.ArrayList;
import java.util.List;

public class DoubleShooting implements ShootingBehaviour<AllyProjectile>{

    @Override
    public List<AllyProjectile> shoot(Position position) {
        List<AllyProjectile> projectiles = new ArrayList<AllyProjectile>();
        projectiles.add(new AllyProjectile(position.getX() - 1, position.getY() - 1));
        projectiles.add(new AllyProjectile(position.getX() + 1, position.getY() - 1));

        return projectiles;
    }
}
