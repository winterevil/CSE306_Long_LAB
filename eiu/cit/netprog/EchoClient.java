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
public class EchoClient {

    public final static String SERVER = "localhost";
    public final static int PORT = 13;
    public final static int TIME = 15000;

    public static void main(String[] args) {
        Socket s = null;
        try {
            s = new Socket(SERVER, PORT);
            s.setSoTimeout(TIME);

            InputStream in = s.getInputStream();
            BufferedReader r = new BufferedReader(new InputStreamReader(in, "utf-8"));
            OutputStream out = s.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer = new BufferedWriter(writer);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String line = reader.readLine();
            while (!(line.equals("quit"))) {
                writer.write(line + "\r\n");
                writer.flush();
                readEcho(r);
                line = reader.readLine();
            }

            writer.write("quit" + "\r\n");
            writer.flush();
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
//            if (s != null) {
//                try {
//                    s.close();
//                } catch (IOException ex) {
//                }
//            }
        }
    }

    public static void readEcho(BufferedReader r) {
        try {
            String echo = r.readLine();
            System.out.println(echo);
        } catch (IOException ex) {
        }
    }
}
