
package UAS.View;

import javax.swing.*;
import UAS.Model.User;
import UAS.Controller.Controller;
import UAS.Controller.Sql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Menu1 {
    
    Controller controller = new Controller();
    Sql sql = new Sql();
    int b = 1;
    public Menu1() {
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Menu 1");
        
        JLabel judul = new JLabel("Menu 1");
        judul.setBounds(250, 10, 100, 20);
        frame.add(judul);
        
        JLabel labelUsername = new JLabel("Input Username");
        labelUsername.setBounds(20, 80, 150, 25);
        JTextField inputUsername = new JTextField();
        inputUsername.setBounds(180, 80, 150, 25);
        frame.add(labelUsername);
        frame.add(inputUsername);
        
        JLabel labelAlamat = new JLabel("Input Alamat");
        labelAlamat.setBounds(20, 110, 150, 25);
        JTextField inputAlamat = new JTextField();
        inputAlamat.setBounds(180, 110, 150, 25);
        frame.add(labelAlamat);
        frame.add(inputAlamat);
        
        JButton btnInsert = new JButton("Insert");
        btnInsert.setBounds(250, 200, 100, 50);
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                User user = new User(1, inputUsername.getText(),inputAlamat.getText());
                if(sql.insertDataUser(user)){
                    JOptionPane.showMessageDialog(null, "Sukses", 
                            "Message", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new Menu1();
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Insert", 
                            "Message", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        frame.addWindowListener(new WindowAdapter() { 
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                new MainMenuView();
            }
        });
        frame.add(btnInsert);
    }
    
}
