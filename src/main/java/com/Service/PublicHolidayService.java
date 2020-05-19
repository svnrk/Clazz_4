package com.Service;

import com.Utils.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class PublicHolidayService {
    private static final String COUNTRY_CODE = "EE";
    private String API_URL;

    public PublicHolidayService(){
        this.API_URL = "https://date.nager.at/api/v2/PublicHolidays/";
    }

    public PublicHolidayService(String url){
        this.API_URL = url;
    }

    public List<ZonedDateTime> getPublicHolidays(String year){
        return getPublicHolidays(year, API_URL);
    }

    public List<ZonedDateTime> getPublicHolidays(String year, String API_URL) {
        List<ZonedDateTime> holidays = new ArrayList<>();
        String composedUrl = API_URL + year + "/" + COUNTRY_CODE;

        try {
            URL url = new URL(composedUrl);
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                JSONArray array = new JSONArray(inputLine);

                for (Object obj : array) {
                    JSONObject object = (JSONObject) obj;
                    if (object.has("date")) {
                        String dateString = object.getString("date");
                        ZonedDateTime holiday = DateConverter.dateStringToZDTSpecial(dateString, "yyyy-MM-dd");

                        holidays.add(holiday);
                    }

                }
            }

        }
        catch (IOException | JSONException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }

        return holidays;
    }

}
