package org.l06gr01.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr01.controller.Game.InvaderShipController;
import org.l06gr01.model.Position;
import org.l06gr01.model.game.InvaderShip;
import org.l06gr01.model.game.space.Space;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvaderShipControllerTest {
    Space space;
    List<InvaderShip> invaderShips = new ArrayList<>();
    InvaderShipController invaderShipController;
    @BeforeEach
    void setUp() {
        space = new Space(new Position(10, 10));
        invaderShips.add(new InvaderShip(5,5));
        space.setInvaderShips(invaderShips);

        space.setBarriers(Arrays.asList());
        space.setBarriers(Arrays.asList());

        invaderShipController = new InvaderShipController(space);
    }

    @Test
    void get(){
        assertEquals(invaderShipController.getMoveRate(), 100);
        assertEquals(invaderShipController.getFireRate(), 1000);
    }

    @Test
    void move() {
        InvaderShip invaderShip = invaderShips.get(0);
        invaderShipController.moveInvaderShip(invaderShip, invaderShip.getPosition().getRight());
        assertEquals(new Position(6,5), invaderShip.getPosition());
        invaderShipController.moveInvaderShip(invaderShip, invaderShip.getPosition().getLeft());
        assertEquals(new Position(5,5), invaderShip.getPosition());
    }

    @Test
    void update(){
        invaderShipController.onInvaderDeath();

        assertEquals(invaderShipController.getFireRate(), 1000);
        assertEquals(invaderShipController.getMoveRate(), 100);

        invaderShipController.onInvaderDeath();
        invaderShipController.onInvaderDeath();
        invaderShipController.onInvaderDeath();

        assertEquals(invaderShipController.getFireRate(), 920);
        assertEquals(invaderShipController.getMoveRate(), 90);
    }
}
