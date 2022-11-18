package UAS.View;

import UAS.Controller.Sql;
import UAS.Model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenuView {

    public MainMenuView() {
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Main Menu User");
        
        JLabel judul = new JLabel("Main Menu");
        judul.setBounds(250, 10, 100, 20);
        frame.add(judul);
        
        JButton btnMenu1 = new JButton("Menu 1");
        btnMenu1.setBounds(150, 100, 300, 50);
        btnMenu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new Menu1();
            }
        });
        frame.add(btnMenu1);
        
        JButton btnMenu2 = new JButton("Menu 2");
        btnMenu2.setBounds(150, 175, 300, 50);
        btnMenu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new Menu1();
            }
        });
        frame.add(btnMenu2);
    }
    
}
