package org.l06gr01.viewer;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr01.GUI.GUI;
import org.l06gr01.GUI.LanternaGUI;
import org.l06gr01.Game;
import org.l06gr01.model.Position;
import org.l06gr01.model.game.*;
import org.l06gr01.model.game.projectiles.EnemyProjectile;
import org.l06gr01.model.game.space.Space;
import org.l06gr01.viewer.game.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.mockito.Mockito.*;
class ViewerTest {
    GameViewer gameViewer;
    SpaceViewer spaceViewer;
    Space space;
    private GUI gui;
    @BeforeEach
    void set_up(){
        space = new Space(new Position(20,20));

        space.setPlayerShip(new PlayerShip(18,10));
        space.setScore(new Score(2,2));
        space.setBarriers(Arrays.asList(new Barrier(10,10), new Barrier(10,11)));
        space.setInvaderShips(Arrays.asList(new InvaderShip(2,10), new InvaderShip(2,11)));
        space.setAllyProjectiles(Arrays.asList(new AllyProjectile(17,10), new AllyProjectile(16,10)));
        space.setEnemyProjectiles(Arrays.asList(new EnemyProjectile(11,10), new EnemyProjectile(11,11)));

        gameViewer = new GameViewer(space);
        spaceViewer = new SpaceViewer();

        gui=Mockito.mock(GUI.class);
    }
    @Test
    void playerShipTest() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).drawPlayerShip(new Position(18,10));
    }
    @Test
    void scoreTest() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).drawScore(new Position(0,1),0);
    }
    @Test
    void barrierTest() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).drawBarrier(new Position(10,10));
        Mockito.verify(gui,Mockito.times(1)).drawBarrier(new Position(10,11));
        Mockito.verify(gui,Mockito.times(2)).drawBarrier(Mockito.any(Position.class));
    }
    @Test
    void projectileTest() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).drawProjectile(new Position(17,10),true);
        Mockito.verify(gui,Mockito.times(1)).drawProjectile(new Position(16,10),true);
        Mockito.verify(gui,Mockito.times(1)).drawProjectile(new Position(11,10),false);
        Mockito.verify(gui,Mockito.times(1)).drawProjectile(new Position(11,11),false);

        Mockito.verify(gui,Mockito.times(4)).drawProjectile(Mockito.any(Position.class),Mockito.anyBoolean());

    }


    @Test
    void invaderShipTest() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).drawInvaderShip(new Position(2,10));
        Mockito.verify(gui,Mockito.times(1)).drawInvaderShip(new Position(2,11));
    }
}

