package com.epam.lab.ShowComments;
import org.apache.log4j.Logger;
import java.io.*;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comments {
    private static final Logger log = Logger.getLogger(LinkedList.class);

    public static void main(String[] args) throws IOException {
        log.info("Write the path to your file: ");
        Scanner in =new Scanner(System.in);//FileWithComments.txt //Lol.java
        File path = new File(in.nextLine());
        removeComments(path);
    }

    static void removeComments(File file ) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line, line2;
            while ((line = br.readLine()) != null) {
                Pattern pat = Pattern.compile("//.+?$");
                Matcher match = pat.matcher(line);
               if (match.find()) {
                    Pattern pat4 = Pattern.compile("\"//\".+?$" );
                    Matcher match4 = pat4.matcher(line);
                    if (match4.find())
                        continue;
                    else {
                        line2 = match.group();
                        log.info(line2.replaceAll("//", ""));
                        continue;
                    }
                }
                Pattern pat2 = Pattern.compile("/\\**.+?$");
                Matcher match2 = pat2.matcher(line);
                if (match2.find()) {
                    log.info(line.replaceAll("/\\**", ""));
                    while ((line = br.readLine()) != null) {
                        if (line.endsWith("*/")) {
                            log.info(line.replaceAll("\\**/", ""));
                            break;
                        }
                        log.info(line);
                    }
                }
                Pattern pat3 = Pattern.compile("/\\*\\*.+?$");
                Matcher match3 = pat3.matcher(line);
                if (match3.find()) {
                    log.info(line.replaceAll("/\\*\\*", ""));
                    while ((line = br.readLine()) != null) {
                        if (line.endsWith("*/")) {
                            log.info(line.replaceAll("\\**/", ""));
                            break;
                        }
                        log.info(line.replaceAll("\\*", ""));
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("OOPS! File could not read!");
        }
    }
}

