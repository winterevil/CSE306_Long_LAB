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
public class Weblog {

    public static void main(String[] args) {
        try {
            String file = "D:\\CSE306\\lab-exercises\\weblog.txt";
            Reader reader = new InputStreamReader(new FileInputStream(file), "utf-8");
            BufferedReader br = new BufferedReader(reader);

            for (String entry = br.readLine(); entry != null; entry = br.readLine()) {
                int index = entry.indexOf(" ");
                String ip = entry.substring(0, index);
                String rest = entry.substring(index);
                try {
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostName() + rest);
                } catch (UnknownHostException ex) {
                }
            }

        } catch (Exception e) {
        }
    }
}
