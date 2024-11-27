package org.l06gr01.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr01.model.game.Score;
import org.l06gr01.model.game.space.Space;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {
    Score score;
    Space space;
    @BeforeEach
    void set_up(){
        space = new Space(new Position(0,0));
        score = new Score(0,0);
    }

    @Test
    void getScore(){
        assertEquals(score.getScore(), 0);
    }

    @Test
    void setScore(){
        score.setScore(30);
        assertEquals(score.getScore(),30);
        score.setScore(0);
    }

    @Test
    void increaseScore(){
        score.increaseScore();
        assertEquals(score.getScore(), 10);
    }
}
