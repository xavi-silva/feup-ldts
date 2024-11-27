package org.l06gr01.model.leaderboard;

import org.l06gr01.controller.Game.ScoreObserver;
import org.l06gr01.model.Position;
import org.l06gr01.model.game.Element;
import org.l06gr01.model.game.PlayerShip;
import org.l06gr01.model.game.Score;

import java.util.Map;

public class User {

    private String username;

    public User(String username) {

        this.username=username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void appendToName(Character c){
        String nick=getUsername();
        nick+=c;
        setUsername(nick);
    }


}
