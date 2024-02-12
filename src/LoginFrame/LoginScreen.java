package LoginFrame;

import javax.swing.*;


public class LoginScreen extends JFrame {



    LoginPanel loginPanel;
    final int screenWitdh = 1080;
    final int screenHeight = 720;
    ImageIcon icon = new ImageIcon("icon-bibliothek-gross1.png");
    public LoginScreen(){
        super("Bucherfassung");
    }

public void createLoginScreen() throws NullPointerException{


     loginPanel = new LoginPanel();



      this.add(loginPanel);
    this.setIconImage(icon.getImage());


    this.setSize(screenWitdh , screenHeight);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setLayout(null);
    this.setLocationRelativeTo(null);
    this.setVisible(true);

}


     public int getScreenWitdh(){

        return screenWitdh;
     }
      public int getScreenHeight(){

        return screenHeight;
    }

    public JFrame getFrame(){
        return this;
    }


}
