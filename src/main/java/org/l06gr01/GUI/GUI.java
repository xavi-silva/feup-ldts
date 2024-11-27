package org.l06gr01.GUI;

import org.l06gr01.model.Position;

import java.io.IOException;

public interface GUI {
    void drawUser(Position position, String user, Integer score);
    Character getNextChar() throws IOException;
    void drawScore(Position position, int score);
    void drawPlayerShip(Position position);
    void drawInvaderShip(Position position);
    void drawBarrier(Position position);
    void drawProjectile(Position position,boolean flag);
    void drawSpace() throws IOException;
    void drawHealth(Position position, int health);
    void drawText(Position position, String text, String color);
    ACTION getNextAction() throws IOException;
    void clear();

    void refresh() throws IOException;

    void close() throws IOException;



    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, WRITE}
}
