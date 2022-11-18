
package UAS.View;

import javax.swing.*;
import UAS.Model.User;
import UAS.Controller.Controller;
import UAS.Controller.Sql;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Menu2 {
    
    Controller controller = new Controller();
    Sql sql = new Sql();
    
    public Menu2() {
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Menu 2");
        
        JLabel judul = new JLabel("Menu 2");
        judul.setBounds(250, 10, 100, 20);
        frame.add(judul);
        
        JLabel labelUsername = new JLabel("Input Alamat");
        labelUsername.setBounds(20, 80, 150, 25);
        JTextField inputUsername = new JTextField();
        inputUsername.setBounds(180, 80, 150, 25);
        frame.add(labelUsername);
        frame.add(inputUsername);
        
        frame.addWindowListener(new WindowAdapter() { 
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                new MainMenuView();
            }
        });
    }
    
}
