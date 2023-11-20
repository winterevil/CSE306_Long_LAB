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
public class EchoServer {

    public final static int PORT = 13;

    public static void main(String[] args) {
        try ( ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try ( Socket connection = server.accept()) {
                    Writer out = new OutputStreamWriter(connection.getOutputStream(), "utf-8");
                    out = new BufferedWriter(out);
                    Reader in = new InputStreamReader(connection.getInputStream(), "utf-8");
                    BufferedReader r = new BufferedReader(in);
                    for (String line = r.readLine(); !line.equals("quit"); line = r.readLine()){
                        out.write(line + "\r\n");
                        out.flush();
                    }
                    connection.close();
                    server.close();
                    break;
                } catch (IOException ex) {
                }
            }
            
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
