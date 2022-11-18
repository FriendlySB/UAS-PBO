package UAS.View;

import javax.swing.*;
import UAS.Model.User;
import UAS.Controller.Controller;
import UAS.Controller.Sql;
import UAS.Model.CategoryUser;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class MenuLihatDataPengguna {

    Controller controller = new Controller();
    Sql sql = new Sql();
    
    public MenuLihatDataPengguna() {
        JFrame frame = new JFrame();
        frame.setSize(1000,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Menu Lihat Data Pengguna");
        
        //Tabel Transaksi
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("ID User");
        tableModel.addColumn("Username");
        tableModel.addColumn("Password");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Email");
        tableModel.addColumn("Kategori User");
        tableModel.addColumn("Followers");
        
        JScrollPane scrollPane = new JScrollPane(table);
        ArrayList<User> listUser = new ArrayList<>(sql.getAllUser());
        for(int i = 0; i < listUser.size(); i++){
            tableModel.addRow(controller.buatTabel(listUser.get(i)));
        }
        frame.add(scrollPane);
        frame.addWindowListener(new WindowAdapter() { 
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                new MainMenuView();
            }
        });
    }
}
