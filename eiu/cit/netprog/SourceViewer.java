/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.*;
import java.net.*;

/**
 *
 * @author Admin
 */
public class SourceViewer {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.tanbinhtech.com/july.webp/");
            InputStream in = u.openStream();
            int c;
            while ((c = in.read()) != -1) {
                System.out.write((char) c);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
