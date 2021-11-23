package at.htlstp.gratzer.fabian.Serial_Compass;

import at.htlstp.gratzer.fabian.Serial_Compass.com.ComListener;

import javax.swing.*;

public class Main extends JFrame {

    private Main() {
        super("Serial-Compass");
        setSize(128, 64);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        if(args.length == 0)
            throw new RuntimeException("You have to specify a valid serial port!");

        ComListener listener = new ComListener(args[0]);
        JFrame frame = new Main();
        GraphicsJPanel panel = new GraphicsJPanel(128, 64);
        frame.add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        listener.addDataListener(bytes -> panel.setAngle((short)(360*(bytes[0]/127.0))));
    }
}
