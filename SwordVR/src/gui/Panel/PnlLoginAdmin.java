package gui.Panel;

import Persistence.ConnectionTableAdmin;
import gui.Dialog.DialogLogin;
import gui.Frame.FrameAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlLoginAdmin extends JPanel{

    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblPass;
    private JPasswordField txtPass;
    private JButton btnLogin;
    private ConnectionTableAdmin tableAdmin;

    public PnlLoginAdmin(DialogLogin dialogLogin){
        this.setLayout(null);

        tableAdmin = new ConnectionTableAdmin();

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
                    FrameAdmin frameAdmin = new FrameAdmin(tableAdmin);
                    frameAdmin.setVisible(true);
                    dialogLogin.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario o contrasenia no validos");
                }
            }
        });
        btnLogin.setBounds((DialogLogin.WIDTH / 2) - 50, 170, 75, 27);
        this.add(btnLogin);
    }

    public boolean validateLogin(){
        boolean flag = false;
        if(tableAdmin.searchAdmin(txtName.getText()) && tableAdmin.searchPass(txtPass.getText())){
            flag = true;
        }
        return flag;
    }
}
