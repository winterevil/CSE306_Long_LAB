/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.*;
import java.net.*;
import javazoom.jl.player.Player;
/**
 *
 * @author Admin
 */
public class PlayMp3Online {

    public static void main(String[] args) {
        try {
            URL u = new URL("http://ice10.outlaw.fm/KIEV2");
            InputStream inputStream = u.openStream();
            inputStream = new BufferedInputStream(inputStream);
            
            Player mp3 = new Player(inputStream);
            mp3.play();
        } catch (Exception e) {
            System.out.println("Error occured during playback process:" + e.getMessage());
        }
    }
}
