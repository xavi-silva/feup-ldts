package org.l06gr01.viewer.usernameInput;

import org.l06gr01.GUI.GUI;
import org.l06gr01.model.Position;
import org.l06gr01.model.leaderboard.User;
import org.l06gr01.viewer.Viewer;

import java.io.IOException;

public class usernameInputViewer extends Viewer<User> {
    public usernameInputViewer(User model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.drawText(new Position(25,2),"Welcome! Please insert your nickname :)","#00FF00");
        gui.drawText(new Position(3,15),"Nickname: "+getModel().getUsername(),"#FFFFFF");

        int currentY = 3;  // Defina a posição inicial de y

        gui.drawText(new Position(55, currentY++), "      _              _", "#03FFD1");
        gui.drawText(new Position(55, currentY++), "     //              \\\\", "#03FFD1");
        gui.drawText(new Position(55, currentY++), "    /'                `\\", "#03FFD1");
        gui.drawText(new Position(55, currentY++), "   /,'     ..-..       `\\", "#03FFD1");
        gui.drawText(new Position(55, currentY++), "  /,'   .''     ``.     `\\", "#03FFD1");
        gui.drawText(new Position(55, currentY++), " /,'   :   .---.   :    '`\\", "#03FFD1");
        gui.drawText(new Position(55, currentY++), "| |   :  .'\\   /`.  :   | |", "#03FFD1");
        gui.drawText(new Position(55, currentY++), "| |__:   . .`~'. .   :__| |", "#03FFD1");
        gui.drawText(new Position(55, currentY++), "|  __:   . `._.' .   :__ |", "#03FFD1");
        gui.drawText(new Position(55, currentY++), "| |   :   ./   \\.   :   | |", "#03FFD1");
        gui.drawText(new Position(55, currentY++), " \\`.   :   `---'   :   ,'/", "#03FFD1");
        gui.drawText(new Position(55, currentY++), "  \\`.   `..     ..'   ,'/", "#03FFD1");
        gui.drawText(new Position(55, currentY++), "   \\`.     ``~''     ,'/", "#03FFD1");
        gui.drawText(new Position(55, currentY++), "    \\`               '/    ", "#03FFD1");
        gui.drawText(new Position(55, currentY++), "     \\\\             //", "#03FFD1");
        gui.drawText(new Position(55, currentY), "      -             -", "#03FFD1");

        int startX = 20;  // Defina a posição inicial de x
        int startY = 10;  // Defina a posição inicial de y

        gui.drawText(new Position(startX, startY++), "             _     _", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "            /_|   |_\\", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "           //||   ||\\\\", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "          // ||   || \\\\", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "         //  ||___||  \\\\", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "        /     |   |     \\    _", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "       /    __|   |__    \\  /_\\", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "      / .--~  |   |  ~--. \\|   |", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "     /.~ __\\  |   |  /   ~.|   |", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "    .~  `=='\\ |   | /   _.-'.  |", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "   /  /      \\|   |/ .-~    _.-'", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "  |           +---+  \\  _.-~  |", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "  `=----.____/  #  \\____.----='", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "   [::::::::|  (_)  |::::::::]", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "  .=----~~~~~\\     /~~~~~----=.", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "  |          /`---'\\          |", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "   \\  \\     /       \\     /  /", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "    `.     /         \\     .'", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "      `.  /._________.\\  .'", "#03FFD1");
        gui.drawText(new Position(startX, startY++), "        `--._________.--'     ", "#03FFD1");



    }
}
