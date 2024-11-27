package org.l06gr01.controller.Game;

public interface Observed<T extends Observer> {
    void notifyObservers();
    void addObserver(T obs);
    void removeObserver(T obs);
}
