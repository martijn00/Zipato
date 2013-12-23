/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zipato.model;

import com.zipato.controller.User;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mvandijk
 */
public class DataModel {
    private static DataModel INSTANCE = new DataModel();
    public static String nonce;
    public static String jsessionid;
    
    public static DataModel getInstance() {
        return INSTANCE;
    }
    
    public void init()
    {
        ServerConnector.getInstance().get("user/init", null, new IResponseHandler() {
            public void onSucces(Map data) {
                nonce = (String)data.get("nonce");
                jsessionid = (String)data.get("jsessionid");
                
                System.out.println("Nonce: " + nonce);
                System.out.println("Jsessionid: " + jsessionid);
            }
            public void onFailure(int code, String message) {
                
            }
        });
    }
    
    public void getLogin(String username, String password, IResponseHandler responseHandler)
    {
        Map params = new HashMap();
        params.put("username", username);
        params.put("token", User.getToken(password, nonce));
        
        ServerConnector.getInstance().get("user/login", params, responseHandler);
    }
    
    public void getLogout(IResponseHandler responseHandler)
    {
        ServerConnector.getInstance().get("user/logout", null, responseHandler);
    }
    
    public void getLights(IResponseHandler responseHandler)
    {
        ServerConnector.getInstance().get("lights/", null, responseHandler);
    }
    
    public void putLight(String uuid, int value, IResponseHandler responseHandler)
    {
        Map params = new HashMap();
        params.put("bodyContent", value);
        
        ServerConnector.getInstance().put("lights/" + uuid + "/attributes/8/value", params, responseHandler);
    }
}
