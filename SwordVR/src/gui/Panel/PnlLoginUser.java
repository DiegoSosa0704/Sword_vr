package gui.Panel;

import Persistence.ConnectionTableSpecialist;
import gui.Dialog.DialogLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlLoginUser extends JPanel{

    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblPass;
    private JPasswordField txtPass;
    private JButton btnLogin;
    private ConnectionTableSpecialist tableSpecialist;

    public PnlLoginUser(){
        this.setLayout(null);

        lblName = new JLabel("Nombre: ");
        lblName.setBounds((DialogLogin.WIDTH / 2) - 90, 40, 150, 27);
        this.add(lblName);

        txtName = new JTextField();
        txtName.setBounds((DialogLogin.WIDTH / 2) - 90, 65, 150, 27);
        this.add(txtName);

        lblPass = new JLabel("Contraseña: ");
        lblPass.setBounds((DialogLogin.WIDTH / 2) - 90, 100, 150, 27);
        this.add(lblPass);

        txtPass = new JPasswordField();
        txtPass.setBounds((DialogLogin.WIDTH / 2) - 90, 125, 150, 27);
        this.add(txtPass);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validateLogin()){
                    JOptionPane.showMessageDialog(null, "Entro");
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario o contrasenia no validos");
                }
            }
        });
        btnLogin.setBounds((DialogLogin.WIDTH / 2) - 50, 170, 75, 27);
        this.add(btnLogin);
    }

    public boolean validateLogin(){
        tableSpecialist = new ConnectionTableSpecialist();
        boolean flag = false;
        if(tableSpecialist.searchUser(txtName.getText()) && tableSpecialist.searchPass(txtPass.getText())){
            flag = true;
        }
        return flag;
    }

}
