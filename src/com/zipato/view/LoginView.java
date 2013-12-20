/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipato.view;

import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.zipato.model.DataModel;
import com.zipato.model.IResponseHandler;
import java.util.Map;
import userclasses.StateMachine;

/**
 *
 * @author Martijn
 */
public class LoginView {
    protected StateMachine ui;
    public static String FORM_NAME = "ScreenLogin";
    
    public LoginView(StateMachine ui) {
        this.ui = ui;
    }
    
    public void show()
    {
        ui.showForm(FORM_NAME, null);
    }
    
    public void beforeShow(Form f)
    {
        
    }
    
    public void btnLoginAction(Component c, ActionEvent event) 
    {
        DataModel.getInstance().getLogin(ui.findTfdLoginUsername().getText(), ui.findTfdLoginPassword().getText(), new IResponseHandler() {
            public void onSucces(Map data) {
                if(data.get("success").equals("true"))
                {
                    ui.homeView.show();
                }
                else
                {
                    Dialog.show("Error login", "Use correct username and password", "OK", "Cancel");
                }
            }
            public void onFailure(int code, String message) {
                System.out.println("fail");
            }
        });
    }
}
