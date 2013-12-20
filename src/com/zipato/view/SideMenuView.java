/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zipato.view;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.SideMenuBar;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import userclasses.StateMachine;

/**
 *
 * @author mvandijk
 */
public class SideMenuView {
    protected StateMachine ui;
    
    public SideMenuView(StateMachine ui) {
        this.ui = ui;
    }
    
    public void show()
    {
        
    }
    
    public void beforeShow(final Form f)
    {
        if(!f.getName().equals(LoginView.FORM_NAME))
        {
            ui.setHomeForm(f.getName());
            System.out.println("setHome: " + f.getName());
            
            f.addCommand(buildMenuCommand("Home", "", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    SideMenuBar.closeCurrentMenu(new Runnable() {
                        @Override
                        public void run() {
                            Display.getInstance().getCurrent().setTransitionOutAnimator(CommonTransitions.createEmpty());
                            ui.homeView.show();
                        }
                    });
                }
            }));
            
            f.addCommand(buildMenuCommand("Lights", "", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    SideMenuBar.closeCurrentMenu(new Runnable() {
                        @Override
                        public void run() {
                            Display.getInstance().getCurrent().setTransitionOutAnimator(CommonTransitions.createEmpty());
                            ui.lightsView.show();
                        }
                    });
                }
            }));
        }
    }
    
    private Command buildMenuCommand(String title, String icon, ActionListener listener)
    {
        Button l = new Button(title);

        //Image iconImage = StateMachine.getResourceFile().getImage(icon);
        //iconImage.lock();
        //l.setIcon(iconImage);
        l.setGap(20);
        //l.setUIID("NavigationButton");
        l.addActionListener(listener);

        Command c = new Command(title);
        c.putClientProperty("SideComponent", l);

        return c;
    }
}
