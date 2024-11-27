package org.l06gr01.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr01.GUI.GUI;
import org.l06gr01.Game;
import org.l06gr01.controller.Game.*;
import org.l06gr01.model.Position;
import org.l06gr01.model.game.*;
import org.l06gr01.model.game.projectiles.EnemyProjectile;
import org.l06gr01.model.game.space.Space;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProjectileControllerTest {
    Space space;
    Game game;
    AllyProjectileController allyProjectileController;
    EnemyProjectileController enemyProjectileController;
    Projectile projectile;
    AllyProjectile allyProjectile;
    EnemyProjectile enemyProjectile;
    ProjectileController projectileController;
    List<AllyProjectile> allies = new ArrayList<>();
    List<EnemyProjectile> enemies = new ArrayList<>();

    @BeforeEach
    void set_up() {
        space = new Space(new Position(10, 10));
        allyProjectileController = new AllyProjectileController(space);
        enemyProjectileController = new EnemyProjectileController(space);

        for (int i = 1; i <= 3; i++){
            AllyProjectile ally = new AllyProjectile(i,5);
            EnemyProjectile enemy = new EnemyProjectile(i,1);
            allies.add(ally);
            enemies.add(enemy);
        }

        space.setAllyProjectiles(allies);
        space.setEnemyProjectiles(enemies);
    }
    @Test
    void addObserver(){
        InvaderShipController invaderMock = mock(InvaderShipController.class);

        allyProjectileController.addObserver(invaderMock);
        Mockito.verify(invaderMock,Mockito.never()).onInvaderDeath();

        allyProjectileController.notifyObservers();
        Mockito.verify(invaderMock, Mockito.times(1)).onInvaderDeath();

    }

    @Test
    void removeObserver(){
        InvaderShipController invaderMock = mock(InvaderShipController.class);

        allyProjectileController.addObserver(invaderMock);
        allyProjectileController.removeObserver(invaderMock);

        allyProjectileController.notifyObservers();
        Mockito.verify(invaderMock, Mockito.never()).onInvaderDeath();

    }

    @Test
    void notifyObservers(){
        InvaderShipController invaderMock = mock(InvaderShipController.class);
        PlayerShipController playerMock = mock(PlayerShipController.class);
        SpaceController spaceMock = mock(SpaceController.class);
        ScoreController scoreMock = mock(ScoreController.class);

        allyProjectileController.addObserver(playerMock);
        allyProjectileController.addObserver(invaderMock);
        allyProjectileController.addObserver(spaceMock);
        allyProjectileController.addObserver(scoreMock);

        allyProjectileController.notifyObservers();

        Mockito.verify(invaderMock, Mockito.times(1)).onInvaderDeath();
        Mockito.verify(playerMock, Mockito.times(1)).onInvaderDeath();
        Mockito.verify(spaceMock, Mockito.times(1)).onInvaderDeath();
        Mockito.verify(scoreMock, Mockito.times(1)).onInvaderDeath();
    }

    @Test
    void moveProjectiles(){
        allyProjectileController.moveProjectiles();
        enemyProjectileController.moveProjectiles();

        assertEquals(allies.get(0).getPosition(), new Position(1,4));
        assertEquals(allies.get(1).getPosition(), new Position(2,4));
        assertEquals(allies.get(2).getPosition(), new Position(3,4));

        assertEquals(enemies.get(0).getPosition(), new Position(1,2));
        assertEquals(enemies.get(1).getPosition(), new Position(2,2));
        assertEquals(enemies.get(2).getPosition(), new Position(3,2));
    }

    @Test
    void checkCollisions(){
        List<Barrier> barriers = new ArrayList<>();
        Barrier barrier1 = new Barrier(1,5); // Ally Projectile here
        Barrier barrier2 = new Barrier(1,1); // Enemy Projectile here
        barriers.add(barrier1);
        barriers.add(barrier2);
        space.setBarriers(barriers);

        List<InvaderShip> invaders = new ArrayList<>();
        InvaderShip invader = new InvaderShip(2,5); // Ally Projectile here
        invaders.add(invader);
        space.setInvaderShips(invaders);

        space.setPlayerShip(new PlayerShip(2,1)); // Enemy Projectile here

        assertEquals(space.getBarriers().size(), 2);
        assertEquals(space.getInvaderShips().size(), 1);
        assertEquals(space.getPlayerShip().getHealth(), 3);

        allyProjectileController.checkCollisions();
        enemyProjectileController.checkCollisions();

        assertEquals(space.getBarriers().size(),0);
        assertEquals(space.getInvaderShips().size(), 0);
        assertEquals(space.getPlayerShip().getHealth(), 2);
    }
}
