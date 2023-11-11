/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.net.*;
import java.io.*;

/**
 *
 * @author Admin
 */
public class ImageDownload {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://file-examples.com/storage/fe1134defc6538ed39b8efa/2017/11/file_example_MP3_700KB.mp3");
            InputStream in = u.openStream();
            String s = "D:\\CSE306\\lab-exercises\\song.mp3";
            OutputStream out = new FileOutputStream(new File(s));
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
