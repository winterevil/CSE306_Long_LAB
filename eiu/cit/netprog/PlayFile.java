/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.*;
import javax.sound.sampled.*;

/**
 *
 * @author Admin
 */
public class PlayFile {

    public static void main(String[] args) {
        try {
            String s = "D:\\CSE306\\lab-exercises\\src\\file\\sample1.wav";
            File file = new File(s);
            AudioInputStream ain = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(ain);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength());
            clip.stop();
        } catch (Exception e) {

        }
    }
}
