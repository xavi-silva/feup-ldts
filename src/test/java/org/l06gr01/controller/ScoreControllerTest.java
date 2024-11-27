package org.l06gr01.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr01.controller.Game.PlayerShipController;
import org.l06gr01.controller.Game.ScoreController;
import org.l06gr01.controller.Game.ScoreObserver;
import org.l06gr01.controller.Game.SpaceController;
import org.l06gr01.model.Position;
import org.l06gr01.model.game.Score;
import org.l06gr01.model.game.space.LoaderSpaceBuilder;
import org.l06gr01.model.game.space.Space;
import org.l06gr01.model.game.space.SpaceBuilder;
import org.mockito.Mock;
import org.mockito.Mockito;

import static net.jqwik.time.api.Times.times;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ScoreControllerTest {
    Space space;
    Score score;
    ScoreController scoreController;

    PlayerShipController playerShipController;

    @BeforeEach
    void set_up(){
        space = new LoaderSpaceBuilder().createSpace();
        scoreController = new ScoreController(space);
        playerShipController = new PlayerShipController(space);
        scoreController.addObserver(playerShipController);
        score = new Score(0,0);
    }

    @Test
    void update(){
        // TODO: Testar se o increaseScore é chamado no update
        /*
        Score score = Mockito.mock(Score.class);
        ScoreController scoreControllerSpy = Mockito.spy(new ScoreController(space));

        Mockito.doNothing().when(scoreControllerSpy).update();
        scoreController.update();

        Mockito.verify(score, Mockito.times(1)).increaseScore();*/
    }

    @Test
    void notifyScoreUpdate() {
        ScoreController spy = Mockito.spy(scoreController);
        PlayerShipController playerShipControllerMock = mock(PlayerShipController.class);

        scoreController.addObserver(playerShipControllerMock);

        scoreController.notifyObservers();

        Mockito.verify(playerShipControllerMock, Mockito.times(1)).updateScore(Mockito.anyInt());

    }

}
