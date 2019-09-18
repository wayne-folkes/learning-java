package main.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import sun.jvm.hotspot.utilities.IntArray;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class Hello
{
    public int myInt = 4;
    public final int myConstInt = 5;
    int someNumber;
    int[] myList;

    public Hello(int input_number){
        myInt = 56;
    }

    public Hello(){
        someNumber = 10;
    }

    public static void main(String[] args) {
        Hello myHello = new Hello();
        System.out.println("Hello World Wayne");
        System.out.println(myHello.myInt);
        System.out.println(myHello.someNumber);
        System.out.println(myHello.myConstInt);
        myHello.setInt(45);
        System.out.println(myHello.myInt);
        myHello.myList = myHello.makeList(5);
        myHello.printList(myHello.myList);
        try {
            myHello.getUrls();
        } catch (Exception e) {
            System.err.println("An error occurred"+e);
        }

    }

    public void setInt(int value){
        this.myInt = value;
    }

    public void printList(int[] intList){
        for (int i =0;i < intList.length;i++){
            System.out.println(intList[i]);
        }
    }

    public int[] makeList(int len){
        int[] intList;
        intList = new int[len];
        for (int i =0; i < len; i++){
            //System.out.println(i);
            intList[i] = i * 2;
        }
        return intList;
    }

    public void getUrls() throws Exception {
        String[] urlsToGet = {"http://www.shutterstock.com", "https://www.meetup.com","https://www.google.com"};
        for (String urlToGet : urlsToGet) {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlToGet);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setInstanceFollowRedirects(true);
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
               result.append(line);
            }
            rd.close();
            String responseMessage = conn.getResponseMessage();
            int content_length = conn.getContentLength();
            int responseCode = conn.getResponseCode();
            System.out.println("Checking: " + urlToGet);
            System.out.println("It has a length of " + content_length);
            System.out.println("It has a response code of " + responseCode);
            System.out.println("It has a response message of " + responseMessage);
            conn.disconnect();
        }
    }

    public void parseSomeJSON() throws FileNotFoundException {
        String path = "/Users/wfolkes/dev/learning-java/src/main/java/test.json"
    }
}