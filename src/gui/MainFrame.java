package gui;

import javax.swing.*;

public class MainFrame extends JFrame {
    private static MainFrame instance;

    private MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(GamePanel.getInstance());
        pack();
        setVisible(true);
    }

    public static MainFrame getInstance() {
        if(instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    public void setTitle(String title) {
        super.setTitle(title);
    }



}
