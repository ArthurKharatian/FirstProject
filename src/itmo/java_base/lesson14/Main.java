package itmo.java_base.lesson14;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        String url = makeUrl();
        StringBuilder builder = pars(url);

        Object object = new JsonParser().parse(String.valueOf(builder));
        JsonObject response = (JsonObject) object;

        JsonObject server = (JsonObject) (response.get("query"));
        JsonArray searchList = server.getAsJsonArray("search");

        for (JsonElement jsonElement : searchList) {
            JsonObject jsonObject = (JsonObject) jsonElement;
            System.out.println(jsonObject.get("title"));
            String s = jsonObject.get("snippet").toString()
                    .replace("<span class=\\\"searchmatch\\\">", "")
                    .replace("</span>", "");

            System.out.println(new StringBuilder(s).insert(75, "\n"));
            System.out.println();
        }
    }

    public static String makeUrl() {
        String baseURL = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, enter the query: ");
        String query;
        String encodeURL = null;
        try {
            query = reader.readLine();
            encodeURL = URLEncoder.encode(query, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseURL + encodeURL;
    }

    public static StringBuilder pars(String inputUrl) {
        URL url;
        StringBuilder builder = new StringBuilder();
        try {
            url = new URL(inputUrl);
            URLConnection connection = url.openConnection();
            String line;
            InputStream inputStream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder;
    }
}
