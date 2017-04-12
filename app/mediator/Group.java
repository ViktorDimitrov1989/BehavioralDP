package app.mediator;

import app.contracts.Attacker;
import app.contracts.Target;
import app.observer.ObservableTarget;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {
    private List<Attacker> attackerGroup;

    public Group() {
        this.attackerGroup = new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackerGroup.add(attacker);
    }

    @Override
    public void groupTarget(ObservableTarget target) {
        for (Attacker attacker : this.attackerGroup) {
            attacker.setTarget(target);
        }
    }

    @Override
    public void groupAttack() {
        for (Attacker attacker : this.attackerGroup) {
            attacker.attack();
        }
    }
}
