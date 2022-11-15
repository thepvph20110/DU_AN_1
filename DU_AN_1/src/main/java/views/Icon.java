/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DANG VAN SY
 */
public class Icon extends JFrame {

    private JPanel PANEL;

    private JLabel LABEL2;

    private ImageIcon ICON;

    public Icon() {

        super("Choose background color");

        ICON = new ImageIcon(getClass().getResource("give image path"));
        LABEL2 = new JLabel(ICON);

        PANEL.setLayout(null);

        LABEL2.setBounds(50, 50, 50, 50);

        PANEL.add(LABEL2);

        add(PANEL);

        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(400, 400);
    }

}
