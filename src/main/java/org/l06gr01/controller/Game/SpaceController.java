package org.l06gr01.controller.Game;

import org.l06gr01.GUI.GUI;
import org.l06gr01.Game;
import org.l06gr01.model.Position;
import org.l06gr01.model.game.space.Space;
import org.l06gr01.model.leaderboard.Leaderboard;
import org.l06gr01.model.leaderboard.LoaderLeaderboardBuilder;
import org.l06gr01.model.leaderboard.User;
import org.l06gr01.model.menu.Menu;
import org.l06gr01.states.LeaderState;
import org.l06gr01.states.MenuState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SpaceController  extends GameController implements InvaderObserver {
    private final PlayerShipController playerShipController;
    private final InvaderShipController invaderShipController;
    private final AllyProjectileController allyProjectileController;
    private final EnemyProjectileController enemyProjectileController;
    private final ScoreController scoreController;
    private User user;
    public SpaceController(Space space) {

        super(space);

        this.playerShipController = new PlayerShipController(space);
        this.invaderShipController = new InvaderShipController(space);
        this.allyProjectileController = new AllyProjectileController(space);
        this.enemyProjectileController = new EnemyProjectileController(space);
        this.scoreController= new ScoreController(space);

        allyProjectileController.addObserver(playerShipController);
        allyProjectileController.addObserver(invaderShipController);
        allyProjectileController.addObserver(this);

        scoreController.addObserver(playerShipController);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getPlayerShip().getHealth() == 0 ){
            savePlayerScore(getModel().getScore().getScore());
            game.setState(new LeaderState(new LoaderLeaderboardBuilder().createLeaderboard()));}
        else {
            playerShipController.step(game, action, time);
            invaderShipController.step(game, action, time);
            allyProjectileController.step(game, action, time);
            enemyProjectileController.step(game, action, time);

        }
    }
    public void onInvaderDeath(){
        if(allyProjectileController.getKilled()){
            scoreController.onInvaderDeath();
    }
        allyProjectileController.setKilled(false);}
    void savePlayerScore(Integer score){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/Pontos", true))) {
            writer.write("," + score);
            writer.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    }

