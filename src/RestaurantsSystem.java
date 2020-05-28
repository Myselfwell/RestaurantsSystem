import Boundary.Begin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RestaurantsSystem {
    public static void main(String[] args) {

        try {
            String systemLookAndFeel = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(systemLookAndFeel);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException
                | UnsupportedLookAndFeelException e) {
            System.out.println("Error: " + e);
        }
        EventQueue.invokeLater(() -> {
            Begin begin = new Begin();
            begin.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            begin.setVisible(true);
        });
    }
}
