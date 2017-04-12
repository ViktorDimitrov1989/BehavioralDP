package app;

import app.commands.Command;
import app.commands.groupCommands.GroupAttackCommand;
import app.commands.groupCommands.GroupTargetCommand;
import app.commands.idividualCommands.AttackCommand;
import app.commands.CommandExecutor;
import app.commands.Executor;
import app.commands.idividualCommands.TargetCommand;
import app.loggers.CombatLogger;
import app.loggers.ErrorLogger;
import app.loggers.EventLogger;
import app.loggers.TargetLogger;
import app.mediator.AttackGroup;
import app.mediator.Group;
import app.models.AbstractHero;
import app.models.Dragon;
import app.models.Warrior;
import app.observer.ObservableTarget;

public class Main {
    public static void main(String[] args) {
        CombatLogger combatLogger = new CombatLogger();
        EventLogger eventLogger = new EventLogger();
        ErrorLogger errorLogger = new ErrorLogger();
        TargetLogger targetLogger = new TargetLogger();

        combatLogger.setSuccessor(eventLogger);
        eventLogger.setSuccessor(errorLogger);
        errorLogger.setSuccessor(targetLogger);

        Executor commandExecutor = new CommandExecutor();

        AbstractHero hero = new Warrior("Pesho", 10, combatLogger);
        AbstractHero hero1 = new Warrior("Kiro", 100, combatLogger);
        AbstractHero hero2 = new Warrior("Stoqn", 30, combatLogger);

        AttackGroup attackGroup = new Group();
        attackGroup.addMember(hero);
        attackGroup.addMember(hero1);
        attackGroup.addMember(hero2);

        ObservableTarget enemy = new Dragon("Drakonche", 30, 10, combatLogger);

        Command groupTargetCommand = new GroupTargetCommand(attackGroup,enemy);
        commandExecutor.executeCommand(groupTargetCommand);

        Command groupAttackCommand = new GroupAttackCommand(attackGroup);
        commandExecutor.executeCommand(groupAttackCommand);

    }
}
