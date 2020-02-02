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

public class CountriesReader {
    //declaring a field that stores the file passed in main
    ArrayList<String[]> allAttributes;
    //declaring a field that stores the file passed in main
    Map<String, ArrayList<String>> countriesMap = new HashMap<String, ArrayList<String>>();

    /**
     * The constructor uses CSVReader to store an arraylist of string arrays in the Suspects field
     *
     * @param file takes a string with the name of the file
     */
    public CountriesReader(InputStream file) {
        System.out.println("Started processing..");
        //declaring a header-aware reader and intializing it to null
        BufferedReader reader = new BufferedReader( new InputStreamReader(
                file, Charset.forName("UTF-8") ) );
        //reading the file and catching possible exceptions
        String line = "";
        String tempCountry = "";
        ArrayList<String> tempOrganizations = new ArrayList<String>();

        try {
            while ((line=reader.readLine())!=null){
                //String[]tokens = line.split(",");
                char[] charArray = line.toCharArray();
                if (charArray.length == 0) { //empty line, ignore it

                }
                else {
                    char c1 = charArray[0];
                    if (c1 == '=') { //if it's a country
                        ArrayList<String> temp = new ArrayList<String>( tempOrganizations );
                        countriesMap.put( tempCountry, temp );
//                        System.out.println( tempCountry + " has been added successfully with the following values:" );
//                        if (countriesMap.containsKey( "====Bolivia====" )){
//                            System.out.println( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" );
//                            System.out.println( countriesMap.get( "====Bolivia====" ).get(0) );
//                        }
//                        for(String country:tempOrganizations) {
//                            System.out.println(country);
//                        }
//                        System.out.println( "Found a country" + line );
                        tempCountry = line;
                        tempOrganizations.clear();

                    } else if (c1 == '{') {
//                        System.out.println( "Found a non-useful line" + line );

                    } else {
//                        System.out.println( "Found an organization" + line );
                        tempOrganizations.add(line);
                    }
                }


            }
            countriesMap.put( tempCountry, tempOrganizations );


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
//            countriesMap.put(allAttributes.get(j)[1], attributes);
//            System.out.print(j);  //(TroubleShooting Line)
//            //System.out.println(newSuspect.toString());  (TroubleShooting Line)
//        }
    }
}

