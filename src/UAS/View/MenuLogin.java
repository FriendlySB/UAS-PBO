package UAS.View;

import javax.swing.*;
import UAS.Model.User;
import UAS.Controller.Controller;
import UAS.Controller.Sql;
import UAS.Model.CategoryUser;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MenuLogin {

    Controller controller = new Controller();
    Sql sql = new Sql();
    
    public MenuLogin() {
        JFrame frame = new JFrame();
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Login");
        
        //Logo
        String pathFoto = "C:\\Users\\USER\\Documents\\AAATESTER\\logo.png";
        
        ImageIcon iconFoto = new ImageIcon(new ImageIcon(pathFoto).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        
        JLabel pasFoto = new JLabel();
        pasFoto.setIcon(iconFoto);
        pasFoto.setBounds(200, 10, 150, 150);
        
        frame.add(pasFoto);
        
        JLabel labelApp = new JLabel("Aplikasi 1234");
        labelApp.setBounds(250, 160, 120, 30);
        frame.add(labelApp);
        
        //Username
        JLabel labelUsername = new JLabel("Input Username");
        labelUsername.setBounds(20, 220, 150, 25);
        JTextField inputUsername = new JTextField();
        inputUsername.setBounds(180, 220, 150, 25);
        frame.add(labelUsername);
        frame.add(inputUsername);
        
        //Password
        JLabel labelPass = new JLabel("Input Password");
        labelPass.setBounds(20, 250, 150, 25);
        JPasswordField inputPass = new JPasswordField();
        inputPass.setBounds(180, 250, 150, 25);
        frame.add(labelPass);
        frame.add(inputPass);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(200, 280, 150, 50);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String username = inputUsername.getText();
                String password = new String(inputPass.getPassword());
                ArrayList<User> listUser = new ArrayList<>(sql.getAllUser());
                
                boolean sukses = false;
                
                for(int i = 0; i < listUser.size(); i++){
                    if(username.equals(listUser.get(i).getUserName())){
                        if(password.equals(listUser.get(i).getPassword())){
                            sukses = true;
                            break;
                        }   
                    }
                }
                if(sukses){
                    JOptionPane.showMessageDialog(null, "Login Berhasil", 
                               "Message", JOptionPane.INFORMATION_MESSAGE); 
                    frame.dispose();
                    new MenuLihatDataPengguna();
                } else {
                    JOptionPane.showMessageDialog(null, "Login Gagal", 
                               "Message", JOptionPane.WARNING_MESSAGE); 
                }
            }
        });
        JButton btnMenu = new JButton("Back to Menu");
        btnMenu.setBounds(200, 340, 150, 50);
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new MainMenuView();
            }
        });
        frame.add(btnMenu);
        frame.addWindowListener(new WindowAdapter() { 
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                new MainMenuView();
            }
        });
        frame.add(btnLogin);
    }
    
}
