package org.l06gr01.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr01.model.game.Barrier;
import org.l06gr01.model.game.InvaderShip;
import org.l06gr01.model.game.PlayerShip;
import org.l06gr01.model.game.Score;
import org.l06gr01.model.game.space.LoaderSpaceBuilder;
import org.l06gr01.model.game.space.Space;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoaderSpaceBuilderTest {
    Space space;
    LoaderSpaceBuilder loaderSpaceBuilder;
    @BeforeEach
    void set_up(){
        space = new Space(new Position(100,100));

        loaderSpaceBuilder = new LoaderSpaceBuilder();
    }
    @Test
    void createInvaderShips(){
        List<InvaderShip> invaders = loaderSpaceBuilder.createInvaderShips();

        assertEquals(24,invaders.size());

        for (InvaderShip invader : invaders){
            assert(invader.getPosition().getX() >= 41);
            assert(invader.getPosition().getX() < 57);
            assert(invader.getPosition().getY() >= 5);
            assert(invader.getPosition().getY() < 8);
        }
    }

    @Test
    void createBarriers(){
        List<Barrier> barriers = loaderSpaceBuilder.createBarriers();

        assertEquals(48,barriers.size());

        for (Barrier barrier : barriers){
            assert(barrier.getPosition().getX() >= 7);
            assert(barrier.getPosition().getX() < 83);
            assert(barrier.getPosition().getY() >= 15);
            assert(barrier.getPosition().getY() < 18);
        }
    }
    @Test
    void createPlayerShip(){
        PlayerShip playerShip = loaderSpaceBuilder.createPlayerShip();
        assertEquals(playerShip.getPosition(), new Position(45,25));
        assertEquals(playerShip.getHealth(), 3);
    }
    @Test
    void createScore(){
        Score score = loaderSpaceBuilder.createScore();
        assertEquals(score.getPosition(), new Position(0,1));
        assertEquals(score.getScore(),0);
    }


}
