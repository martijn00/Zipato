/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zipato.view;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.zipato.model.DataModel;
import com.zipato.model.IResponseHandler;
import java.util.Iterator;
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
                Iterator it = data.entrySet().iterator();
                while (it.hasNext()) {
                    final Map.Entry pairs = (Map.Entry)it.next();
                    Map light = (Map)pairs.getValue();
                    Map attributes = (Map)light.get("attributes");
                    Map attributeValue = (Map)attributes.get("8");
                    
                    Container lightContainer = StateMachine.createContainer("ViewLight");
                    Button btnLightSwitch = (Button)lightContainer.getClientProperty("%btnLightSwitch%");
                    Button btnLightOptions = (Button)lightContainer.getClientProperty("%btnLightOptions%");
                    
                    Label lblLightName = (Label)lightContainer.getClientProperty("%lblLightName%");
                    lblLightName.setText(light.get("name").toString());
                    
                    final Slider sldLightControl = (Slider)lightContainer.getClientProperty("%sldLightControl%");
                    sldLightControl.setProgress(Integer.parseInt((String)attributeValue.get("value")));
                    sldLightControl.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            DataModel.getInstance().putLight((String)pairs.getKey(), sldLightControl.getProgress(), new IResponseHandler() {
                                public void onSucces(Map data) {
                                    System.out.println("set light success: " + data.get("success").toString());
                                }
                                public void onFailure(int code, String message) {

                                }
                            });
                        }
                    });
                            
                    f.addComponent(lightContainer);
                }
            }

            public void onFailure(int code, String message) {
                
            }
        });
    }
}
