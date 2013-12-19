/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zipato.controller;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

/**
 *
 * @author mvandijk
 */
public class User {
    
    public static String getToken(String password, String nonce)
    {
        return getSHA1(nonce + getSHA1(password));
    }
    
    public static String getSHA1(String value)
    {
        Digest  digest = new SHA1Digest();
        HMac hmac = new HMac(digest);
        
        hmac.update(value.getBytes(), 0, value.getBytes().length);
        byte[]  resBuf = new byte[digest.getDigestSize()];
        hmac.doFinal(resBuf, 0);
        
        return new String(Hex.encode(resBuf));
    }
}
