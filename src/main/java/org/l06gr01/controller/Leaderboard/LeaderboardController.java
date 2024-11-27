package org.l06gr01.controller.Leaderboard;

import org.l06gr01.GUI.GUI;
import org.l06gr01.Game;
import org.l06gr01.controller.Controller;
import org.l06gr01.model.Position;
import org.l06gr01.model.leaderboard.Leaderboard;
import org.l06gr01.model.menu.Menu;
import org.l06gr01.states.MenuState;

import java.io.IOException;

public class LeaderboardController extends Controller<Leaderboard> {
    public LeaderboardController(Leaderboard model){super(model);}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(action== GUI.ACTION.QUIT){game.setState(new MenuState(new Menu()));
        }
    }}

