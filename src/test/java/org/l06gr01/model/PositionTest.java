package org.l06gr01.model;


import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    private final Position position = new Position(10,20);
    @Property
    void get(){
        assertEquals( 10,position.getX());
        assertEquals( 20,position.getY());
    }
    @Property
    void getLeft(@ForAll int x, @ForAll int y) {
        assertEquals(x - 1, new Position(x, y).getLeft().getX());
        assertEquals(y, new Position(x, y).getLeft().getY());
    }

    @Property
    void getRight(@ForAll int x, @ForAll int y) {
        assertEquals(x + 1, new Position(x, y).getRight().getX());
        assertEquals(y, new Position(x, y).getRight().getY());
    }

    @Property
    void equals(){
        Position newPosition = new Position(10,20);
        assertEquals(newPosition.getX(), position.getX());
        assertEquals(newPosition.getY(), position.getY());
    }
}
