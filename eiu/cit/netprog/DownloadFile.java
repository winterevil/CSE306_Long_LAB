/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.*;
import java.net.*;
import javax.sound.sampled.*;

/**
 *
 * @author Admin
 */
public class DownloadFile {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.tanbinhtech.com:8443/sample10.wav");
            InputStream in = u.openStream();
            String s = "D:\\CSE306\\lab-exercises\\src\\file\\sample10.wav";
            File file = new File(s);
            OutputStream out = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(out);
            BufferedInputStream bis = new BufferedInputStream(in);

            int c;
            while ((c = bis.read()) != -1) {
                bos.write(c);
            }
            bos.close();  
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
