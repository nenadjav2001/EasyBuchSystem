package OnlineLiabry;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ColorsAndFonts {

    public Font getFont() {
        Font fontComponent = new Font("Arial", Font.ITALIC, 30);
        return fontComponent;
    }

    public Color getComponentColor(){
        Color color = new Color(50);
        return color;
    }
    public Border getComponentBorder(){
        Border border = BorderFactory.createLineBorder(Color.white , 1 , true);
        return border;
    }
    public Color componentForeGround(){
        Color color = Color.white;
        return color;
    }
    public String getTitle(){
        return "Online-Libary";

    }
   public Font getFieldFont(){
        Font font = new Font("Arial" , Font.ITALIC , 15);
        return font;
   }





}
