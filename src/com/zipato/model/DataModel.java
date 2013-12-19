/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zipato.model;

import java.util.Map;

/**
 *
 * @author mvandijk
 */
public class DataModel {
    private static DataModel INSTANCE = new DataModel();
    public static String nonce;
    
    public static DataModel getInstance() {
        return INSTANCE;
    }
    
    public void init()
    {
        ServerConnector.getInstance().get("user/init", null, new IResponseHandler() {
            public void onSucces(Map data) {
                nonce = (String)data.get("nonce");
            }
            public void onFailure(int code, String message) {
                
            }
        });
    }
    
    public void getLogin(Map params, IResponseHandler responseHandler)
    {
        ServerConnector.getInstance().get("user/login", params, responseHandler);
    }
    
    public void putLight(Map params, IResponseHandler responseHandler)
    {
        //ServerConnector.getInstance().post("values/a17a13d2-3fa8-44b4-a73d-7835f948eff2/8", params, responseHandler);
        ServerConnector.getInstance().put("lights/a17a13d2-3fa8-44b4-a73d-7835f948eff2/attributes/8/value", params, responseHandler);
    }
}
