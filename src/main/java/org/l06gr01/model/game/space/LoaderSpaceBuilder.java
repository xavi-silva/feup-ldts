package org.l06gr01.model.game.space;

import org.l06gr01.model.game.*;
import org.l06gr01.model.game.projectiles.EnemyProjectile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoaderSpaceBuilder extends SpaceBuilder{
    @Override
    protected int getWidth() {
        return 90;
    }

    @Override
    protected int getHeight() {
        return 30;
    }

    @Override
    public List<InvaderShip> createInvaderShips() {

        List<InvaderShip> invaders= new ArrayList<>();
        for(int x = 41 ; x < 57; x += 2){
            for (int y = 5; y < 8 ; y++) {
                invaders.add(new InvaderShip(x, y));
            }
        }
        return invaders;
    }

    @Override
    public List<Barrier> createBarriers() {
        Random random = new Random();

        int randomNumber = random.nextInt(6);
        int offset = - 30 + randomNumber * 10;

        List<Barrier> barriers = new ArrayList<>();
        barrierGenerator(barriers, offset);
        return barriers;
    }

    public void barrierGenerator(List<Barrier> barriers, int offset){

        for(int x = 37 + offset ; x < 53 + offset; x += 1){
            for (int y = 15; y < 18 ; y++) {
                barriers.add(new Barrier(x, y));
            }
        }
    }


    @Override
    public List<AllyProjectile> createAllyProjectiles() {
        List<AllyProjectile> projectiles = new ArrayList<AllyProjectile>();
        return projectiles;
    }

    @Override
    public List<EnemyProjectile> createEnemyProjectiles() {
        List<EnemyProjectile> projectiles = new ArrayList<EnemyProjectile>();
        return projectiles;
    }



    @Override
    public PlayerShip createPlayerShip() {
        return new PlayerShip(45,25);
    }

    @Override
    public Score createScore(){return new Score(1,1);}

}
