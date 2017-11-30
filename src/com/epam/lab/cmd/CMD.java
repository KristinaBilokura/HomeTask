package com.epam.lab.cmd;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.Scanner;

public class CMD {
    private static final Logger log = Logger.getLogger(LinkedList.class);
    public static void main(String[] args) throws IOException {
        log.info("Enter the directory or path to it -");
        Scanner in =new Scanner(System.in);
        String dir = in.nextLine();
        try {
            File f = new File(dir);
            showAttributes(f);
            File[] files = f.listFiles();
            for(int i= 0;i< files.length; i++) {
                log.info("\t" + files[i].getName());
                showPermissions(files[i]);
                changePermission(files[i]);
                showAttributes(files[i]);

            }
        }catch (IOException e){
            log.info(e.getMessage()+" Something wrong with directory");
        }

    }
    public static void showAttributes (File file) throws IOException {
        Path p = file.toPath();
        String probeContentType1 = Files.probeContentType(p);
        BasicFileAttributes basicFileAttributes = Files.readAttributes(p, BasicFileAttributes.class);
        log.info("\t\tcreationTime: " + basicFileAttributes.creationTime());
        log.info("\t\tlastAccessTime: " + basicFileAttributes.lastAccessTime());
        log.info("\t\tlastModifiedTime: " + basicFileAttributes.lastModifiedTime());
        log.info("\t\tisDirectory: " + basicFileAttributes.isDirectory());
        log.info("\t\tisOther: " + basicFileAttributes.isOther());
        log.info("\t\tisRegularFile: " + basicFileAttributes.isRegularFile());
        log.info("\t\tisSymbolicLink: " + basicFileAttributes.isSymbolicLink());
        log.info("\t\tsize: " + basicFileAttributes.size());

    }
    public static void changePermission(File file){
        log.info("If you wonna change writable of file, write \"yes\"");
        Scanner in =new Scanner(System.in);
        String choise = in.nextLine();
        switch (choise){
            case "yes": file.setWritable(!file.canWrite());
            default:
                break;
        }
        log.info(String.format("\t\tFile %s be written now", file.canWrite()?"can": "cant" ));
    }

    public static void showPermissions(File file) {
        log.info(String.format("\t\tFile %s be read", file.canRead()?"can": "cant" ));
        log.info(String.format("\t\tFile %s be written", file.canWrite()?"can": "cant" ));

    }
}

