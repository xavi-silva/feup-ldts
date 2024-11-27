package org.l06gr01.controller.usernameInput;

import org.l06gr01.GUI.GUI;
import org.l06gr01.Game;
import org.l06gr01.controller.Controller;
import org.l06gr01.model.game.space.LoaderSpaceBuilder;
import org.l06gr01.model.leaderboard.User;
import org.l06gr01.states.GameState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class usernameInputController extends Controller<User> {
    byte iter = 0;
    public usernameInputController(User model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (iter == 0) { iter++; return;}

        Character c = game.getGui().getNextChar();
       if (c == null || !Character.isLetterOrDigit(c)) {
            savePlayerName(getModel().getUsername());
            game.setState(new GameState(new LoaderSpaceBuilder().createSpace()));
       } else {
           handleInput(c);
       }

    }

    private void handleInput(Character input) {
        getModel().appendToName(input);
    }

    void savePlayerName(String name) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/Pontos", true))) {
            writer.write(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}