package org.l06gr01.shooting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr01.model.Position;
import org.l06gr01.model.game.AllyProjectile;
import org.l06gr01.model.game.InvaderShip;
import org.l06gr01.model.game.PlayerShip;
import org.l06gr01.model.game.ShootingBehaviours.DoubleShooting;
import org.l06gr01.model.game.ShootingBehaviours.EnemyShooting;
import org.l06gr01.model.game.ShootingBehaviours.TripleShooting;
import org.l06gr01.model.game.projectiles.EnemyProjectile;
import org.l06gr01.model.game.space.Space;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShootingTests {
    Space space;
    PlayerShip playerShip;
    InvaderShip invaderShip;

    @BeforeEach
    void set_up() {
        playerShip = new PlayerShip(10, 10);
        invaderShip = new InvaderShip(5,10);
    }

    @Test
    void regularShooting(){
        assertEquals(playerShip.shoot().get(0).getPosition(), new Position(10, 9));
    }

    @Test
    void doubleShooting() {
        playerShip.setShootingBehaviour(new DoubleShooting());
        List<AllyProjectile> projectiles = playerShip.shoot();
        assertEquals(projectiles.get(0).getPosition(), new Position(9, 9));
        assertEquals(projectiles.get(1).getPosition(), new Position(11, 9));
    }

    @Test
    void tripleShooting() {
        playerShip.setShootingBehaviour(new TripleShooting());
        List<AllyProjectile> projectiles = playerShip.shoot();
        assertEquals(projectiles.get(0).getPosition(), new Position(8, 9));
        assertEquals(projectiles.get(1).getPosition(), new Position(12, 9));
        assertEquals(projectiles.get(2).getPosition(), new Position(10, 8));

    }
    @Test
    void enemyShooting(){
        List<EnemyProjectile> projectiles = invaderShip.shoot();
        assertEquals(projectiles.get(0).getPosition(), new Position(5, 11));
    }

}
