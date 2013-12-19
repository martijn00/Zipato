/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipato.model;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.io.Util;
import com.codename1.ui.Display;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Martijn
 */
public class ServerConnector {
    private static final ServerConnector INSTANCE = new ServerConnector();
    private static String baseUrl = "https://my.zipato.com/zipato-web/rest/";
    
    public static ServerConnector getInstance() {
        return INSTANCE;
    }
    
    public void get(String uri, Map params, IResponseHandler responseHandler)
    {
        connect(uri, params, false, responseHandler);
    }
    
    public void post(String uri, Map params, IResponseHandler responseHandler)
    {
        connect(uri, params, true, responseHandler);
    }
    
    public void put(String uri, Map params, IResponseHandler responseHandler)
    {
        connect(uri, params, true, responseHandler);
    }
    
    public void connect(String url, Map params, Boolean isPost, final IResponseHandler responseHandler)
    {
//        ConnectionRequest request = new BodyContentRequest("50")
        ConnectionRequest request = new ConnectionRequest()
        {
            @Override
            protected void readResponse(InputStream input) throws IOException {
                String sResponse = Util.readToString(input);
                JSONParser parser = new JSONParser();
                CharArrayReader charArrayReader = new CharArrayReader(sResponse.toCharArray());
                final Map data = parser.parse(charArrayReader);
                
                Display.getInstance().callSerially(new Runnable() {
                    public void run() {
                        responseHandler.onSucces(data);
                    }
                });
            };
            
           
        };
        
        request.setPost(isPost);
        
        if (params != null) 
        {
            Iterator entries = params.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                request.addArgument(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        
        request.setUrl(baseUrl + url);
        request.setContentType("application/json");
        NetworkManager.getInstance().addToQueue(request);
        
        System.out.println(request.getUrl());
    }
    
//    private class BodyContentRequest extends ConnectionRequest
//    {
//        private String data;
//        
//        BodyContentRequest(String data){
//            this.data = data;
//        };
//         
//         protected void buildRequestBody(OutputStream os)throws IOException {
//            OutputStreamWriter w = new OutputStreamWriter(os, "UTF-8");
//            w.write(data);
//        };
//    }
}