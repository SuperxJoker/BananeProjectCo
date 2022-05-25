package Services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class LocalBase {

    public static void addToJson(String procesor,String algoritm, String time, String score){

        JSONObject obj = new JSONObject();
        JSONArray arrayClient = new JSONArray();
        JSONParser jp = new JSONParser();
        Object p;
        try {
            FileReader readFile = new FileReader("src/main/resources/date.json");
            BufferedReader read = new BufferedReader(readFile);
            p = jp.parse(read);
            if (p instanceof JSONArray) {
                arrayClient = (JSONArray) p;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONArray array= new JSONArray();
        obj.put("Procesor:", procesor);
        obj.put("Algoritm:", algoritm);
        obj.put("Time:", time);
        obj.put("Score:",score);

        arrayClient.add(obj);
        try {
            File file = new File("src/main/resources/date.json");
            FileWriter fisier = new FileWriter(file.getAbsoluteFile());
            fisier.write(arrayClient.toJSONString());
            fisier.flush();
            fisier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
