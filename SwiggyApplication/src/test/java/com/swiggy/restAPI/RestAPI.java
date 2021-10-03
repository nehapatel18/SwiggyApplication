package com.swiggy.restAPI;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestAPI {
    public static String getRequest(String _url) throws Throwable{
        URL url =new URL(_url);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("user-Agent","PostmanRuntime/7.28.4");
        int responsecode=connection.getResponseCode();
        System.out.println(responsecode);

        InputStream inStream=connection.getInputStream();
        InputStreamReader streamReader=new InputStreamReader(inStream);
        BufferedReader br=new BufferedReader(streamReader);

        //System.out.println(br.readLine());
        return br.readLine();

    }
    public static String postRequest(String _url,String _payload) throws Throwable{
        URL url =new URL(_url);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("user-Agent","Java code");
        connection.setDoOutput(true);
        OutputStream outputStream=connection.getOutputStream();
        outputStream.write(_payload.getBytes());
        outputStream.flush();

        int responsecode=connection.getResponseCode();
        System.out.println(responsecode);

        InputStream inStream=connection.getInputStream();
        InputStreamReader streamReader=new InputStreamReader(inStream);
        BufferedReader br=new BufferedReader(streamReader);

        //System.out.println(br.readLine());
        return br.readLine();

    }
    public static void main(String[] args) throws  Throwable {
        String payload="{" +
                "    \"name\": \"{{name}}\"," +
                "    \"job\": \"{{job}}\"" +
                "}";


        System.out.println(getRequest("https://www.swiggy.com/dapi/restaurants/search/v2_2?lat=21.1702401&lng=72.83106070000001&trackingId=0ad2243c-3348-5982-47ec-353fdbd686c0&str=La%20Pino%27z%20Pizza&sld=false&non_partner_search=false&submitAction=SUGGESTION&metadata=%7B%22type%22%3A%22routingV1_deepLinkRestaurant_V1%22%2C%22data%22%3A%7B%22parentId%22%3A4961%2C%22primaryRestaurantId%22%3A66217%2C%22cloudinaryId%22%3A%22mu43yls5ndup2fk2zomy%22%2C%22brandId%22%3A4961%2C%22dishFamilyId%22%3A%22846647%22%2C%22routeToSimilarRestaurants%22%3Atrue%7D%7D"));


     System.out.println(postRequest("https://reqres.in/api/users",""));
    }
}
