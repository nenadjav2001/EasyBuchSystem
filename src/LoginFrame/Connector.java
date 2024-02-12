package LoginFrame;

import javax.swing.*;
import java.io.IOException;
import java.net.InetAddress;

public class Connector {

    boolean wifi = false;


public Connector(){



}

    public void checkInternetConnection () throws StackOverflowError {
        try {
          wifi = InetAddress.getByName("www.google.com").isReachable(3000); // 3 Sekunden Timeout
            JOptionPane.showMessageDialog(null , "Internetverbindung vorhanden.");
        } catch (IOException e) {

            if (!wifi){
               JOptionPane.showMessageDialog(null , "Keine Internetverbindung." , "Wifi-Error" , JOptionPane.ERROR_MESSAGE);
            }

        }
    }






}
