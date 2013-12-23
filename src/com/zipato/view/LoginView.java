/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipato.view;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.Storage;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
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
    
    public void beforeShow(final Form f)
    {
        ui.findCbxLoginRemember(f).setSelected(true);
        
        DataModel.getInstance().init(new IResponseHandler() {
            public void onSucces(Map data) {
                if(Storage.getInstance().exists("SHA1Password"))
                {
                    login((String)Storage.getInstance().readObject("Username"), (String)Storage.getInstance().readObject("SHA1Password"), true, f);
                }
            }
            public void onFailure(int code, String message) {
                
            }
        });
    }
    
    public void btnLoginAction(Component c, ActionEvent event) 
    {
        login(ui.findTfdLoginUsername().getText(), ui.findTfdLoginPassword().getText(), false, c.getParent());
    }
    
    private void login(String username, String password, final Boolean silent, final Container ctn)
    {
        InfiniteProgress inf = new InfiniteProgress();            
        final Dialog progress = inf.showInifiniteBlocking();
        
        DataModel.getInstance().getLogin(username, password, new IResponseHandler() {
            public void onSucces(Map data) {
                if(data.get("success").equals("true"))
                {
                    if(ui.findCbxLoginRemember(ctn).isSelected() && silent == false)
                    {
                        Storage.getInstance().writeObject("Username", ui.findTfdLoginUsername(ctn).getText());
                        Storage.getInstance().writeObject("SHA1Password", ui.findTfdLoginPassword(ctn).getText());
                    }
                    
                    progress.dispose();
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
