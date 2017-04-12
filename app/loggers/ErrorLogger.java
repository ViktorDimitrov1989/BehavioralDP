package app.loggers;

import app.enums.LogType;

public class ErrorLogger extends Logger{

    @Override
    public void handle(LogType logType, String message) {
        if(logType == LogType.ERROR){
            System.out.println(logType.name() + ": " + message);
        }else{
            super.passToSuccessor(logType,message);
        }
    }
}
