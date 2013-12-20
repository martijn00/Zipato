/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipato.view;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.zipato.model.DataModel;
import com.zipato.model.IResponseHandler;
import java.util.Map;
import userclasses.StateMachine;

/**
 *
 * @author Martijn
 */
public class HomeView {
    protected StateMachine ui;
    public static String FORM_NAME = "ScreenNews";
    
    public HomeView(StateMachine ui) {
        this.ui = ui;
    }
    
    public void show()
    {
        ui.showForm(FORM_NAME, null);
    }
    
    public void beforeShow(Form f)
    {
        ui.findSlrNewsLight(f).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                DataModel.getInstance().putLight("", ui.findSlrNewsLight().getProgress(), new IResponseHandler() {
                    public void onSucces(Map data) {
                        System.out.println("set light success: " + data.get("success").toString());
                    }
                    public void onFailure(int code, String message) {

                    }
                });
            }
        });
    }
}
