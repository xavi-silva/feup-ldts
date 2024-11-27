package org.l06gr01.viewer.menu;

import org.l06gr01.GUI.GUI;
import org.l06gr01.model.Position;
import org.l06gr01.viewer.Viewer;
import org.l06gr01.model.menu.Menu;

import java.awt.*;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    //@Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(2,0),"Esc","#03FFD1");
        gui.drawText(new Position(1,0),"↰","#03FFD1");

        int currentY = 10;

        gui.drawText(new Position(30, 3), "___  ___                 ","#00FF00");
        gui.drawText(new Position(30, 4), "|  \\/  |                 ","#00FF00");
        gui.drawText(new Position(30, 5), "| .  . | ___ _ __  _   _ ","#00FF00");
        gui.drawText(new Position(30, 6), "| |\\/| |/ _ \\ '_ \\| | | |","#00FF00");
        gui.drawText(new Position(30, 7), "| |  | |  __/ | | | |_| |","#00FF00");
        gui.drawText(new Position(30, 8), "\\_|  |_/\\___|_| |_|\\__,_|","#00FF00");

        gui.drawText(new Position(15, currentY++), "                     `. ___", "#03FFD1");
        gui.drawText(new Position(15, currentY++), "                     __,' __`.                _..----....____", "#03FFD1");
        gui.drawText(new Position(15, currentY++), "         __...--.'``;.   ,.   ;``--..__     .'    ,-._    _.-'", "#03FFD1");
        gui.drawText(new Position(15, currentY++), "   _..-''-------'   `'   `'   `'     O ``-''._   (,;') _,'", "#03FFD1");
        gui.drawText(new Position(15, currentY++), " ,'________________                          \\`-._`-',", "#03FFD1");
        gui.drawText(new Position(15, currentY++), "  `._              ```````````------...___   '-.._'-:", "#03FFD1");
        gui.drawText(new Position(15, currentY++), "     ```--.._      ,.                     ````--...__\\-.", "#03FFD1");
        gui.drawText(new Position(15, currentY++), "             `.--. `-`                       ____    |  |`", "#03FFD1");
        gui.drawText(new Position(15, currentY++), "               `. `.                       ,'`````.  ;  ;`", "#03FFD1");
        gui.drawText(new Position(15, currentY++), "                 `._`.        __________   `.      \\'__/'", "#03FFD1");
        gui.drawText(new Position(15, currentY++), "                    `-:._____/______/___/____`.     \\  `", "#03FFD1");
        gui.drawText(new Position(15, currentY++), "                                |       `._    `.    \\", "#03FFD1");
        gui.drawText(new Position(15, currentY++), "                                `._________`-.   `.   `.___", "#03FFD1");
        gui.drawText(new Position(15, currentY), "                                                `------'`", "#03FFD1");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(40, 15 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#00FF00" : "#FFFFFF");
    }
}
