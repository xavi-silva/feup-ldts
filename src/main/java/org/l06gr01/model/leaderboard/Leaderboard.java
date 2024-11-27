package org.l06gr01.model.leaderboard;

import org.l06gr01.model.Position;
import org.l06gr01.model.game.Element;

import java.util.List;
import java.util.Map;

public class Leaderboard extends Element {
    private int width;
    private int height;
    private Position title;
    private Position input;

    private Map<String,Integer> users;

    public Leaderboard(Position position){
        this.width=position.getX();
        this.height= position.getY();
    }
    public void setUsers(Map<String,Integer> users) {this.users = users;}
    public Map<String,Integer> getUsers(){return users;}
    public Position getTitle(){return title;}
    public void setTitle(Position title) {this.title = title;}

    public Position getInput() {return input;}
    public void setInput(Position position){this.input=position;}

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
