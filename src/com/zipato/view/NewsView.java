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
public class NewsView {
    protected StateMachine ui;
    public static String FORM_NAME = "ScreenNews";
    
    public NewsView(StateMachine ui) {
        this.ui = ui;
    }
    
    public void show()
    {
        ui.showForm(FORM_NAME, null);
    }
    
    public void btnNewsLightAction(Component c, ActionEvent event) 
    {
        Map lightParams = new HashMap();
        //lightParams.put("uuid", "a17a13d2-3fa8-44b4-a73d-7835f948eff2");
        //lightParams.put("attribute", "8");
        lightParams.put("p_body", "true");

        DataModel.getInstance().putLight(lightParams, new IResponseHandler() {

            public void onSucces(Map data) {
                System.out.println("set light success: " + data.get("success").toString());
            }

            public void onFailure(int code, String message) {

            }
        });
    }
}
