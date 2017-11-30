package com.epam.lab.editText;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class EditFile {
    private static final Logger log = Logger.getLogger(LinkedList.class);
    public static void main(String[] args) {
        log.info("Write the path to your file: ");
        Scanner in =new Scanner(System.in);//file.txt
        File path = new File(in.nextLine());
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                line =line.replaceAll("_{1,}", " ")
                        .replaceAll("\\*{1,}"," ")
                        .replaceAll("  {1,}"," ");
                Pattern p2 = Pattern.compile("[0-9].");//cant made it to work with "\\s" .[0-9] instead
                Matcher m2 = p2.matcher(line);
                while (m2.find()) {
                        line = line.replaceAll(m2.group(), m2.group().toUpperCase());
                }
                System.out.println(line.replaceAll("\\d",""));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("File could not read!");
        }
    }
}


