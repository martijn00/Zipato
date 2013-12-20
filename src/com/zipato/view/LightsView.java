/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zipato.view;

import com.codename1.ui.Form;
import com.codename1.ui.list.DefaultListModel;
import com.zipato.model.DataModel;
import com.zipato.model.IResponseHandler;
import java.util.ArrayList;
import java.util.Map;
import userclasses.StateMachine;

/**
 *
 * @author mvandijk
 */
public class LightsView {
    protected StateMachine ui;
    public static String FORM_NAME = "ScreenLights";
    
    public LightsView(StateMachine ui) {
        this.ui = ui;
    }
    
    public void show()
    {
        ui.showForm(FORM_NAME, null);
    }
    
    public void beforeShow(final Form f)
    {
        DataModel.getInstance().getLights(new IResponseHandler() {
            public void onSucces(Map data) {
                ui.findCtlLightsLights(f).setModel(new DefaultListModel((ArrayList)data));
            }

            public void onFailure(int code, String message) {
                
            }
        });
    }
}
