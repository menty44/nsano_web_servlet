/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsano.uat;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author fred
 */
public class test {
    
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        //declare and inialize credit class
        credit cred = new credit();
        //call the class and get the method
        cred.sendPOST();
    }
    
}
