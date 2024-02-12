package LoginFrame;


import MySQL_DataBase.DataBaseDriver;
import OnlineLiabry.ColorsAndFonts;

import javax.swing.*;
import java.awt.*;

public class CreateAccount extends JFrame {


    RegPanel regPanel = new RegPanel();
    private final int screenWitdh = 600;
    private final int screenHeight = 600;
    JButton reg = new JButton();
    RoundJTextField[] regTextFields = new RoundJTextField[2];
    RoundJPasswordField[] regPasswordsFields = new RoundJPasswordField[2];
    JLabel[] regLabelsFields = new JLabel[4];
    ColorsAndFonts colorsAndFonts = new ColorsAndFonts();

    public CreateAccount() {

        super("Online-Libary");

    }

    public void createAccountFrame() {
        addingMehtodsToFrame();
        this.add(regPanel);
        this.setSize(screenWitdh, screenHeight);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void addingMehtodsToFrame() {
        addingJTextFields();
        addingJPasswordsFields();
        addingJButton();
        addingJLabels();
    }

    public void addingJTextFields() throws NullPointerException {

        int textFieldsX = 200;
        int textFieldsY = 100;
        int textFieldsWitdh = 200;
        int textFieldsHeight = 30;

        for (int i = 0; i < regTextFields.length; i++) {
            regTextFields[i] = new RoundJTextField();
            regTextFields[i].setBounds(textFieldsX, textFieldsY, textFieldsWitdh, textFieldsHeight);
            regTextFields[i].setBorder(colorsAndFonts.getComponentBorder());
            regTextFields[i].setFont(colorsAndFonts.getFieldFont());
            textFieldsY += 60;
            addingComponentsToPanel(regPanel, regTextFields[i]);

        }

    }

    public void addingJPasswordsFields() throws NullPointerException {

        int pFieldsX = 200;
        int pFieldsY = 220;
        int pFieldsWitdh = 200;
        int pFieldsHeight = 30;

        for (int i = 0; i < regPasswordsFields.length; i++) {
            regPasswordsFields[i] = new RoundJPasswordField();
            regPasswordsFields[i].setBounds(pFieldsX, pFieldsY, pFieldsWitdh, pFieldsHeight);
            regPasswordsFields[i].setBorder(colorsAndFonts.getComponentBorder());
            regPasswordsFields[i].setFont(colorsAndFonts.getFieldFont());
            pFieldsY += 60;
            addingComponentsToPanel(regPanel, regPasswordsFields[i]);
        }
    }


    public void addingJLabels() {

        int labelsX = 200;
        int labelsY = 75;
        int labelsWitdh = 200;
        int labelsHeight = 30;

        for (int i = 0; i < regLabelsFields.length; i++) {

            regLabelsFields[i] = new JLabel();

            regLabelsFields[0] = new JLabel();
            regLabelsFields[1] = new JLabel();
            regLabelsFields[2] = new JLabel();
            regLabelsFields[3] = new JLabel();

            regLabelsFields[0].setText("Username");
            regLabelsFields[1].setText("Email-@");
            regLabelsFields[2].setText("Passwort");
            regLabelsFields[3].setText("Passwort-Wiederholen");

            regLabelsFields[i].setForeground(Color.white);

            regLabelsFields[i].setFont(new Font("Arial", Font.ITALIC, 15));

            regLabelsFields[i].setBounds(labelsX, labelsY, labelsWitdh, labelsHeight);
            labelsY += 60;

            addingComponentsToPanel(regPanel, regLabelsFields[i]);


        }

    }

    public void addingJButton() {

        reg.setFocusable(false);
        reg.setBounds(200, 400, 200, 30);
        reg.setText("Regestrieren");
        buttonListener(reg);
        addingComponentsToPanel(regPanel, reg);
    }

    public void buttonListener(JButton button) {

        button.addActionListener(e -> userRegistrieren());

    }
    public void userRegistrieren() {
        if (usernameAndEmailCheck() && passwordCheck()) {
            new DataBaseDriver().addingDataToDatabase(regTextFields[1].getText(), getPassword(), regTextFields[0].getText());
            System.out.println("Daten wurden in die Datenbank geladen");
        }
    }

    public boolean usernameAndEmailCheck() {
        String username = regTextFields[0].getText();
        String email = regTextFields[1].getText();

        if (username.length() < 5 || username.length() >= 30) {
            JOptionPane.showMessageDialog(null, "Username ist ungültig. Ihr Passwort ist zu kurz oder zu lang!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (email.length() <= 10 || email.length() >= 30 || !email.contains("@")) {
            return false;
        }

        return true;
    }

    public boolean passwordCheck() {
        if (passwordZahlenPatternCheck() && passwordSonderzeichenPatternCheck()
                && passwordGrossbuchstabenPatternCheck() && passwordAndRepeatPasswordCheck()) {
            return true;
        }
        return false;
    }

    public boolean passwordSonderzeichenPatternCheck() {
        String password = getPassword();
        return password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }

    public boolean passwordZahlenPatternCheck() {
        String password = getPassword();
        return password.matches(".*[0-9].*");
    }

    public boolean passwordGrossbuchstabenPatternCheck() {
        String password = getPassword();
        return password.matches(".*[A-Z].*");
    }

    public boolean passwordAndRepeatPasswordCheck() {
        String password = getPassword();
        String repeatPassword = getRepeatPassword();

        if (password.length() <= 5 || password.length() >= 20) {
            JOptionPane.showMessageDialog(null, "Passwort ist ungültig");
            return false;
        } else if (!password.equals(repeatPassword)) {
            JOptionPane.showMessageDialog(null, "Passwörter stimmen nicht überein");
            return false;
        }

        return true;
    }



    public String getPassword() {
        return String.valueOf(regPasswordsFields[0].getPassword());
    }

    public String getRepeatPassword() {

        return String.valueOf(regPasswordsFields[1].getPassword());
    }


    public void addingComponentsToPanel(JPanel panel, Component component) {

        panel.add(component);
    }


}





