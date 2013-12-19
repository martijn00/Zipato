/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipato.model;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.io.Util;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Martijn
 */
public class ServerConnector {
    private static String baseUrl = "https://my.zipato.com/zipato-web/rest";
    
    public static void init()
    {
        connect("", false);
    }
    
    public static void connect(String url, Boolean isPost)
    {
        ConnectionRequest r = new ConnectionRequest()
        {
            @Override
            protected void readResponse(InputStream input) throws IOException {
                String sResponse = Util.readToString(input);                
            };
        };
        r.setUrl(baseUrl + url);
        r.setPost(isPost); 
        r.setContentType("application/json");                                    
        NetworkManager.getInstance().addToQueue(r);
    }
}
