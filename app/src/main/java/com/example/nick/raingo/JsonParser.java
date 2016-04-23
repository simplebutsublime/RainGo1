package com.example.nick.raingo;

import java.io.*;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nitta_000 on 4/21/2016.
 */
public class JsonParser extends JsonGetter{

    static String[] locationInfo = new String[5];
    static Double tempValue;
    static String tempUnit;
    static String weatherType;
    //static JSONObject json = new JSONObject();
    String locationKey = "";
    final String APIKEY = "ecd4986e664e456f84ccc493ad393b78";
    String location = "";

    JsonParser() {
        for(int i = 0; i<5; i++){
            locationInfo[i] = "";
        }
    }


    //currentConditions gets the temperature and weather type values from the accuweather servers
    //for the city requested by the user
    public void currentConditions(String locationKey) throws JSONException {

        String currentCondUrl = "http://apidev.accuweather.com/currentconditions/v1/" + locationKey + ".json?apikey=" + APIKEY;
        execute(currentCondUrl);
        weatherType = (String) json.get("WeatherText");
        json = json.getJSONObject("Temperature");
        json = json.getJSONObject("Imperial");
        tempValue = (Double) json.get("Value");
        tempUnit = (String) json.get("Unit");

    }

    //locationFinder gets the needed information about the requested city from the AccuWeather servers
    public String locationFinder(String location) {
        //try {
            String shortLocation = whiteSpaceDeleter(location);
            String locationUrl = "http://apidev.accuweather.com/locations/v1/search?q=" + shortLocation + "&apikey=" + APIKEY;
            execute(locationUrl);
            System.out.println("HELLO HERE IS JASON: " + json);
            //locationInfo[0] = (String) json.get("EnglishName");
            //locationInfo[1] = (String) json.get("Key");
            return locationInfo[1];
        //} catch(JSONException e) {
          //  throw new NoSuchElementException("JsonPARSER's fucking JSONException: " + e.getMessage());
        //}
    }

    //This method deletes white space in the location the user entered so the url
    //can work in the java url class
    private static String whiteSpaceDeleter(String location) {
        int startingIndex = 0;
        String shortLocation = "";
        String temp;

        while (location.indexOf(" ") != -1) {
            temp = location.substring(startingIndex, location.indexOf(" "));
            location = location.substring(location.indexOf(" ") + 1, location.length());
            shortLocation = shortLocation + temp;
        }
        shortLocation = shortLocation + location;

        return shortLocation;
    }

}
