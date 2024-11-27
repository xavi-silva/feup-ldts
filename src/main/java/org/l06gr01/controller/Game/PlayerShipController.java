package org.l06gr01.controller.Game;

import org.l06gr01.GUI.GUI;
import org.l06gr01.Game;
import org.l06gr01.model.Position;
import org.l06gr01.model.game.ShootingBehaviours.DoubleShooting;
import org.l06gr01.model.game.ShootingBehaviours.RegularShooting;
import org.l06gr01.model.game.ShootingBehaviours.ShootingBehaviour;
import org.l06gr01.model.game.ShootingBehaviours.TripleShooting;
import org.l06gr01.model.game.space.Space;

import java.util.Random;

public class PlayerShipController  extends GameController implements InvaderObserver, ScoreObserver{

    /*
     * Manage player upgrades
     * */
    private boolean upgraded = false;
    private final byte upgradeScoreGap = 100;
    private long lastScoreUpgrade = 0;
    private long timeLastUpgrade = -1;
    private long upgradeDuration = 8000;


    /*
    * Manage player movement and fire rate
    * */
    private int updateCounter = 0;
    long timeLastShot;
    long fireRate = 450;
    long fireRateLimit = 250;

    public PlayerShipController(Space model){
        super(model);
    }
    public void movePlayerShipRight(){
        movePlayerShip(getModel().getPlayerShip().getPosition().getRight());
    }
    public void movePlayerShipLeft(){
        movePlayerShip(getModel().getPlayerShip().getPosition().getLeft());
    }
    private void movePlayerShip(Position position) {
        if (getModel().isWithinBounds(position)) {
        getModel().getPlayerShip().setPosition(position);}}

    public void shoot(){
        getModel().getAllyProjectiles().addAll(getModel().getPlayerShip().shoot());
    }

    private void manageUpgrades(long time){
        if (upgraded){
            timeLastUpgrade = time;
            upgraded = false;
        }

        if (timeLastUpgrade != -1 && time - timeLastUpgrade > upgradeDuration) {
            getModel().getPlayerShip().setShootingBehaviour(new RegularShooting());
            timeLastUpgrade = -1;
        }



    }
    @Override
    public void step(Game game, GUI.ACTION action, long time){
        if (action == GUI.ACTION.RIGHT) movePlayerShipRight();
        if (action == GUI.ACTION.LEFT) movePlayerShipLeft();
        if (action == GUI.ACTION.UP && time - timeLastShot > fireRate){ shoot(); timeLastShot = time; }
        manageUpgrades(time);
}

    public long getFireRate(){
        return fireRate;
    }
    public void onInvaderDeath(){
        updateCounter++;
        if (updateCounter == 4 && fireRate > fireRateLimit){
            updateCounter = 0;
            fireRate -= 20;
        }
    }

    @Override
    public void updateScore(int score) {
        if (score == lastScoreUpgrade + upgradeScoreGap){
            lastScoreUpgrade += upgradeScoreGap;
            upgraded = true;

            Random random = new Random();
            int r = random.nextInt(4);

            /*75% chance of Double Shooting
            * 25% chance of Triple Shooting*/
            switch (r) {
                case 0:
                case 1:
                case 2:
                    getModel().getPlayerShip().setShootingBehaviour(new DoubleShooting());
                    break;
                case 3:
                    getModel().getPlayerShip().setShootingBehaviour(new TripleShooting());
                    break;
            }
        }
    }
}
