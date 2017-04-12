package app.loggers;

import app.contracts.Handler;
import app.enums.LogType;

//Chain of responsibility pattern
public abstract class Logger implements Handler{
    private Handler successor;

    //Pass to the command to the next handler/logger
    //Handler can be injected through the constructor!
    @Override
    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }

    protected void passToSuccessor(LogType type, String message){
        if(this.successor != null){
            this.successor.handle(type,message);
        }
    }

}
