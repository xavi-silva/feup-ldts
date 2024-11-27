package org.l06gr01.viewer.Leaderboard;

import org.l06gr01.GUI.GUI;
import org.l06gr01.model.Position;
import org.l06gr01.model.game.Element;
import org.l06gr01.model.leaderboard.Leaderboard;
import org.l06gr01.model.leaderboard.User;
import org.l06gr01.viewer.Viewer;
import org.l06gr01.viewer.game.ElementViewer;
import org.l06gr01.viewer.game.InvaderShipViewer;
import org.l06gr01.viewer.game.ScoreViewer;

import java.io.IOException;
import java.util.*;

public class LeaderboardViewer extends Viewer<Leaderboard> {
    public LeaderboardViewer(Leaderboard leaders) {
        super(leaders);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        int y=getModel().getInput().getY();
        int x=getModel().getInput().getX();
        gui.drawText(new Position(2,0),"Esc","#03FFD1");
        gui.drawText(new Position(1,0),"↰","#03FFD1");

        gui.drawText(new Position(13, 1), " _                    _           _                         _ ","#00FF00");
        gui.drawText(new Position(13, 2), "| |                  | |         | |                       | |","#00FF00");
        gui.drawText(new Position(13, 3), "| |     ___  __ _  __| | ___ _ __| |__   ___   __ _ _ __ __| |","#00FF00");
        gui.drawText(new Position(13, 4), "| |    / _ \\/ _` |/ _` |/ _ \\ '__| '_ \\ / _ \\ / _` | '__/ _` |","#00FF00");
        gui.drawText(new Position(13, 5), "| |___|  __/ (_| | (_| |  __/ |  | |_) | (_) | (_| | | | (_| |","#00FF00");
        gui.drawText(new Position(13, 6), "\\_____/\\___|\\__,_|\\__,_|\\___|_|  |_.__/ \\___/ \\__,_|_|  \\__,_|","#00FF00");

        int currentY = 10;  // Defina a posição inicial de y

        gui.drawText(new Position(30, currentY++), "                            _o_", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "                        _,-=(_)=-,_                      ,_o_,", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "     .-=-.              '         '                     =======", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "                                                _____----(_o_)----_____", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "                 //-n-\\\\                       /    '-------------'    \\", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "         _____---=======---_____              ['                        ']", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "     ====____\\   /.. ..\\   /____====", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "   //         ---\\__O__/---         \\\\", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "   \\_\\                             /_/", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "                                     _", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "                                   _|_|_", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "                                 ^/ . ..\\^", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "                             ___[=========]___", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "                  ___-==++\"\"\" .  /. . .  \\ .  \"\"\"++==-___", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "            __-+\"\" __\\   .. . .  | ..  . |  . .  .   /__ \"\"+-__", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "           /\\__+-\"\"   `-----=====\\_  _/=====-----'   \"\"-+/\\", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "         _/_/                      \"\"=\"\"                      \\_\\_", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "        /_/                                                     \\_\\", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "       //                                                         \\\\", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "      /\")                                                         (\"\\", "#03FFD1");
        gui.drawText(new Position(30, currentY++), "      \\o\\                                                         /o/", "#03FFD1");
        gui.drawText(new Position(30, currentY), "       \\_)                                                       (_/", "#03FFD1");


        Map<String, Integer> dic = getModel().getUsers();
        //gui.drawText(getModel().getInput(), "_____", "#00FF00");
        if(getModel().getUsers()!=null){
        for( String user : getModel().getUsers().keySet()){
            gui.drawUser(new Position(getModel().getInput().getX(),y),user,dic.get(user));y++;
        }}
        }
    }



