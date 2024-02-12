package OnlineLiabry;

import LoginFrame.LoginScreen;
import LoginFrame.RoundJTextField;
import MySQL_DataBase.DataBaseDriver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class LiabaryFrame extends JFrame {


    public JTextArea textArea;

    // Größe und Breite des Frames
    final private int screenWitdh = 1200;
    final private int screenHeight = 800;
    BackGroundPanel backGroundPanel = new BackGroundPanel();

    JButton logOutButton = new JButton();
    RoundJTextField searchField = new RoundJTextField();
    JButton searchButton = new JButton();
    public DefaultListModel<String> listModel;


    public LiabaryFrame() {

        super("Libary-Frame");
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(320, 180, 800, 400); // Beispielposition und -größe, anpassen nach Bedarf
        textArea.setBackground(Color.white);
        textArea.setForeground(Color.black);
        textArea.setBorder(BorderFactory.createLineBorder(new Color(255,215,0) ,10 ,  true));
        textArea.setFont(new Font("Arial" , Font.ITALIC , 20));
        addingComponentsToPanel(scrollPane);

        this.getContentPane().add(scrollPane);
    }


    public void createLibaryFrame() {

        libaryFrameMethods();

        this.add(backGroundPanel);
        this.setSize(screenWitdh, screenHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void libaryFrameMethods() {
        addingLabelToFrame();

        editJButton();
        addingSearchButtonAndField();
        getSelectedElement(textArea);
    }

    //Label Überschrift
    public void addingLabelToFrame() {
        String labelText = "Libary Management System - Nenad Cvitan";
        JLabel labelUeberschrift = new JLabel(labelText);
        labelUeberschrift.setBounds(390, 15, 600, 50);
        labelUeberschrift.setForeground(Color.white);
        labelUeberschrift.setFont(new ColorsAndFonts().getFont());
        addingComponentsToPanel(labelUeberschrift);
    }








    public void editJButton() {

        int buttonX = 950;
        int buttonY = 700;
        int buttonWitdh = 200;
        int buttonHeight = 30;

        logOutButton.setBounds(buttonX, buttonY, buttonWitdh, buttonHeight);
        logOutButton.setForeground(new ColorsAndFonts().componentForeGround());
        logOutButton.setBorder(new ColorsAndFonts().getComponentBorder());
        logOutButton.setBackground(new ColorsAndFonts().getComponentColor());
        logOutButton.setText("Logout");
        logOutButton.setFocusable(false);
        logOutButtonListener(logOutButton);

        addingComponentsToPanel(logOutButton);
    }

    public void logOutButtonListener(JButton button) {

        button.addActionListener(e -> {

            JOptionPane.showMessageDialog(null, "User wurde Erfolgreich abgemeldet");
            dispose();
            new LoginScreen().createLoginScreen();

        });

    }

    public void addingSearchButtonAndField() {

        searchButton.setBounds(620, 105, 100, 20);
        searchButton.setFocusable(false);
        searchButton.setText("Suche");
        searchButton.setBackground(Color.white);

        searchField.setBounds(400, 100, 200, 30);
        searchField.setFont(new ColorsAndFonts().getFieldFont());
        buttonListenersearch(searchButton);

        addingComponentsToPanel(searchButton);
        addingComponentsToPanel(searchField);

    }


    public void addingComponentsToPanel(Component component) throws NullPointerException {
        backGroundPanel.add(component);
    }

    public void searchBooks() throws IOException {
        String query = searchField.getText();
        String apiUrl;
        try {
            apiUrl = "https://www.googleapis.com/books/v1/volumes?q=" + URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return;
        }

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject json = new JSONObject(response.toString());
            JSONArray items = json.getJSONArray("items");

            StringBuilder booksText = new StringBuilder();
            for (int i = 0; i < items.length(); i++) {
                JSONObject volumeInfo = items.getJSONObject(i).optJSONObject("volumeInfo");
                if (volumeInfo != null && volumeInfo.has("title")) {
                    String title = volumeInfo.getString("title");
                    booksText.append("Title: ").append(title).append("\n");
                    if (volumeInfo.has("authors")) {
                        JSONArray authorsArray = volumeInfo.getJSONArray("authors");
                        for (int j = 0; j < authorsArray.length(); j++) {
                            String author = authorsArray.getString(j);
                            booksText.append("Author: ").append(author).append("\n");
                        }
                    }
                    booksText.append("\n");
                }
            }
            textArea.setText(booksText.toString());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public void buttonListenersearch(JButton buttton) {

        buttton.addActionListener(e -> {
            try {
                searchBooks();
            } catch (UnsupportedEncodingException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

     public void getSelectedElement(JTextArea textArea){

        textArea.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

                if (textArea.getSelectedText() != null && textArea.getSelectedText().length() >= 50){
                    String s = textArea.getSelectedText();
                    new DataBaseDriver().addingBookToDatabase(s);
                    System.out.println(s);
                } else {
                    JOptionPane.showMessageDialog(null ,"Buch Titel ist nicht Lange Genug " , "Error" ,JOptionPane.ERROR_MESSAGE);
                }


            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

     }



}




