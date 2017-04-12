package app.loggers;

import app.enums.LogType;

public class EventLogger extends Logger{

    @Override
    public void handle(LogType logType, String message) {
        if(logType == LogType.EVENT){
            System.out.println(logType.name() + ": " + message);
        }else{
            super.passToSuccessor(logType, message);
        }
    }

}
