
package UAS.View;

import javax.swing.*;
import UAS.Model.User;
import UAS.Controller.Controller;
import UAS.Controller.Sql;
import UAS.Model.CategoryUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MenuRegister {
    
    Controller controller = new Controller();
    Sql sql = new Sql();
    
    public MenuRegister() {

        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Registrasi");
        
        //Username
        JLabel labelUsername = new JLabel("Input Username");
        labelUsername.setBounds(20, 20, 150, 25);
        JTextField inputUsername = new JTextField();
        inputUsername.setBounds(180, 20, 150, 25);
        frame.add(labelUsername);
        frame.add(inputUsername);
        
        //Password
        JLabel labelPass = new JLabel("Input Password");
        labelPass.setBounds(20, 50, 150, 25);
        JPasswordField inputPass = new JPasswordField();
        inputPass.setBounds(180, 50, 150, 25);
        frame.add(labelPass);
        frame.add(inputPass);
        
        //Email
        JLabel labelEmail = new JLabel("Input Email");
        labelEmail.setBounds(20, 80, 150, 25);
        JTextField inputEmail = new JTextField();
        inputEmail.setBounds(180, 80, 150, 25);
        frame.add(labelEmail);
        frame.add(inputEmail);
        
        //Kelamin
        JLabel labelKelamin = new JLabel();
        labelKelamin.setText("Jenis Kelamin: ");
        labelKelamin.setBounds(20, 110, 125, 25);
        JRadioButton rPria = new JRadioButton("Pria");
        JRadioButton rWanita = new JRadioButton("Wanita");
        rPria.setBounds(180, 110, 60, 25);
        rWanita.setBounds(250, 110, 70, 25);
        ButtonGroup radioKelamin = new ButtonGroup();
        radioKelamin.add(rPria);
        radioKelamin.add(rWanita);
        frame.add(labelKelamin);
        frame.add(rPria);
        frame.add(rWanita);
        
        //Kategori
        ArrayList<CategoryUser> listCategory = new ArrayList<>(sql.getCategoryUser());
        String arrCategory[] = new String[listCategory.size()];
        for(int i = 0; i < listCategory.size(); i++){
            arrCategory[i] =  listCategory.get(i).getCategoryName();
        }
        JLabel labelKategori = new JLabel("Pilih kategori user");
        labelKategori.setBounds(20, 140, 150, 25);
        JComboBox comboBoxCategory = new JComboBox(arrCategory);
        comboBoxCategory.setBounds(180, 140, 150, 25);
        frame.add(labelKategori);
        frame.add(comboBoxCategory);
        
        JButton btnInsert = new JButton("Registrasi");
        btnInsert.setBounds(250, 200, 100, 50);
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                int id = sql.getIdUser();
                String username = inputUsername.getText();
                String password = new String(inputPass.getPassword());
                String email = inputEmail.getText();
                int idKategori = comboBoxCategory.getSelectedIndex() + 1;
                String kategori = (String) comboBoxCategory.getItemAt(comboBoxCategory.getSelectedIndex());
                String gender = "";
                if(rPria.isSelected()){
                    gender = "Pria";
                }
                if(rWanita.isSelected()){
                    gender = "Wanita";
                }
                
                User user = new User(id,password,username,email,gender,new CategoryUser(idKategori,kategori),0);
                if(sql.insertNewUser(user) == true){
                    JOptionPane.showMessageDialog(null, "Registrasi Berhasil", 
                               "Message", JOptionPane.INFORMATION_MESSAGE); 
                } else {
                    JOptionPane.showMessageDialog(null, "Registrasi Gagal!", 
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
