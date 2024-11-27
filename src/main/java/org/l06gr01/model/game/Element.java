package org.l06gr01.model.game;

import org.l06gr01.model.Position;

public class Element {
    protected Position position;

    public Element(Position position) {
        this.position = position;
    }

    public Element() {
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
