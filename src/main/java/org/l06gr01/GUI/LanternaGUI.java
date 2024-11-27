package org.l06gr01.GUI;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.l06gr01.model.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        // AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height /*,fontConfig*/);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height/*, AWTTerminalFontConfiguration fontConfig*/) throws IOException{
        TerminalSize terminalSize = new TerminalSize(width, height + 1);

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        //terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }


/*
    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }*/


    @Override
    public void drawText(Position position, String text, String color) {
        if (position!=null){
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }}

    @Override
    public Character getNextChar() throws IOException {
        KeyStroke key=screen.readInput();
        return key.getCharacter();
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;
        if (keyStroke.getKeyType() == KeyType.EOF || keyStroke.getKeyType() == KeyType.Escape) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
        if (keyStroke.getKeyType()==KeyType.Character) return ACTION.WRITE;
        return ACTION.NONE;
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    @Override
    public void drawPlayerShip(Position position) {
        drawCharacter(position.getX(), position.getY(), '▲', "#00FF00");
    }
    @Override
    public void drawSpace() throws IOException {

        Random random=new Random();
        int spaceWidth = 90;
        int spaceHeight = 30;
        int numStars = spaceWidth * spaceHeight /200;
        for (int i = 0; i < numStars; i++) {
            int x = random.nextInt(spaceWidth);
            int y = random.nextInt(spaceHeight);
            drawCharacter(x,y,'★',"#D3D3D3");
        }

    }

    @Override
    public void drawInvaderShip(Position position){
        drawCharacter(position.getX(), position.getY(), '∇', "#FF0000");
    }

    @Override
    public void drawBarrier(Position position) {
        drawCharacter(position.getX(), position.getY(), '▭', "#808080");
    }
    @Override
    public void drawProjectile(Position position,boolean team){
        if(team){
        drawCharacter(position.getX(), position.getY(), '▯', "#39FF14");}
        else{
        drawCharacter(position.getX(), position.getY(), '▯', "#FF0000");
    }}
    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    private void drawScoreString(int x, int y, int score, String color) {
        String aux = Integer.toString(score);
        String newStr="SCORE: "+aux;
        for(int j=0; j<newStr.length();j++){
            char character=newStr.charAt(j);
            drawCharacter(x,y,character,color);
            x++;
        }
    }
    @Override
    public void drawScore(Position position, int score){
    drawScoreString(position.getX(),position.getY(),score,"#FFFFFF");}

    @Override
    public void drawHealth(Position position, int health){
        int auxX=position.getX();
        int auxY=position.getY();
        for(int i=0;i<health;i++){
            drawCharacter(auxX,auxY,'❤', "#E0115F");
            auxX++;
        }
    }
    @Override
    public void drawUser(Position position, String user, Integer score){
        int x=0;
        int y=10;
        if(position!=null){
        x = position.getX();
        y = position.getY();}
        if(user!=null){
        for (int j = 0; j < user.length(); j++) {
            char character = user.charAt(j);
            drawCharacter(x, y, character, "#FFFF00");
            x++;}}

        drawScore(new Position(15,y), score);
    }

}
