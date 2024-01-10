package org.pipeai.connectors;

import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ChatGPTV35Client {

    private static String apiUrl;
    private static String apiKey;

    public static void initialize(String url, String key) {
        apiUrl = url;
        apiKey = key;
    }

    public static String sendRequest(String jsonInput) {
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(apiUrl);

        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        post.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);

        try {
            StringEntity entity = new StringEntity(jsonInput);
            post.setEntity(entity);

            return EntityUtils.toString(client.execute(post).getEntity());
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

}
