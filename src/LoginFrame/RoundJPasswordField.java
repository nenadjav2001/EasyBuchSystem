package LoginFrame;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

public class RoundJPasswordField  extends JPasswordField {

    int witdh;
    int heigt;
    private Color color = Color.white;
    Border emptyBorder = BorderFactory.createEmptyBorder(5 ,5 ,5 ,5);
    Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
    Color borderColor = Color.black;

    public RoundJPasswordField() {
        this.setOpaque(false);
        this.setBorder(emptyBorder);

    }

    protected void paintComponent (Graphics g)  {

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g.setColor(color);
        g.fillRoundRect(0 , 0, getWidth() - 1, getHeight() - 1, 25 , 25);


        super.paintComponent(g);
    }
    @Override
    protected void paintBorder(Graphics g) {

        // Zeichnen der Linien-Grenze
        g.setColor(borderColor);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 25, 25);
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void paintBackGround(Graphics g) {

        g.setColor(borderColor);

    }
}
