package me.Corvus;

/**
 * Created by soulb on 1/5/2016.
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sun.security.krb5.internal.crypto.Des;

public class CardFinder {


    @SuppressWarnings("unchecked")
    public String GetInfo(String cardName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\soulb\\IdeaProjects\\ChatBot\\cards.json"));

        ArrayList<String> infoArray = new ArrayList<String>();
        for (Object o : a)
        {
            JSONObject person = (JSONObject) o;
            String name = "";
            String text = "";
            String health = "";
            String attack = "";
            String cost = "";
            String flavor = "";
            if(person.get("name") != null){
                name = person.get("name").toString();
            }
            if(person.get("text") != null){
                text = person.get("text").toString().replaceAll("(<b>|</b>)", "**").replaceAll("(<i>|</i>)","*").replaceAll("\\$", "");
            }
            if(person.get("health") != null){
                health = person.get("health").toString();
            }
            if(person.get("attack") != null){
                attack = person.get("attack").toString();
            }
            if(person.get("cost") != null){
                cost = person.get("cost").toString();
            }
            if(person.get("flavor") != null){
                flavor = person.get("flavor").toString().replaceAll("(<i>|</i>)", "*");
            }

            if(cardName.toLowerCase().contains("["+name.toLowerCase()+"]")) {
                if(!name.isEmpty()) {
                    infoArray.add("Name: " + name + "\n");
                }
                if(!attack.isEmpty()){
                    infoArray.add("Attack: " + attack + "\n");
                }
                if(!health.isEmpty()){
                    infoArray.add("Health: " + health + "\n");
                }
                if(!text.isEmpty()){
                    infoArray.add("Text: " + text + "\n");
                }
                if(!cost.isEmpty()){
                    infoArray.add("Cost: " + cost + "\n");
                }
                if(!flavor.isEmpty()){
                    infoArray.add(flavor + "\n");
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : infoArray)
        {
            sb.append(s);
            sb.append("\t");
        }

    return sb.toString();
    }

}
