package org.l06gr01.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr01.model.game.Barrier;
import org.l06gr01.model.game.InvaderShip;
import org.l06gr01.model.game.PlayerShip;
import org.l06gr01.model.game.space.Space;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceTest {
    Space space;
    InvaderShip invaderShip;
    InvaderShip invaderShip1;
    InvaderShip invaderShip2;
    List<InvaderShip> invaderShips;
    List<Barrier> barriers;
    PlayerShip playerShip;
    Barrier barrier;


    @BeforeEach
    void set_up(){
        space = new Space(new Position(10,20));

        invaderShip = new InvaderShip(0,0);
        invaderShip1 = new InvaderShip(10,0);
        invaderShip2 = new InvaderShip(5,0);
        playerShip = new PlayerShip(10,10);
        barrier = new Barrier(15,15);

        barriers = new ArrayList<>();
        barriers.add(barrier);
        invaderShips = new ArrayList<>();
        invaderShips.add(invaderShip);
        invaderShips.add(invaderShip1);
        invaderShips.add(invaderShip2);
        space.setInvaderShips(invaderShips);
        space.setPlayerShip(playerShip);
        space.setBarriers(barriers);
    }

    @Test
    void getWidth(){
        assertEquals(space.getWidth(),10);
    }

    @Test
    void getHeight(){
        assertEquals(space.getHeight(), 20);
    }

    @Test
    void getInvaderDirection(){
        assertTrue(space.getDirection());
    }

    @Test
    void switchInvaderDirection(){
        space.switchDirection();
        assertFalse(space.getDirection());
    }

    @Test
    void getEdgeInvader(){
        assertEquals(space.getRightMostInvader(), invaderShip1);
        assertEquals(space.getLeftMostInvader(), invaderShip);
    }

    @Test
    void isElement(){
        assertEquals(space.isBarrier(new Position(15,15)), barrier);
        assertNull(space.isBarrier(new Position(20,20)));

        assertEquals(space.isInvader(new Position(0,0)), invaderShip);
        assertNull(space.isInvader(new Position(15,15)));

    }
}
