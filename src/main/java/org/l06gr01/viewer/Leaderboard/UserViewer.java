package org.l06gr01.viewer.Leaderboard;

import org.l06gr01.GUI.GUI;
import org.l06gr01.model.Position;
import org.l06gr01.model.leaderboard.Leaderboard;
import org.l06gr01.model.leaderboard.User;
import org.l06gr01.viewer.Viewer;
import org.l06gr01.viewer.game.ElementViewer;

import java.io.IOException;
import java.util.Map;

import static java.lang.System.in;

public class UserViewer implements ElementViewer<Leaderboard> {

    @Override
    public void draw(Leaderboard element, GUI gui) throws IOException {
        Map<String, Integer> dic = element.getUsers();
        for (String user : element.getUsers().keySet()){
            gui.drawUser(element.getPosition(),user,dic.get(user));
        }
    }
}