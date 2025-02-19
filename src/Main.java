import gui.GamePanel;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Shapes");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new GamePanel(50, 800, 600, 20));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

    }
}