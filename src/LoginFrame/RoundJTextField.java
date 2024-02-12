package LoginFrame;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class RoundJTextField extends JTextField {

    int witdh = 200;
    int height = 30;
    Color borderColor = Color.black;

    private Color color = Color.white;

    public RoundJTextField() {
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    protected void paintComponent(Graphics g) {


        Graphics2D g2 = (Graphics2D) g;



        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);


        g.setColor(color);
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 25, 25);


        super.paintComponent(g);
        repaint();

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
}
