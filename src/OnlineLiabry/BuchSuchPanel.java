package OnlineLiabry;

import javax.swing.*;
import java.awt.*;

public class BuchSuchPanel extends JPanel {

    private final int panelX = 600;
    private final int panelY = 300;
    private final int panelWitdh = 400;
    private final int panelHeight = 400;

public BuchSuchPanel(){

}


public void createBuchSuchPanel(JPanel panel){

    this.setBounds(panelX , panelY , panelWitdh , panelHeight);
    this.setBackground(Color.RED);

}



}
