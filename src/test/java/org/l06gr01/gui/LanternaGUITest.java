package org.l06gr01.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr01.GUI.LanternaGUI;
import org.l06gr01.model.Position;
import org.mockito.Mockito;

import java.io.IOException;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#336699");
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
    }

    @Test
    void drawPlayerShip() {
        gui.drawPlayerShip(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 255, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "▲");
    }

    @Test
    void drawInvaderShip() {
        gui.drawInvaderShip(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "∇");
    }

    @Test
    void drawBarrier() {
        gui.drawBarrier(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(128, 128, 128));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "▭");
    }

    @Test
    void drawProjectile() {
        gui.drawProjectile(new Position(1, 1),true);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(57, 255, 20));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "▯");
    }
    @Test
    void drawScore() {
        gui.drawScore(new Position(1, 1),0);

        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "S");
        Mockito.verify(tg, Mockito.times(1)).putString(2, 2, "C");
        Mockito.verify(tg, Mockito.times(1)).putString(3, 2, "O");
        Mockito.verify(tg, Mockito.times(1)).putString(4, 2, "R");
        Mockito.verify(tg, Mockito.times(1)).putString(5, 2, "E");
    }

    @Test
    void drawHealth() {
        gui.drawHealth(new Position(1, 0),3);

        Mockito.verify(tg, Mockito.times(3)).setForegroundColor(new TextColor.RGB(224,17,95));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "❤");
        Mockito.verify(tg, Mockito.times(1)).putString(2, 1, "❤");
        Mockito.verify(tg, Mockito.times(1)).putString(3, 1, "❤");

    }

}
