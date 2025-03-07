package gui;

import javax.swing.*;


/**
 * This class represents the main frame of the application.
 * Singleton pattern
 */
public class MainFrame extends JFrame {
    private static MainFrame instance;

    private MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(GamePanel.getInstance());
        pack();
        setVisible(true);
        GamePanel.getInstance().requestFocusInWindow();
    }

    /**
     * Returns the only instance of MainFrame
     * @return the MainFrame instance
     */
    public static MainFrame getInstance() {
        if(instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    /**
     * Sets the title of the frame.
     * @param title the title to be displayed in the frame's border.
     */
    public void setTitle(String title) {
        super.setTitle(title);
    }



}
