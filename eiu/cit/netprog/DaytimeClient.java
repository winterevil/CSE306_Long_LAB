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
public class DaytimeClient {
    
    public final static String SERVER = "localhost";
    public final static int PORT = 13;
    public final static int TIME = 15000;
    
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            try {
                Socket s = new Socket(SERVER, PORT);
                s.setSoTimeout(TIME);
                Reader in = new InputStreamReader(s.getInputStream());
                int c;
                
                while ((c = in.read()) != -1) {
                    System.out.print((char) c);
                }
                
                System.out.println("");
            } catch (IOException ex) {
                System.err.println(ex);
            }
            Thread.sleep(1000);
        }
    }
}
