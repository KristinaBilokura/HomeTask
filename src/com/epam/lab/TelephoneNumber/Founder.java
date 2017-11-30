package com.epam.lab.TelephoneNumber;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Founder {
    private static final Logger log = Logger.getLogger(LinkedList.class);

    public static void main(String[] args) throws Exception {
        File path = new File("number.txt");
        findNumber(path);
        DAO.getConnection();
    }

    private static void findNumber(File path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                Pattern p = Pattern.compile("\\+300+?");
                Matcher m = p.matcher(line);
                if (m.find()) {
                    System.out.println(line);
                }
            }
            br.close();
        }catch (Exception e) {
            System.out.println("OOPS! File could not read!");
        }

    }
}
