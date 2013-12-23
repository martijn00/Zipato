package com.zipato.app;


import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.zipato.model.DataModel;
import com.zipato.model.IResponseHandler;
import java.util.Map;
import userclasses.StateMachine;

public class Main {
   
    private Form current;

    public void init(Object context) {
        // Pro users - uncomment this code to get crash reports sent to you automatically
        /*Display.getInstance().addEdtErrorHandler(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                evt.consume();
                Log.p("Exception in AppName version " + Display.getInstance().getProperty("AppVersion", "Unknown"));
                Log.p("OS " + Display.getInstance().getPlatformName());
                Log.p("Error " + evt.getSource());
                Log.p("Current Form " + Display.getInstance().getCurrent().getName());
                Log.e((Throwable)evt.getSource());
                Log.sendLog();
            }
        });*/
    }

    public void start() {
        if(current != null){
            current.show();
            return;
        }
        new StateMachine("/theme");        
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
        
        DataModel.getInstance().getLogout(new IResponseHandler() {
            public void onSucces(Map data) {
                System.out.println("logout");
            }
            public void onFailure(int code, String message) {

            }
        });
    }
    
    public void destroy() {
        
    }
}
