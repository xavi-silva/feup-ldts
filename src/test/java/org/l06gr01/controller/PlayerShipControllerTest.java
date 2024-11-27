package org.l06gr01.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr01.controller.Game.PlayerShipController;
import org.l06gr01.controller.Game.ScoreController;
import org.l06gr01.model.Position;
import org.l06gr01.model.game.PlayerShip;
import org.l06gr01.model.game.ShootingBehaviours.DoubleShooting;
import org.l06gr01.model.game.ShootingBehaviours.TripleShooting;
import org.l06gr01.model.game.space.Space;
import org.mockito.Mockito;

import java.util.Arrays;

import static net.jqwik.time.api.Times.times;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerShipControllerTest {

    Space space;
    PlayerShip playerShip;
    PlayerShipController playerShipController;

    @BeforeEach
    void setUp() {
        space = new Space(new Position(10, 10));

        playerShip = new PlayerShip(5, 5);
        space.setPlayerShip(playerShip);

        space.setBarriers(Arrays.asList());
        space.setBarriers(Arrays.asList());

        playerShipController = new PlayerShipController(space);


    }

    @Test
    void get(){
        assertEquals(playerShipController.getFireRate(), 450);
    }

    @Test
    void move() {
        playerShipController.movePlayerShipRight();
        assertEquals(new Position(6, 5), playerShip.getPosition());

        playerShipController.movePlayerShipLeft();
        assertEquals(new Position(5, 5), playerShip.getPosition());

    }

    @Test
    void tryToMoveOutOfBounds() {
        playerShip.setPosition(new Position(9, 5));
        playerShipController.movePlayerShipRight();
        assertEquals(new Position(9, 5), playerShip.getPosition());

        playerShip.setPosition(new Position(1, 5));
        playerShipController.movePlayerShipLeft();
        assertEquals(new Position(1, 5), playerShip.getPosition());
    }

    @Test
    void update(){
        playerShipController.onInvaderDeath();

        assertEquals(playerShipController.getFireRate(), 450);

        playerShipController.onInvaderDeath();
        playerShipController.onInvaderDeath();
        playerShipController.onInvaderDeath();

        assertEquals(playerShipController.getFireRate(), 430);

    }

    @Test
    void updateScore() {
        PlayerShipController playerControllerMock = Mockito.spy(new PlayerShipController(space));
        PlayerShip playerShipMock = Mockito.mock(PlayerShip.class);
        Space spaceMock = Mockito.mock(Space.class);

        when(playerControllerMock.getModel()).thenReturn(spaceMock);
        when(spaceMock.getPlayerShip()).thenReturn(playerShipMock);

        playerControllerMock.updateScore(100);

        Mockito.verify(playerShipMock,Mockito.times(1)).setShootingBehaviour(Mockito.any());
    }




}
