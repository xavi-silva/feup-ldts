package org.l06gr01.controller.menu;
import org.l06gr01.model.game.Element;
import org.l06gr01.model.game.space.LoaderSpaceBuilder;
import org.l06gr01.model.leaderboard.LoaderLeaderboardBuilder;
import org.l06gr01.model.leaderboard.User;
import org.l06gr01.model.menu.Menu;

import org.l06gr01.GUI.GUI;
import org.l06gr01.Game;
import org.l06gr01.controller.Controller;
import org.l06gr01.states.GameState;
import org.l06gr01.states.InstructionsState;
import org.l06gr01.states.LeaderState;
import org.l06gr01.states.usernameInputState;

import java.awt.*;
import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    //@Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case QUIT:
                game.setState(null);
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new usernameInputState(new User("")));
                if (getModel().isSelectedLeaderboard()) game.setState(new LeaderState(new LoaderLeaderboardBuilder().createLeaderboard()));
                if (getModel().isSelectedInstructions()) game.setState(new InstructionsState(new Element()));        }
    }
}

