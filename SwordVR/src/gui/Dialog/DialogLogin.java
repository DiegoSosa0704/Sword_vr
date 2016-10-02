package gui.Dialog;

import gui.Panel.PnlLoginAdmin;
import gui.Panel.PnlLoginUser;

import javax.swing.*;
import java.awt.*;

/**
 * Created by SOSA-PC on 30/09/2016.
 */
public class DialogLogin extends JDialog {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 350;
    private JTabbedPane tabbedPane;
    private PnlLoginAdmin loginAdmin;
    private PnlLoginUser loginUser;

    public DialogLogin() {
        this.setTitle("Login");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocation(400, 200);
        this.setLayout(new BorderLayout());
        this.setSize(WIDTH, HEIGHT);

        tabbedPane = new JTabbedPane();

        loginAdmin = new PnlLoginAdmin(this);
        tabbedPane.addTab("Admin", loginAdmin);

        loginUser = new PnlLoginUser();
        tabbedPane.addTab("User", loginUser);

        this.add(tabbedPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        DialogLogin dialogLogin = new DialogLogin();
        dialogLogin.setVisible(true);
    }

}
