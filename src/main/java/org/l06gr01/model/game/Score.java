package org.l06gr01.model.game;

import org.l06gr01.model.Position;

public class Score extends Element{
    private int score;
    public Score(int x, int y) {
        super(new Position(0, 1));
        this.score=0;
    }
    public void setScore(int score){
        this.score=score;
    }
    public int getScore(){return this.score;}
    public void increaseScore(){this.score+=10;}
}
