package utils;

import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UserData {
    private static JSONObject usersJson;

    static{
        try{
            InputStream ls = ClassLoader.getSystemResourceAsStream("testdata/users.json");
            if(ls == null){
                throw new RuntimeException("File users.json is empty");
            }
            String content = new Scanner(ls, StandardCharsets.UTF_8).useDelimiter("\\A").next();
            usersJson = new JSONObject(content);
        }catch (Exception e){
            System.out.println("Error: usersJson" + e.getMessage());
        }
    }

    public static String getUserName(String key){
        return usersJson.getJSONObject(key).getString("user");
    }

    public static String getPassword(String key){
        return usersJson.getJSONObject(key).getString("password");
    }
}
