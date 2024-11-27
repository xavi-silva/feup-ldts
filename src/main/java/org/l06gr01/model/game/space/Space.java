package org.l06gr01.model.game.space;

import org.l06gr01.model.Position;
import org.l06gr01.model.game.*;
import org.l06gr01.model.game.projectiles.EnemyProjectile;

import java.util.ArrayList;
import java.util.List;

public class Space extends Element {

    private final int width;
    private final int height;
    private List<InvaderShip> invaderShips;
    private boolean invaderDirection;
    private Score score;
    private List<AllyProjectile> allyProjectiles;
    private List<EnemyProjectile> enemyProjectiles;
    private List<Barrier> barriers;
    private PlayerShip playerShip;

    public Space(Position position) {
        this.width = position.getX();
        this.height = position.getY();
        invaderDirection = true;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PlayerShip getPlayerShip() {
        return this.playerShip;
    }

    public void setPlayerShip(PlayerShip playerShip) {
        this.playerShip = playerShip;
    }

    public void setInvaderShips(List<InvaderShip> invaderShips) {
        this.invaderShips = invaderShips;
    }

    public List<InvaderShip> getInvaderShips() {
        return invaderShips;
    }

    public void setBarriers(List<Barrier> barriers) { this.barriers = barriers; }

    public List<Barrier> getBarriers() { return this.barriers; }
    public boolean isWithinBounds(Position position) {
        return position.getX() > 0 && position.getX() < width && position.getY() > 0 && position.getY() < height;
    }

    public InvaderShip getRightMostInvader(){
        int max = Integer.MIN_VALUE;
        InvaderShip rightMost = null;
        for (InvaderShip invader : invaderShips){
            if (invader.getPosition().getX() > max){
                rightMost = invader;
                max = invader.getPosition().getX();
            }
        }
        return rightMost;
    }

    public InvaderShip getLeftMostInvader(){
        int min = Integer.MAX_VALUE;
        InvaderShip leftMost = null;
        for (InvaderShip invader : invaderShips){
            if (invader.getPosition().getX() < min) {
                leftMost = invader;
                min = invader.getPosition().getX();
            }
        }
        return leftMost;
    }

    public boolean getDirection() {return invaderDirection;}
    public void switchDirection(){invaderDirection = !invaderDirection;}

    public List<AllyProjectile> getAllyProjectiles() {
        return allyProjectiles;
    }

    public void setAllyProjectiles(List<AllyProjectile> allyProjectiles) {
        this.allyProjectiles = allyProjectiles;
    }

    public List<EnemyProjectile> getEnemyProjectiles() {
        return enemyProjectiles;
    }

    public void setEnemyProjectiles(List<EnemyProjectile> enemyProjectiles) {
        this.enemyProjectiles = enemyProjectiles;
    }

    public List<Projectile> getProjectiles() {
        List<Projectile> projectiles = new ArrayList<>();
        projectiles.addAll(enemyProjectiles);
        projectiles.addAll(allyProjectiles);
        return projectiles;
    }


    public Barrier isBarrier(Position position){
        for (Barrier b : this.barriers){
            if(b.getPosition().equals(position)) return b;
        }
        return null;
    }

    public InvaderShip isInvader(Position position){
        for (InvaderShip i : this.invaderShips){
            if(i.getPosition().equals(position)) return i;
        }
        return null;
    }
    public void setScore(Score score){
        this.score=score;
    }
    public Score getScore() {
        return score;
    }
}
