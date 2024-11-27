package org.l06gr01.states;

import org.l06gr01.GUI.GUI;
import org.l06gr01.Game;
import org.l06gr01.controller.Controller;
import org.l06gr01.controller.Leaderboard.LeaderboardController;
import org.l06gr01.model.leaderboard.Leaderboard;
import org.l06gr01.viewer.Leaderboard.LeaderboardViewer;
import org.l06gr01.viewer.Viewer;

import java.io.IOException;

public class LeaderState extends State<Leaderboard>{
    public LeaderState(Leaderboard leaderboard){super(leaderboard);}
    @Override
    protected Viewer<Leaderboard> getViewer() {
        return new LeaderboardViewer(getModel());
    }

    @Override
    protected Controller<Leaderboard> getController() {
        return new LeaderboardController(getModel());}
}
