package org.l06gr01.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr01.model.game.PlayerShip;
import org.l06gr01.model.game.space.Space;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerShipTest {
    PlayerShip playerShip;
    Space space;
    @BeforeEach
    void set_up(){
        playerShip = new PlayerShip(0,0);
        //space = new Space(new Position(0,0));
    }

    @Test
    void getHealth(){
        assertEquals(playerShip.getHealth(), 3);
    }

    @Test
    void setHealth(){
        playerShip.setHealth(10);
        assertEquals(playerShip.getHealth(), 10);
    }

    @Test
    void healthChanging(){
        playerShip.decreaseHealth();
        assertEquals(playerShip.getHealth(), 2);
        playerShip.increaseHealth();
        assertEquals(playerShip.getHealth(), 3);
        playerShip.increaseHealth();
        assertEquals(playerShip.getHealth(), 3);
    }
}
