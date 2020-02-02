package com.example.hoya;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConsumptionReader {
    //declaring a field that stores the file passed in main
    ArrayList<String[]> allAttributes;
    //declaring a field that stores the file passed in main
    Map<String, String[]> consumptionMap = new HashMap<String, String[]>();

    /**
     * The constructor uses CSVReader to store an arraylist of string arrays in the Suspects field
     *
     * @param file takes a string with the name of the file
     */
    public ConsumptionReader(InputStream file) {
        System.out.println("Started processing..");
        //declaring a header-aware reader and intializing it to null
        BufferedReader reader = new BufferedReader( new InputStreamReader(
                file, Charset.forName("UTF-8") ) );
        //reading the file and catching possible exceptions
        String line = "";
        try {
            while ((line=reader.readLine())!=null){
                String[]tokens = line.split(",");
                String[] attributes = new String[2];
                attributes[0] = tokens[0];
                attributes[1] = tokens[2];
                consumptionMap.put(tokens[1], attributes);

            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            Log.wtf("HOYA","ERROR" + line, e1);
            e1.printStackTrace();
        }


//        try {
//            //storing what has been read and catching exceptions
//            allAttributes = new ArrayList<String[]>(reader.readAll());
//        } catch (IOException e2) {
//            e2.printStackTrace();
//        }
//        try {
//            //catching exceptions that might be raised when closing reader
//            reader.close();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//
//        //the loop iterates over every row in the file and takes the desired attributes from their columns
//        for (int j = 0; j<allAttributes.size(); j++) {
//            String[] attributes = new String[2];
//            attributes[0] = allAttributes.get(j)[0];
//            attributes[1] = allAttributes.get(j)[2];
//            consumptionMap.put(allAttributes.get(j)[1], attributes);
//            System.out.print(j);  //(TroubleShooting Line)
//            //System.out.println(newSuspect.toString());  (TroubleShooting Line)
//        }
    }
}

