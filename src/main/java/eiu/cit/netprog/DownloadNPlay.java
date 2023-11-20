/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.*;
import java.net.*;
import javax.sound.sampled.*;

/**
 *
 * @author Admin
 */
public class DownloadNPlay {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.tanbinhtech.com:8443/sample10.wav");
            InputStream inputStream = u.openStream();
            inputStream = new BufferedInputStream(inputStream);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(u);
            
            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
            
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            byte[] bufferBytes = new byte[4096];
            int readBytes = -1;
            while ((readBytes = audioStream.read(bufferBytes)) != -1) {
                sourceDataLine.write(bufferBytes, 0, readBytes);
            }
            
            sourceDataLine.drain();
            sourceDataLine.close();
            audioStream.close();
        } catch (Exception e) {
        }
    }
}
