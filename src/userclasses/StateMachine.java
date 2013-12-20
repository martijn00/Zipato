/**
 * Your application code goes here
 */

package userclasses;

import generated.StateMachineBase;
import com.codename1.ui.*; 
import com.codename1.ui.events.*;
import com.codename1.ui.util.Resources;
import com.zipato.model.DataModel;
import com.zipato.model.IResponseHandler;
import com.zipato.view.LightsView;
import com.zipato.view.LoginView;
import com.zipato.view.HomeView;
import com.zipato.view.SideMenuView;
import java.util.Map;

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
    
    private static StateMachine INSTANCE;
    public LoginView loginView;
    public HomeView homeView;
    public LightsView lightsView;
    public SideMenuView sideMenuView;
    
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     * @param res
     */
    @Override
    protected void initVars(Resources res) {
        loginView = new LoginView(this);
        homeView = new HomeView(this);
        lightsView = new LightsView(this);
        sideMenuView = new SideMenuView(this);
        
        DataModel.getInstance().init();
    }
    
    public static Resources getResourceFile()
    {
        return INSTANCE.fetchResourceFile();
    }
    
    @Override
    protected void beforeShow(Form f) {
        if (!(f instanceof Dialog))
            sideMenuView.beforeShow(f);
        
        super.beforeShow(f);
    }
    
    @Override
    protected void onScreenLogin_BtnLoginLoginAction(Component c, ActionEvent event) 
    {
        loginView.btnLoginAction(c, event);
    }

    @Override
    protected void beforeScreenNews(Form f) {
        homeView.beforeShow(f);
    }

    @Override
    protected void beforeScreenLogin(Form f) {
        loginView.beforeShow(f);
    }
}
