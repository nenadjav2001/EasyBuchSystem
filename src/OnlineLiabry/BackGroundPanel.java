package OnlineLiabry;

import javax.swing.*;
import java.awt.*;

public class BackGroundPanel extends JPanel  {

    private Image hintergrundBild3;
  //  private LiabaryFrame liabaryFrame = new LiabaryFrame();

    JPanel panel = new JPanel();

    public BackGroundPanel() {

        hintergrundBild3 = new ImageIcon("C:\\Users\\bewer\\Downloads\\QuickStart\\BuchSystem\\src\\65abcdfb4cefe860d5e835b416e39e38.jpg").getImage();
        this.setBounds(0 ,0 , 1200 , 800);
        this.setLayout(null);
     //  addingJPanel(panel);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);


        // Zeichnen Sie das Hintergrundbild
        g.drawImage(hintergrundBild3, 0, 0, 1200, 800, this);
    }


       public void addingJPanel(JPanel panelBuch){

        this.panel = panelBuch;
         panel = new JPanel();
        panel.setBounds(400 , 400 , 400 , 400);
        panel.setBackground(Color.green);
        this.add(panel);
     }

     public JPanel getPanel(){
        return panel;
     }


}