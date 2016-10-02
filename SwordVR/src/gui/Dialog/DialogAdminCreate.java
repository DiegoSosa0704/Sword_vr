package gui.Dialog;

import gui.Controller.AdminListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by SOSA-PC on 30/09/2016.
 */
public class DialogAdminCreate extends JDialog {

    public static final String BTN_ADD_SPECIALIST = "BTN_ADD_SPECIALIST";
    public static final String BTN_CANCEL_CREATE_SPECIALIST = "BTN_CANCEL_CREATE_SPECIALIST";
    private final JButton btnCancelCreateSpecialist;
    private JTextField txtName;
    private JTextField txtLastName;
    private JTextField txtPassword;
    private JTextField txtPosition;
    private JTextField txtEmail;
    private JLabel lblName;
    private JLabel lblLastName;
    private JLabel lblPassword;
    private JLabel lblPosition;
    private JLabel lblEmail;
    private JButton btnCreateSpecialist;
    private AdminListener adminListener;
    private JPanel pnlCenter;
    private JPanel pnlButtons;


    public DialogAdminCreate(AdminListener adminListener) {
        this.adminListener = adminListener;
        this.setTitle("Crear especialista");
        this.setLocation(400, 200);
        this.setSize(430, 300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        pnlCenter = new JPanel();
        pnlCenter.setBorder(BorderFactory.createTitledBorder("Creacion de especialistas"));
        pnlCenter.setLayout(null);

        lblName = new JLabel("Nombre: ");
        lblName.setBounds(40, 30, 150, 27);
        pnlCenter.add(lblName);

        txtName = new JTextField();
        txtName.setBounds(40, 55, 150, 27);
        pnlCenter.add(txtName);

        lblLastName = new JLabel("Apellido: ");
        lblLastName.setBounds(40, 80, 150, 27);
        pnlCenter.add(lblLastName);

        txtLastName = new JTextField();
        txtLastName.setBounds(40, 105, 150, 27);
        pnlCenter.add(txtLastName);

        lblEmail = new JLabel("Correo: ");
        lblEmail.setBounds(40, 130, 150, 27);
        pnlCenter.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(40, 155, 150, 27);
        pnlCenter.add(txtEmail);

        lblPosition = new JLabel("Cargo: ");
        lblPosition.setBounds(220, 30, 150, 27);
        pnlCenter.add(lblPosition);

        txtPosition = new JTextField();
        txtPosition.setBounds(220, 55, 150, 27);
        pnlCenter.add(txtPosition);

        lblPassword = new JLabel("Contrasenia:");
        lblPassword.setBounds(220, 80, 150, 27);
        pnlCenter.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(220, 105, 150, 27);
        pnlCenter.add(txtPassword);



        this.add(pnlCenter, BorderLayout.CENTER);

        pnlButtons = new JPanel();
        pnlButtons.setLayout(new FlowLayout());

        btnCreateSpecialist = new JButton("Crear");
        btnCreateSpecialist.addActionListener(adminListener);
        btnCreateSpecialist.setActionCommand(BTN_ADD_SPECIALIST);
        pnlButtons.add(btnCreateSpecialist);

        btnCancelCreateSpecialist = new JButton("Cancelar");
        btnCancelCreateSpecialist.addActionListener(adminListener);
        btnCancelCreateSpecialist.setActionCommand(BTN_CANCEL_CREATE_SPECIALIST);
        pnlButtons.add(btnCancelCreateSpecialist);

        this.add(pnlButtons, BorderLayout.SOUTH);
    }


    public JTextField getTxtName() {
        return txtName;
    }

    public JTextField getTxtLastName() {
        return txtLastName;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtPosition() {
        return txtPosition;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JButton getBtnCreateSpecialist() {
        return btnCreateSpecialist;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public void setTxtLastName(JTextField txtLastName) {
        this.txtLastName = txtLastName;
    }

    public void setTxtPassword(JPasswordField txtPassword) {
        this.txtPassword = txtPassword;
    }

    public void setTxtPosition(JTextField txtPosition) {
        this.txtPosition = txtPosition;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public void setBtnCreateSpecialist(JButton btnCreateSpecialist) {
        this.btnCreateSpecialist = btnCreateSpecialist;
    }

    public static void main(String[] args){
        DialogAdminCreate adminCreate = new DialogAdminCreate(null);
        adminCreate.setVisible(true);
    }

}
