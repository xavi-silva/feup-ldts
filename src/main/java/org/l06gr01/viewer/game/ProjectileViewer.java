package org.l06gr01.viewer.game;

import org.l06gr01.GUI.GUI;
import org.l06gr01.model.game.Barrier;
import org.l06gr01.model.game.Projectile;

import java.io.IOException;

public class ProjectileViewer implements ElementViewer<Projectile>{
    @Override
    public void draw(Projectile element, GUI gui) throws IOException {
        gui.drawProjectile(element.getPosition(), element.isTeam());
    }
}
