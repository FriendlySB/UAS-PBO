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
        frame.setTitle("Main Menu");
        
        JLabel judul = new JLabel("Main Menu");
        judul.setBounds(250, 10, 100, 20);
        frame.add(judul);
        
        JButton buttonLogin = new JButton("Login");
        buttonLogin.setBounds(150, 100, 300, 50);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new MenuLogin();
            }
        });
        frame.add(buttonLogin);
        
        JButton buttonRegister = new JButton("Register");
        buttonRegister.setBounds(150, 175, 300, 50);
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new MenuRegister();
            }
        });
        frame.add(buttonRegister);
        
        JButton buttonLihat = new JButton("Lihat Data Pengguna");
        buttonLihat.setBounds(150, 250, 300, 50);
        buttonLihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new MenuLihatDataPengguna();
            }
        });
        frame.add(buttonLihat);
    }
    
}
