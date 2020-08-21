package entrevista.despegar.parse.json.wikipedia;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseWikiPedia {
    public static void main(String[] args) {
        System.out.println("Count = " + getTopicCount("pizza"));
    }


    static int getTopicCount(String topic) {
        String url = "https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=" + topic;
        URL obj = null;
        StringBuffer response = new StringBuffer();

        try {
            obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonObject jsonObject = new JsonParser().parse(response.toString()).getAsJsonObject();
        JsonElement parse = jsonObject.get("parse");
        String text = parse.getAsJsonObject().get("text").toString();

        Pattern pattern = Pattern.compile(topic);
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find())
            count++;

        return count;
    }
}