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
public class TTTClient {

    public final static String SERVER = "localhost";
    public final static int PORT = 13;
    public final static int TIME = 15000;

    public static void main(String[] args) {
        Socket s = null;
        try {
            s = new Socket(SERVER, PORT);
            s.setSoTimeout(TIME);

            InputStream in = s.getInputStream();
            BufferedReader r = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            OutputStream out = s.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer = new BufferedWriter(writer);

            BufferedReader ter = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(r.readLine());

            String move = ter.readLine();
            while (!(move.equals("quit"))) {
                writer.write(move + "\r\n");
                writer.flush();
                System.out.println(r.readLine());
                move = ter.readLine();
            }

            writer.write("quit" + "\r\n");
            writer.flush();

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
