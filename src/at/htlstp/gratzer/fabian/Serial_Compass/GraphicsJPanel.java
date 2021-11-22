package at.htlstp.gratzer.fabian.Serial_Compass;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import javax.swing.*;
import java.awt.*;

public class GraphicsJPanel extends JPanel {
    private final int width, height;
    private short angle = 0;

    public GraphicsJPanel(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public GraphicsJPanel(@NotNull Dimension dimension) {
        width = dimension.width;
        height = dimension.height;
    }

    public void setAngle(@Range(from = 0, to = 360) short angle) {
        this.angle = angle;
        repaint();
    }

    @Override
    protected void paintComponent(@NotNull Graphics g) {
        g.setColor(Color.WHITE);
        g.clearRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(height/2+1, 1, (height/2-1)*2-1, (height/2-1)*2-1);
        g.drawLine(
                width/2,
                height/2,
                (int)Math.round((height/2.1) * Math.cos((angle - 90) * 2*Math.PI/360) + (width/2.0)),
                (int)Math.round((height/2.1) * Math.sin((angle - 90) * 2*Math.PI/360) + (height/2.0))
        );
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
}
