/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsano.uat;

/**
 *
 * @author mulikevs
 */
//public class  {
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
//import com.impala.balance.AMBalance;
import com.nsano.uat.credit;
import java.security.NoSuchAlgorithmException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Oluoch
 *
 */
@WebServlet(name = "Status", urlPatterns = {"/Status"})
public class StatusServlet extends HttpServlet {

    TransactionStatus status = new TransactionStatus();
    //private Payment2 remittoairtel;

    private String statuscode = "00032";

    private String Statusdescription = "INTERNAL_SERVER_ERROR";

    private String CLIENT_URL = "";

    /**
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException , IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OutputStream out = response.getOutputStream();

        response.setContentType("text/plain;charset=UTF-8");
        response.setDateHeader("Expires", new Date().getTime()); // Expiration
        // date
        response.setDateHeader("Date", new Date().getTime()); // Date and time
        try {
            // that the
            // message was
            // sent
            out.write(moneytransfer(request).getBytes());
        } catch (JSONException ex) {
            Logger.getLogger(IMTCredit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Imtservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.flush();
        out.close();
    }

    /**
     *
     * @param request
     * @return
     * @throws IOException
     */
    private String moneytransfer(HttpServletRequest request) throws IOException, JSONException, NoSuchAlgorithmException {

        // joined json string
        String join = "";
        JsonElement root = null;
        JsonElement root2 = null;
        JsonElement root3 = null;

        String responseobject = "";

        //String nickname="KENDYIPL";
        // These represent parameters received over the network
        String tag = "",
                apikey = "",
                refID = "",
                sender = "",
                sender_country = "",
                receiver = "",
                receiver_msisdn = "",
                receiver_country = "",
                amount = "",
                mno = "";

        //referenceid, customermsisdn, nickname,amount, batchref, username, password, narrative
        // Get all parameters, the keys of the parameters are specified
        List<String> lines = IOUtils.readLines(request.getReader());

        // used to format/join incoming JSon string
        join = StringUtils.join(lines.toArray(), "");

        //###############################################################################
        // instantiate the JSon
        //Note
        //The = sign is encoded to \u003d. Hence you need to use disableHtmlEscaping().
        //###############################################################################
        Gson g = new GsonBuilder().disableHtmlEscaping().create();
        //Gson g = new Gson();
        Map<String, String> expected = new HashMap<>();

//        try {
//            // parse the JSon string
//            //referenceid, customermsisdn, nickname,amount, batchref, username, password, narrative
//
//            root = new JsonParser().parse(join);
//
//            tag = root.getAsJsonObject().get("tag").getAsString();
//
//            apikey = root.getAsJsonObject().get("apikey").getAsString();
//            refID = root.getAsJsonObject().get("refID").getAsString();
//
//            sender = root.getAsJsonObject().get("sender").getAsString();
//            sender_country = root.getAsJsonObject().get("sender_country").getAsString();
//
//            receiver = root.getAsJsonObject().get("receiver").getAsString();
//            receiver_msisdn = root.getAsJsonObject().get("receiver_msisdn").getAsString();
//
//            receiver_country = root.getAsJsonObject().get("receiver_country").getAsString();
//            amount = root.getAsJsonObject().get("amount").getAsString();
//
//            mno = root.getAsJsonObject().get("mno").getAsString();
//
//        } catch (Exception e) {
//
//            expected.put("command_status", "COMMANDSTATUS_INVALID_PARAMETERS");
//            String jsonResult = g.toJson(expected);
//            System.out.println(e);
//
//            return jsonResult;
//        }

        // check for the presence of all required parameters
//        if (StringUtils.isBlank(tag)
//                || StringUtils.isBlank(apikey)
//                || StringUtils.isBlank(refID)
//                || StringUtils.isBlank(sender)
//                || StringUtils.isBlank(sender_country)
//                || StringUtils.isBlank(receiver)
//                || StringUtils.isBlank(receiver_msisdn)
//                || StringUtils.isBlank(receiver_country)
//                || StringUtils.isBlank(amount)
//                || StringUtils.isBlank(mno)) {
//
//            //expected.put("username", username);
//            expected.put("status_code", statuscode);
//            expected.put("status_description", Statusdescription);
//            String jsonResult = g.toJson(expected);
//
//            return jsonResult;
//        }

        //assign the remit url from properties.config
        //String processtransaction = airtelbalance.AirtelBalance( nickname, username, password);
        String processtransaction = cred.;
        //capture the switch respoinse.

        System.out.println(processtransaction);

        //pass the returned json string
        JsonElement roots = new JsonParser().parse(processtransaction);
        //JsonElement rootsone = roots.getAsJsonObject();

        //exctract a specific json element from the object(status_code)
        //Double code = roots.getAsJsonObject().get("code").getAsDouble();
        Number code = roots.getAsJsonObject().get("code").getAsNumber();
        String msg = roots.getAsJsonObject().get("msg").getAsString();
        //String data = rootsone.getAsJsonObject().get("error_type").getAsString();

        //add 
        //expected.put("username", username);
        expected.put("code", code.toString());
        expected.put("msg", msg.toString());
        //expected.put("error_type", data.toString());

        String jsonResult = g.toJson(expected);
        
        if (code.toString() == "00") {
            
            System.out.println("success");
            
        }else{
            
            System.out.println("fail");
            
        }

        return jsonResult;

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException , IOException
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
