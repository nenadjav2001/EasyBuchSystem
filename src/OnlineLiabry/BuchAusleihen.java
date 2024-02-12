package OnlineLiabry;

import javax.swing.*;
import java.awt.*;

public class BuchAusleihen extends JPanel {

    private JTextField [] fieldsBuchAusleihen;
    BackGroundPanel backGroundPanel;

   public BuchAusleihen(){
    fieldsBuchAusleihen = new JTextField[5];
    backGroundPanel = new BackGroundPanel();

   }

   public void createBuchAusleihenPanel() throws NullPointerException{

       addingMehthodsToPanel();
       final int panelX = 400;
       final int panelY = 400;
       final int panelWitdh = 600;
       final int panelHeight = 400;

       this.setBackground(Color.gray);
       this.setBounds(panelX , panelY , panelWitdh , panelHeight);
       this.setLayout(null);
       this.setOpaque(true);
       this.setVisible(true);
       backGroundPanel.add(this);
   }

   public void addingMehthodsToPanel(){

   }

   public Font getComponentFont(){
       Font font = new Font("Arial" , Font.ITALIC , 15);
       return font;
   }

     public Color componentColor(){
         Color color = new Color(50);
         return color;
     }


}
