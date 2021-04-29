package ch.obvita.jnatural.test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

public class MySqlDriverExample {

    public static void main(String[] args){


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name","Ueli");
        jsonObj.put("character", new JSONObject());
        jsonObj.getJSONObject("character").put("nettigkeit",0);
        jsonObj.getJSONObject("character").put("launen",new JSONArray());
        jsonObj.getJSONObject("character").getJSONArray("launen").put(2);
        jsonObj.getJSONObject("character").getJSONArray("launen").put(3);
        jsonObj.getJSONObject("character").getJSONArray("launen").put(5);

        System.out.println(jsonObj.toString());




        JSONObject js2 = new JSONObject(jsonObj.toString());


        System.out.println(js2);

    }


}
