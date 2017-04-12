package app.contracts;

import app.observer.ObservableTarget;

public interface Attacker {
    void attack();
    void setTarget(ObservableTarget target);
}
