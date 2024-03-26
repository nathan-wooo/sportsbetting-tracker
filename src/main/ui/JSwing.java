package ui;

import javax.swing.JFrame;
import java.awt.*;

public class JSwing extends JFrame {

    public JSwing() {
        super();
        setTitle("Nathan's Betting App");
        setSize(1024,768);
        setLayout(new BorderLayout());
        setVisible(true);
    }

    public static void main(String[] args) {

        new JSwing();

    }

}
