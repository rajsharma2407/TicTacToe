package tictactoe;
import java.awt.*;

import javax.swing.border.Border;

public class RoundedBorder implements Border {

    private int radius;


    RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+5, this.radius+5, this.radius+5, this.radius+5);
    }


    public boolean isBorderOpaque() {
        return false;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}