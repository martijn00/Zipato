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
    private static final DataModel INSTANCE = new DataModel();
    
    public static DataModel getInstance() {
        return INSTANCE;
    }
    
    public void init(IResponseHandler responseHandler)
    {
        ServerConnector.getInstance().connect("user/init", null, false, responseHandler);
    }
    
    public void getLogin(Map params, IResponseHandler responseHandler)
    {
        ServerConnector.getInstance().connect("user/login?username=" + params.get("username") + "&token=" + params.get("token"), params, false, responseHandler);
    }
}
