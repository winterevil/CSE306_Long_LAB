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
public class MyEliza {

    public static final String SERVER = "telehack.com";

    public static final int PORT = 23;

    public static final int TIME = 15000;

    public static void main(String[] args) {
        Socket s = null;
        try {
            s = new Socket(SERVER, PORT);
            s.setSoTimeout(TIME);

            InputStream in = s.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

            OutputStream out = s.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer = new BufferedWriter(writer);

            int c, t = -1;
            while ((c = in.read()) != -1) {
                //System.out.print((char) c);
                if ((char) c == '.') {
                    if ((char) t == '\n') {
                        break;
                    }
                }
                t = c;
            }

            writer.write("eliza\r\n");
            writer.flush();
            readFirst(reader);

            BufferedReader ter = new BufferedReader(new InputStreamReader(System.in));

            String line = ter.readLine();
            while (!(line.equals("quit"))) {
                writer.write(line + "\r\n");
                writer.flush();
                readEliza(reader);
                line = ter.readLine();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    public static void readEliza(BufferedReader reader) {
        int c, count = 0;
        try {
            while ((c = reader.read()) != -1) {
                if ((char) c == '\r') {
                    if (count == 3) {
                        break;
                    } else {
                        count++;
                    }
                }
                if (count == 2) {
                    System.out.print((char) c);
                }
            }
            System.out.println();
        } catch (Exception ex){
        }
    }

    public static void readFirst(BufferedReader reader){
        int c, count = 0;
        try {
            while ((c = reader.read()) != -1) {
                if ((char) c == '\r') {
                    if (count == 2) {
                        break;
                    } else {
                        count++;
                    }
                }
                if (count == 1) {
                    System.out.print((char) c);
                }
            }
            System.out.println();
        } catch (Exception ex){
        }
    }
}
