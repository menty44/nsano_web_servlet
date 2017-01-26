/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsano.uat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import static javafx.css.StyleOrigin.USER_AGENT;

/**
 *
 * @author fred
 */
public class credit {
    
    public String sendPOST() throws IOException{
       String url = "http://portals.nsano.com:9000/api/fusion_dev/thirdParty/IMT/";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        //con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "tag=3rdpartycredit&"
                + "apikey=d7dd4c4982494701a8491c5180fe2bea&"
                + "refID=cccccsTRANS12m345678&"
                + "sender=PeterAlexandre&"
                + "sender_country=GH&"
                + "receiver=KofiSarpong&"
                + "receiver_msisdn=233276819324&"
                + "receiver_country=GH&"
                + "amount=0.80&"
                + "mno=TIGO";

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

        //print result
        System.out.println(response.toString());

//			JSONParser parser = new JSONParser();
//
//	        try {
//
//	            Object obje = parser.parse(new Response<T>() {
//				});
//
//	            JSONObject jsonObject = (JSONObject) obje;
//	            System.out.println(jsonObject);
//
//	            String name = (String) jsonObject.get("name");
//	            System.out.println(name);
//
//	            long age = (Long) jsonObject.get("age");
//	            System.out.println(age);
//
//	            // loop array
//	            JSONArray msg = (JSONArray) jsonObject.get("messages");
//	            Iterator<String> iterator = msg.iterator();
//	            while (iterator.hasNext()) {
//	                System.out.println(iterator.next());
//	            }
//
//	        } catch (FileNotFoundException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        } catch (ParseException e) {
//	            e.printStackTrace();
//	        } 
        return response.toString();
    }
    
    
    
    
}
