package app.loggers;

import app.enums.LogType;

public class TargetLogger extends Logger {


    @Override
    public void handle(LogType logType, String message) {
        if(logType == LogType.TARGET){
            System.out.println(logType.name() + ": " + message);
        }else{
            super.passToSuccessor(logType, message);
        }
    }
}
