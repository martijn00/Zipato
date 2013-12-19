/**
 * Your application code goes here
 */

package userclasses;

import generated.StateMachineBase;
import com.codename1.ui.*; 
import com.codename1.ui.events.*;
import com.codename1.ui.util.Resources;
import com.zipato.controller.User;
import com.zipato.model.DataModel;
import com.zipato.model.IResponseHandler;
import java.util.HashMap;
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
    
    private String nonce;
    
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    protected void initVars(Resources res) {
        DataModel.getInstance().init(new IResponseHandler() {
            public void onSucces(Map data) {
                nonce = (String)data.get("nonce");
            }

            public void onFailure(int code, String message) {
                
            }
        });
    }

    @Override
    protected void onScreenLogin_BtnLoginLoginAction(Component c, ActionEvent event) 
    {
        Map loginParams = new HashMap();
        loginParams.put("username", findTfdLoginUsername().getText());
        loginParams.put("token", User.getToken(findTfdLoginPassword().getText(), nonce));
        
        DataModel.getInstance().getLogin(loginParams, new IResponseHandler() {
            public void onSucces(Map data) {
                if(data.get("success").equals("true"))
                {
                    //showForm("ScreenNews", null);
                    Map lightParams = new HashMap();
                    //lightParams.put("uuid", "a17a13d2-3fa8-44b4-a73d-7835f948eff2");
                    //lightParams.put("attribute", "8");
                    lightParams.put("", "50");
                    
                    DataModel.getInstance().putLight(lightParams, new IResponseHandler() {

                        public void onSucces(Map data) {
                            System.out.println("set light: " + data.get("success").toString());
                        }

                        public void onFailure(int code, String message) {
                            
                        }
                    });
                }
            }

            public void onFailure(int code, String message) {
                System.out.println("fail");
            }
        });
    }
}
