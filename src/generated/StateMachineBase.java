/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.ui.*;
import com.codename1.ui.util.*;
import com.codename1.ui.plaf.*;
import java.util.Hashtable;
import com.codename1.ui.events.*;

public abstract class StateMachineBase extends UIBuilder {
    private Container aboutToShowThisContainer;
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    /**
    * @deprecated use the version that accepts a resource as an argument instead
    
**/
    protected void initVars() {}

    protected void initVars(Resources res) {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Slider", com.codename1.ui.Slider.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            initVars(res);
            return showForm(getFirstFormName(), null);
        } else {
            Form f = (Form)createContainer(resPath, getFirstFormName());
            initVars(fetchResourceFile());
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    protected String getFirstFormName() {
        return "ScreenLogin";
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Slider", com.codename1.ui.Slider.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "ScreenLogin");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    public com.codename1.ui.Slider findSldLightControl(Component root) {
        return (com.codename1.ui.Slider)findByName("sldLightControl", root);
    }

    public com.codename1.ui.Slider findSldLightControl() {
        com.codename1.ui.Slider cmp = (com.codename1.ui.Slider)findByName("sldLightControl", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Slider)findByName("sldLightControl", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Slider findSlrNewsLight(Component root) {
        return (com.codename1.ui.Slider)findByName("slrNewsLight", root);
    }

    public com.codename1.ui.Slider findSlrNewsLight() {
        com.codename1.ui.Slider cmp = (com.codename1.ui.Slider)findByName("slrNewsLight", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Slider)findByName("slrNewsLight", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTfdLoginPassword(Component root) {
        return (com.codename1.ui.TextField)findByName("tfdLoginPassword", root);
    }

    public com.codename1.ui.TextField findTfdLoginPassword() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("tfdLoginPassword", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("tfdLoginPassword", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnLightOptions(Component root) {
        return (com.codename1.ui.Button)findByName("btnLightOptions", root);
    }

    public com.codename1.ui.Button findBtnLightOptions() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnLightOptions", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnLightOptions", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTfdLoginUsername(Component root) {
        return (com.codename1.ui.TextField)findByName("tfdLoginUsername", root);
    }

    public com.codename1.ui.TextField findTfdLoginUsername() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("tfdLoginUsername", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("tfdLoginUsername", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnLoginLogin(Component root) {
        return (com.codename1.ui.Button)findByName("btnLoginLogin", root);
    }

    public com.codename1.ui.Button findBtnLoginLogin() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnLoginLogin", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnLoginLogin", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnLightSwitch(Component root) {
        return (com.codename1.ui.Button)findByName("btnLightSwitch", root);
    }

    public com.codename1.ui.Button findBtnLightSwitch() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnLightSwitch", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnLightSwitch", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findViewLight(Component root) {
        return (com.codename1.ui.Container)findByName("ViewLight", root);
    }

    public com.codename1.ui.Container findViewLight() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ViewLight", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ViewLight", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnNewsLight(Component root) {
        return (com.codename1.ui.Button)findByName("btnNewsLight", root);
    }

    public com.codename1.ui.Button findBtnNewsLight() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnNewsLight", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnNewsLight", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel(Component root) {
        return (com.codename1.ui.Label)findByName("Label", root);
    }

    public com.codename1.ui.Label findLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer(Component root) {
        return (com.codename1.ui.Container)findByName("Container", root);
    }

    public com.codename1.ui.Container findContainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblLightName(Component root) {
        return (com.codename1.ui.Label)findByName("lblLightName", root);
    }

    public com.codename1.ui.Label findLblLightName() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblLightName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblLightName", aboutToShowThisContainer);
        }
        return cmp;
    }

    protected void exitForm(Form f) {
        if("ScreenNews".equals(f.getName())) {
            exitScreenNews(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ScreenLogin".equals(f.getName())) {
            exitScreenLogin(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ViewLight".equals(f.getName())) {
            exitViewLight(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ScreenLights".equals(f.getName())) {
            exitScreenLights(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void exitScreenNews(Form f) {
    }


    protected void exitScreenLogin(Form f) {
    }


    protected void exitViewLight(Form f) {
    }


    protected void exitScreenLights(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("ScreenNews".equals(f.getName())) {
            beforeScreenNews(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ScreenLogin".equals(f.getName())) {
            beforeScreenLogin(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ViewLight".equals(f.getName())) {
            beforeViewLight(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ScreenLights".equals(f.getName())) {
            beforeScreenLights(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeScreenNews(Form f) {
    }


    protected void beforeScreenLogin(Form f) {
    }


    protected void beforeViewLight(Form f) {
    }


    protected void beforeScreenLights(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        aboutToShowThisContainer = c;
        if("ScreenNews".equals(c.getName())) {
            beforeContainerScreenNews(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ScreenLogin".equals(c.getName())) {
            beforeContainerScreenLogin(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ViewLight".equals(c.getName())) {
            beforeContainerViewLight(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ScreenLights".equals(c.getName())) {
            beforeContainerScreenLights(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeContainerScreenNews(Container c) {
    }


    protected void beforeContainerScreenLogin(Container c) {
    }


    protected void beforeContainerViewLight(Container c) {
    }


    protected void beforeContainerScreenLights(Container c) {
    }

    protected void postShow(Form f) {
        if("ScreenNews".equals(f.getName())) {
            postScreenNews(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ScreenLogin".equals(f.getName())) {
            postScreenLogin(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ViewLight".equals(f.getName())) {
            postViewLight(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ScreenLights".equals(f.getName())) {
            postScreenLights(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postScreenNews(Form f) {
    }


    protected void postScreenLogin(Form f) {
    }


    protected void postViewLight(Form f) {
    }


    protected void postScreenLights(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("ScreenNews".equals(c.getName())) {
            postContainerScreenNews(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ScreenLogin".equals(c.getName())) {
            postContainerScreenLogin(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ViewLight".equals(c.getName())) {
            postContainerViewLight(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ScreenLights".equals(c.getName())) {
            postContainerScreenLights(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postContainerScreenNews(Container c) {
    }


    protected void postContainerScreenLogin(Container c) {
    }


    protected void postContainerViewLight(Container c) {
    }


    protected void postContainerScreenLights(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("ScreenNews".equals(rootName)) {
            onCreateScreenNews();
            aboutToShowThisContainer = null;
            return;
        }

        if("ScreenLogin".equals(rootName)) {
            onCreateScreenLogin();
            aboutToShowThisContainer = null;
            return;
        }

        if("ViewLight".equals(rootName)) {
            onCreateViewLight();
            aboutToShowThisContainer = null;
            return;
        }

        if("ScreenLights".equals(rootName)) {
            onCreateScreenLights();
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void onCreateScreenNews() {
    }


    protected void onCreateScreenLogin() {
    }


    protected void onCreateViewLight() {
    }


    protected void onCreateScreenLights() {
    }

    protected Hashtable getFormState(Form f) {
        Hashtable h = super.getFormState(f);
        if("ScreenNews".equals(f.getName())) {
            getStateScreenNews(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ScreenLogin".equals(f.getName())) {
            getStateScreenLogin(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ViewLight".equals(f.getName())) {
            getStateViewLight(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ScreenLights".equals(f.getName())) {
            getStateScreenLights(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

            return h;
    }


    protected void getStateScreenNews(Form f, Hashtable h) {
    }


    protected void getStateScreenLogin(Form f, Hashtable h) {
    }


    protected void getStateViewLight(Form f, Hashtable h) {
    }


    protected void getStateScreenLights(Form f, Hashtable h) {
    }

    protected void setFormState(Form f, Hashtable state) {
        super.setFormState(f, state);
        if("ScreenNews".equals(f.getName())) {
            setStateScreenNews(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ScreenLogin".equals(f.getName())) {
            setStateScreenLogin(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ViewLight".equals(f.getName())) {
            setStateViewLight(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ScreenLights".equals(f.getName())) {
            setStateScreenLights(f, state);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void setStateScreenNews(Form f, Hashtable state) {
    }


    protected void setStateScreenLogin(Form f, Hashtable state) {
    }


    protected void setStateViewLight(Form f, Hashtable state) {
    }


    protected void setStateScreenLights(Form f, Hashtable state) {
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        Container leadParentContainer = c.getParent().getLeadParent();
        if(leadParentContainer != null && leadParentContainer.getClass() != Container.class) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("ScreenNews")) {
            if("btnNewsLight".equals(c.getName())) {
                onScreenNews_BtnNewsLightAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("ScreenLogin")) {
            if("tfdLoginUsername".equals(c.getName())) {
                onScreenLogin_TfdLoginUsernameAction(c, event);
                return;
            }
            if("tfdLoginPassword".equals(c.getName())) {
                onScreenLogin_TfdLoginPasswordAction(c, event);
                return;
            }
            if("btnLoginLogin".equals(c.getName())) {
                onScreenLogin_BtnLoginLoginAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("ViewLight")) {
            if("btnLightSwitch".equals(c.getName())) {
                onViewLight_BtnLightSwitchAction(c, event);
                return;
            }
            if("btnLightOptions".equals(c.getName())) {
                onViewLight_BtnLightOptionsAction(c, event);
                return;
            }
        }
    }

      protected void onScreenNews_BtnNewsLightAction(Component c, ActionEvent event) {
      }

      protected void onScreenLogin_TfdLoginUsernameAction(Component c, ActionEvent event) {
      }

      protected void onScreenLogin_TfdLoginPasswordAction(Component c, ActionEvent event) {
      }

      protected void onScreenLogin_BtnLoginLoginAction(Component c, ActionEvent event) {
      }

      protected void onViewLight_BtnLightSwitchAction(Component c, ActionEvent event) {
      }

      protected void onViewLight_BtnLightOptionsAction(Component c, ActionEvent event) {
      }

}
