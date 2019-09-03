package mychatapp.newtorking;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class messageTransmitter extends Thread{
    
    private String message, hostname;
    private int port;
    
    public messageTransmitter() { }
    
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
