/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipato.view;

import com.codename1.ui.Component;
import com.codename1.ui.events.ActionEvent;
import com.zipato.controller.User;
import com.zipato.model.DataModel;
import com.zipato.model.IResponseHandler;
import java.util.HashMap;
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
    
    public void btnLoginLoginAction(Component c, ActionEvent event) 
    {
        Map loginParams = new HashMap();
        loginParams.put("username", ui.findTfdLoginUsername().getText());
        loginParams.put("token", User.getToken(ui.findTfdLoginPassword().getText(), DataModel.nonce));
        
        DataModel.getInstance().getLogin(loginParams, new IResponseHandler() {
            public void onSucces(Map data) {
                if(data.get("success").equals("true"))
                {
                    ui.newsView.show();
                }
            }
            public void onFailure(int code, String message) {
                System.out.println("fail");
            }
        });
    }
}
