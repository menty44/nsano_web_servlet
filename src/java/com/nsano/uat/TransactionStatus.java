/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsano.uat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author fred
 */
public class TransactionStatus {

    //private static final String USER_AGENT = null;
    private final String USER_AGENT = "Mozilla/5.0";

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        TransactionStatus http = new TransactionStatus();

        //System.out.println("Testing 1 - Send Http GET request");
        //http.sendGet();
        System.out.println("\nTesting Fusion - Send Http POST request");
        http.sendPost();

    }

    // HTTP POST request
    private void sendPost() throws Exception {

        String url = "http://portals.nsano.com:9000/api/fusion_dev/thirdParty/IMT/";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "tag=checkTransactionStatus&"
                + "apikey=d7dd4c4982494701a8491c5180fe2bea&"
                + "refID=IMPALA1422167935";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String menty = response.toString();
        System.out.println("");
        System.out.println("Response :" + menty);
        System.out.println("");
        JSONParser parser = new JSONParser();
        try {
//				System.out.println("Reading JSON file from Java program");
//				//FileReader fileReader = new FileReader(file); 
//				JSONObject json = (JSONObject) parser.parse(menty);
//				JSONObject json2 = (JSONObject) parser.parse("data");
//				System.out.println(String.format("data => %s", json2.toString()));
//				
//				String code = (String) json.get("code"); 
//				String msg = (String) json.get("msg");
//				
//				 String inst_trans_id = json2.getString("inst_trans_id");
//				
//				
//				//String data = (String) json.get("data");
//				//long price = (long) json.get("price"); 
//				System.out.println("code: " + code); 
//				System.out.println("msg: " + msg);
//				System.out.println("inst_trans_id: " + inst_trans_id);
//				//System.out.println("price: " + price); 
//				JSONArray characters = (JSONArray) json.get("characters");
////				java.util.Iterator i = characters.iterator(); 
////				System.out.println("characters: "); 
////				while (i.hasNext()) {
////					System.out.println(" " + i.next()); 
////					} 

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
