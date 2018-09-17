package com.zacha.galleryapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FlickrPhotos{
    private String apiKey;
    private String format;

    public FlickrPhotos(String apiKey, String format){
        this.apiKey = apiKey;
        this.format = format;
    }

    public List<FlickrPhoto> getPhotos() throws IOException, JSONException {
        String url = "https://api.flickr.com/services/rest/?api_key=949e98778755d1982f537d56236bbb42&tags=Cool&method=flickr.photos.search";
        URL obj = new URL(url);

        HttpURLConnection  connection = (HttpURLConnection) obj.openConnection();
        int responseCode = connection.getResponseCode();
        //System.out.println("\nSending 'GET' request to URL : " + url);
        //System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);

        }
        in.close();
        JSONObject jsonObj = XML.toJSONObject(response.toString());
        JSONArray jsonArray = jsonObj.getJSONObject("rsp").getJSONObject("photos").getJSONArray("photo");

        JSONObject jsonObject;
        URL photoURL;
        String title;
        ArrayList<FlickrPhoto> photos = new ArrayList<>();
        for(int i = 0 ; i < jsonArray.length() ; i++){
            jsonObject =  jsonArray.getJSONObject(i);
            title = jsonObject.get("title").toString();
            photoURL = new URL("https://api.flickr.com/services/rest/?api_key=949e98778755d1982f537d56236bbb42&photo_id=" + jsonObject.get("id").toString() +
                    "&farm=" +jsonObject.get("farm").toString() + "&server=" + jsonObject.get("server") + " &method=flickr.photos.getSizes");

            photos.add(new FlickrPhoto(photoURL, title));
        }

        return photos;
    }

    public URL getSmallPhoto(URL url) throws IOException, JSONException {
        HttpURLConnection  connection = (HttpURLConnection) url.openConnection();
        int responseCode = connection.getResponseCode();
       // System.out.println("\nSending 'GET' request to URL : " + url);
        //System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);

        }
        in.close();
        JSONObject jsonObj = XML.toJSONObject(response.toString());
        //System.out.println(jsonObj);
        JSONObject jsonObject = jsonObj.getJSONObject("rsp").getJSONObject("sizes").getJSONArray("size").getJSONObject(3);
        //System.out.println(jsonObject);
        String source = jsonObject.getString("source");
        //System.out.println(source);
        return new URL(source.toString());
    }
}
