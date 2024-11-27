package org.l06gr01.model.game.ShootingBehaviours;

import org.l06gr01.model.Position;
import org.l06gr01.model.game.Projectile;

import java.util.List;

public interface ShootingBehaviour<T extends Projectile> {
    List<T> shoot(Position position);

}
