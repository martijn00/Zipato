/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipato.model;

import java.util.Map;

/**
 *
 * @author simon
 */
public interface IResponseHandler {

    public void onSucces(Map data);
    public void onFailure(int code, String message);
}
