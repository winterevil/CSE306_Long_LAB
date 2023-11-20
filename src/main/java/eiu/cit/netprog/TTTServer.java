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
public class TTTServer {

    public final static int PORT = 13;

    public static void main(String[] args) {
        try ( ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try ( Socket connection = server.accept()) {
                    Writer out = new OutputStreamWriter(connection.getOutputStream(), "utf-8");
                    BufferedWriter writer = new BufferedWriter(out);
                    Reader in = new InputStreamReader(connection.getInputStream(), "utf-8");

                    BufferedReader r = new BufferedReader(in);

                    String[] board = {"-", "-", "-", "-", "-", "-", "-", "-", "-"};
                    writeBoard(writer, board);
                    writer.write("\r\n");
                    writer.flush();

                    String move = r.readLine();
                    while (!(move.equals("quit"))) {

                        if (!(board[Integer.parseInt(move)].equals("-"))) {
                            writer.write("Wrong movement" + "\r\n");
                            writer.flush();
                        } else {
                            board[Integer.parseInt(move)] = "x";
                            if (checkDraw(board)) {
                                makeMove(board);
                                writeBoard(writer, board);
                                writer.write("\r\n");
                                writer.flush();
                            } else {
                                writeBoard(writer, board);
                                writer.write("***Draw***");
                                writer.write("\r\n");
                                writer.flush();
                            }
                        }
                        move = r.readLine();
                    }
                    connection.close();
                    server.close();
                    break;
                } catch (IOException ex) {
                }
            }
        } catch (IOException ex) {
        }
    }

    public static void writeBoard(BufferedWriter writer, String[] board) throws IOException {
        for (int i = 0; i < board.length; i++) {
            writer.write(board[i]);
        }
    }

    public static void makeMove(String[] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i].equals("-")) {
                board[i] = "o";
                break;
            }
        }
    }

    public static boolean checkDraw(String[] board) {
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i].equals("-")) {
                res = true;
                break;
            }
        }
        return res;
    }
}
