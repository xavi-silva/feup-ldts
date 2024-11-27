package org.l06gr01.model.game.ShootingBehaviours;

import org.l06gr01.model.Position;
import org.l06gr01.model.game.AllyProjectile;
import org.l06gr01.model.game.Projectile;
import org.l06gr01.model.game.projectiles.EnemyProjectile;

import java.util.ArrayList;
import java.util.List;

public class EnemyShooting implements ShootingBehaviour<EnemyProjectile>{
    @Override
    public List<EnemyProjectile> shoot(Position position) {
        List<EnemyProjectile> projectiles = new ArrayList<EnemyProjectile>();
        projectiles.add(new EnemyProjectile(position.getX(), position.getY() + 1));
        return projectiles;
    }
}
