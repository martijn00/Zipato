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
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
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
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
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

    public com.codename1.ui.Button findButton(Component root) {
        return (com.codename1.ui.Button)findByName("Button", root);
    }

    public com.codename1.ui.Button findButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField1(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField1", root);
    }

    public com.codename1.ui.TextField findTextField1() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField", root);
    }

    public com.codename1.ui.TextField findTextField() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField", aboutToShowThisContainer);
        }
        return cmp;
    }

    protected void exitForm(Form f) {
        if("ScreenLogin".equals(f.getName())) {
            exitScreenLogin(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void exitScreenLogin(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("ScreenLogin".equals(f.getName())) {
            beforeScreenLogin(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeScreenLogin(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        aboutToShowThisContainer = c;
        if("ScreenLogin".equals(c.getName())) {
            beforeContainerScreenLogin(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeContainerScreenLogin(Container c) {
    }

    protected void postShow(Form f) {
        if("ScreenLogin".equals(f.getName())) {
            postScreenLogin(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postScreenLogin(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("ScreenLogin".equals(c.getName())) {
            postContainerScreenLogin(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postContainerScreenLogin(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("ScreenLogin".equals(rootName)) {
            onCreateScreenLogin();
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void onCreateScreenLogin() {
    }

    protected Hashtable getFormState(Form f) {
        Hashtable h = super.getFormState(f);
        if("ScreenLogin".equals(f.getName())) {
            getStateScreenLogin(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

            return h;
    }


    protected void getStateScreenLogin(Form f, Hashtable h) {
    }

    protected void setFormState(Form f, Hashtable state) {
        super.setFormState(f, state);
        if("ScreenLogin".equals(f.getName())) {
            setStateScreenLogin(f, state);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void setStateScreenLogin(Form f, Hashtable state) {
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
        if(rootContainerName.equals("ScreenLogin")) {
            if("TextField".equals(c.getName())) {
                onScreenLogin_TextFieldAction(c, event);
                return;
            }
            if("TextField1".equals(c.getName())) {
                onScreenLogin_TextField1Action(c, event);
                return;
            }
            if("Button".equals(c.getName())) {
                onScreenLogin_ButtonAction(c, event);
                return;
            }
        }
    }

      protected void onScreenLogin_TextFieldAction(Component c, ActionEvent event) {
      }

      protected void onScreenLogin_TextField1Action(Component c, ActionEvent event) {
      }

      protected void onScreenLogin_ButtonAction(Component c, ActionEvent event) {
      }

}
