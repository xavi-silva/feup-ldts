package org.l06gr01.viewer.instructions;

import org.l06gr01.GUI.GUI;
import org.l06gr01.model.Position;
import org.l06gr01.model.game.Element;
import org.l06gr01.viewer.Viewer;

import java.io.IOException;

public class instructionsViewer extends Viewer<Element> {
    public instructionsViewer(Element model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.drawText(new Position(2,0),"Esc","#03FFD1");
        gui.drawText(new Position(1,0),"↰","#03FFD1");
        gui.drawText(new Position(15, 2), " _____          _                   _   _                 ","#00FF00");
        gui.drawText(new Position(15, 3), "|_   _|        | |                 | | (_)                ","#00FF00");
        gui.drawText(new Position(15, 4), "  | | _ __  ___| |_ _ __ _   _  ___| |_ _  ___  _ __  ___ ","#00FF00");
        gui.drawText(new Position(15, 5), "  | || '_ \\/ __| __| '__| | | |/ __| __| |/ _ \\| '_ \\/ __|","#00FF00");
        gui.drawText(new Position(15, 6), " _| || | | \\__ \\ |_| |  | |_| | (__| |_| | (_) | | | \\__ \\","#00FF00");
        gui.drawText(new Position(15, 7), " \\___/_| |_|___/\\__|_|   \\__,_|\\___|\\__|_|\\___/|_| |_|___/","#00FF00");


        gui.drawText(new Position(8,13),"Movement","#00FF00");
        gui.drawText(new Position(0,16),"    ←             →","#FFFFFF");
        gui.drawText(new Position(0,15),"ArrowLeft     ArrowRight","#03FFD1");
        gui.drawText(new Position(39,13),"Shooting","#00FF00");
        gui.drawText(new Position(40,15),"ArrowUp","#03FFD1");
        gui.drawText(new Position(67,13),"Objective","#00FF00");
        gui.drawText(new Position(59,15),"We are being invaded!Shoot","#03FFD1");
        gui.drawText(new Position(59,16),"as many aliens as you can!","#03FFD1");
        gui.drawText(new Position(59,17),"For each alien destroyed","#03FFD1");
        gui.drawText(new Position(59,18),"you get +10 on your score","#03FFD1");
        gui.drawText(new Position(59,19),"and maybe an upgrade to","#03FFD1");
        gui.drawText(new Position(59,20),"help you. Go for the ","#03FFD1");
        gui.drawText(new Position(59,20),"first place on the Leaderboard. ","#03FFD1");
        gui.drawText(new Position(59,21),"Good Luck!","#03FFD1");
    }
}
