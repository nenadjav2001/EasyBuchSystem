package LoginFrame;

import MySQL_DataBase.DataBaseDriver;
import OnlineLiabry.ColorsAndFonts;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {


   private Image hintergrundBild3;

   private Image imageSmall;
    RoundJTextField userNameField = new RoundJTextField();
    RoundJPasswordField passwordField = new RoundJPasswordField();

    JButton [] loginPageButtons = new JButton[2];
    ColorsAndFonts colorsAndFonts = new ColorsAndFonts();
    JLabel [] loginLabels = new JLabel[2];


public LoginPanel() {
    hintergrundBild3 = new ImageIcon("C:\\Users\\bewer\\Downloads\\QuickStart\\BuchSystem\\src\\65abcdfb4cefe860d5e835b416e39e38.jpg").getImage();
    imageSmall = new ImageIcon("C:\\Users\\bewer\\Downloads\\QuickStart\\BuchSystem\\src\\38846b4a11f84222bbd4e4e62af7425d.png").getImage();
    this.setBounds(0 ,0 , 1080 , 720);
    this.setLayout(null);
    addingMethods();
}

public void addingMethods(){
addingUsernameField();
addingPasswordField();
addingLoginAndRegisterButton();
addingLabels();
}

public void addingUsernameField(){

     userNameField.setBounds(380 , 230 , 350 , 40);
     userNameField.setBorder(colorsAndFonts.getComponentBorder());
     userNameField.setFont(colorsAndFonts.getFieldFont());
     userNameField.setFont(new Font("Arial" , Font.PLAIN , 20));
     addingComponents(userNameField);
}

public void addingPasswordField(){

    passwordField.setBounds(380 , 310 , 350 ,40);
    passwordField.setBorder(colorsAndFonts.getComponentBorder());
    passwordField.setFont(colorsAndFonts.getFieldFont());
    passwordField.setFont(new Font("Arial" , Font.ITALIC , 20));
    addingComponents(passwordField);
}

public void addingLabels(){

    loginLabels[0] = new JLabel();
    loginLabels[1] = new JLabel();

    int y = 207;

    for (int i = 0; i < loginLabels.length; i++) {

        loginLabels[i].setBounds(380 , y , 200 ,20);
        loginLabels[0].setText("Username");
        loginLabels[1].setText("Passwort");
        loginLabels[i].setForeground(Color.white);
        loginLabels[i].setFont(new Font("Arial" , Font.ITALIC , 20));
         y+= 80;
        addingComponents(loginLabels[i]);

    }


}

public void addingLoginAndRegisterButton(){

    int x = 450;
    int y = 370;
    int witdh = 200;
    int height = 20;

    loginPageButtons[0] = new JButton();
    loginPageButtons[1] = new JButton();

    for (int i = 0; i < loginPageButtons.length; i++) {
        loginPageButtons[i].setBounds(x , y ,witdh , height);
        loginPageButtons[i].setFont(colorsAndFonts.getFieldFont());
        loginPageButtons[i].setBackground(Color.white);
        loginPageButtons[i].setFocusable(false);
        loginPageButtons[0].setText("Login");
        loginPageButtons[1].setText("Regestrieren");
         y+= 30;

         buttonListener(i , loginPageButtons[i]);

        addingComponents(loginPageButtons[i]);
    }
}

public void buttonListener(int index , JButton button){

    switch (index){

        case 0 : button.addActionListener(e -> {
            new DataBaseDriver().userAuthentication(getUsername() , getPassword());
        });
        break;

        case 1 : button.addActionListener(e -> {
            new CreateAccount().createAccountFrame();
        });
        break;

    }
}



@Override
protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);


        g2.drawImage(hintergrundBild3, 0, 0, getWidth(), getHeight(), this);
        g2.drawImage(imageSmall , 0 , 0  , 150 , 150 , this);
        }

        public String getUsername(){

    return userNameField.getText();
        }

        public String getPassword(){

    return String.valueOf(passwordField.getPassword());
        }



public void addingComponents(Component component){
    this.add(component);
}


}



