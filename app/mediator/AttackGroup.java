package app.mediator;

import app.contracts.Attacker;
import app.contracts.Target;
import app.observer.ObservableTarget;

public interface AttackGroup {

    void addMember(Attacker attacker);

    void groupTarget(ObservableTarget target);

    void groupAttack();

}
