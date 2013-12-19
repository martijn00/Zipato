/**
 * Your application code goes here
 */

package userclasses;

import generated.StateMachineBase;
import com.codename1.ui.*; 
import com.codename1.ui.events.*;
import com.codename1.ui.util.Resources;
import com.zipato.model.DataModel;
import com.zipato.view.LoginView;
import com.zipato.view.NewsView;

/**
 *
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {
    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }
    
    public LoginView loginView;
    public NewsView newsView;
    
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    @Override
    protected void initVars(Resources res) {
        loginView = new LoginView(this);
        newsView = new NewsView(this);
        
        DataModel.getInstance().init();
    }
    
    @Override
    protected void onScreenLogin_BtnLoginLoginAction(Component c, ActionEvent event) 
    {
        loginView.btnLoginLoginAction(c, event);
    }

    @Override
    protected void onScreenNews_BtnNewsLightAction(Component c, ActionEvent event) 
    {
        newsView.btnNewsLightAction(c, event);
    }
}
