package com.epam.lab.File200MB;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.LinkedList;

import static java.lang.System.out;
public class BufferRW {
    private static final Logger log = Logger.getLogger(LinkedList.class);
    public static void bufferReadWrite(File file , File filew ){
        try(BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(filew));){
            double timerBufferRW =System.currentTimeMillis();
            String line ;
            while ((line = br.readLine())!= null) {
                bw.write(line);
            }
            out.flush();
            br.close();
            bw.close();
            log.info(String.format("Read time from file %s with buffer %.3f s",file,(System.currentTimeMillis() - timerBufferRW)*0.001));
        }catch (Exception fnfex){
            log.info(fnfex.getMessage()+"Something wrong with file with buffer");
        }
    }
    public static void main(String[] args) throws IOException {
        Paths paths = new Paths();

        bufferReadWrite(paths.getFile100KB(), paths.getFilew100KB());
        bufferReadWrite(paths.getFile200KB(), paths.getFilew200KB());
        usual(paths.getFile100KB());
        usual(paths.getFile200KB());

    }

    public static void usual(File file){
        try(FileInputStream inputF = new FileInputStream(file);
            FileOutputStream outputF = new FileOutputStream("fileO.txt");){
            double IOstream =System.currentTimeMillis();
            int data;
            while ((data = inputF.read())!= -1) {
                outputF.write((char)data);
            }
            log.info(String.format("Read time from file %s with FileStream %.3f s",file,(System.currentTimeMillis() - IOstream)*0.001));
        }catch (Exception e){
            out.println(e.getMessage()+"Something wrong with file with FileStream");
        }
    }
}
