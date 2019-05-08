/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychatapp.newtorking;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rumi
 */
public class messageTransmitter extends Thread{
    
    String message, hostname;
    int port;
    
    public messageTransmitter()
    {
        
    }
    
    public messageTransmitter(String message, String hostname, int port)
    {
        this.message = message;
        this.hostname = hostname;
        this.port = port;
    }
    
    @Override
    public void run()
    {
        try {
            Socket s = new Socket(hostname, port);
            s.getOutputStream().write(message.getBytes());
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(messageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
