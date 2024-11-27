package org.l06gr01.controller.Game;

import org.l06gr01.GUI.GUI;
import org.l06gr01.Game;
import org.l06gr01.model.Position;
import org.l06gr01.model.game.InvaderShip;
import org.l06gr01.model.game.space.LoaderSpaceBuilder;
import org.l06gr01.model.game.space.Space;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class InvaderShipController extends GameController implements InvaderObserver {
    private int updateCounter = 0;
    long moveRate = 100;
    final long fireRateLimit = 150;
    long fireRate = 1000;
    long timeLastShot = 0;
    long timeLastMovement = 0;

    public InvaderShipController(Space model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (getModel().getInvaderShips().isEmpty()){

            Space tempSpace = new LoaderSpaceBuilder().createSpace();

            getModel().setInvaderShips(tempSpace.getInvaderShips());
            getModel().setBarriers(tempSpace.getBarriers());
            updateCounter = 0;
            //fireRate = 1000;
            //moveRate = 100;
            getModel().getPlayerShip().increaseHealth();


        }

        if (time - timeLastMovement > moveRate) {
            if (!getModel().isWithinBounds(getModel().getRightMostInvader().getPosition().getRight())
                    || !getModel().isWithinBounds(getModel().getLeftMostInvader().getPosition().getLeft()))
                getModel().switchDirection();


            List<InvaderShip> invasores = getModel().getInvaderShips();
            for (InvaderShip invader : invasores) {
                if (getModel().getDirection()) moveInvaderShip(invader, invader.getPosition().getRight());
                else moveInvaderShip(invader, invader.getPosition().getLeft());
            }
            timeLastMovement = time;
        }

        //Make a random Invader Shoot TODO: make them shoot more frequently
        if (time - timeLastShot > fireRate) {
            Random random = new Random();
            int randomIndex = random.nextInt(getModel().getInvaderShips().size());
            InvaderShoot(randomIndex);
            timeLastShot = time;
        }
    }
    public void moveInvaderShip(InvaderShip invader,Position position) {
        invader.setPosition(position);
    }

    public void InvaderShoot(int index) {
        getModel().getEnemyProjectiles().addAll(getModel().getInvaderShips().get(index).shoot());
    }

    public long getMoveRate(){
        return moveRate;
    }

    public long getFireRate(){
        return fireRate;
    }

    public void onInvaderDeath(){
        updateCounter++;
        if (updateCounter == 4){
            updateCounter = 0;
            moveRate -= 10;
            if(fireRate > fireRateLimit) fireRate -= 80;
        }

    }

}
