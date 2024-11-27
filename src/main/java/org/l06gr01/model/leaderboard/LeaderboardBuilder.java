package org.l06gr01.model.leaderboard;

import org.l06gr01.model.Position;

import java.util.List;
import java.util.Map;

public abstract class LeaderboardBuilder {
    public Leaderboard createLeaderboard(){
        Leaderboard leaderboard=new Leaderboard(new Position(getWidth(), getHeight()));
        leaderboard.setInput(createInput());
        leaderboard.setTitle(createTitle());
        leaderboard.setUsers(createUsers());
        return leaderboard;
    }
    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract Position createInput();
    protected abstract Position createTitle();
    protected abstract Map<String,Integer> createUsers();
}
