package gui.Dialog;


import gui.Controller.AdminListener;
import logic.Specialist;

import javax.swing.*;
import java.awt.*;

public class DialogAdminEditSpecialist extends JDialog{

    public static final String BTN_EDIT_SPECIALIST = "BTN_EDIT_SPECIALIST";
    public static final String BTN_CANCEL_EDIT_SPECIALIST = "BTN_CANCEL_EDIT_SPECIALIST";
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
    private JButton btnEditSpecialist;
    private JButton btnCancelEditSpecialist;
    private AdminListener adminListener;
    private Specialist specialist;
    private JPanel pnlCenter;
    private JPanel pnlButtons;

    public DialogAdminEditSpecialist(AdminListener adminListener, Specialist specialist) {
        this.specialist = specialist;
        this.adminListener = adminListener;
        this.setTitle("Crear especialista");
        this.setLocation(400, 200);
        this.setSize(430, 300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        pnlCenter = new JPanel();
        pnlCenter.setBorder(BorderFactory.createTitledBorder("Editar especialistas"));
        pnlCenter.setLayout(null);

        lblName = new JLabel("Nombre: ");
        lblName.setBounds(40, 30, 150, 27);
        pnlCenter.add(lblName);

        txtName = new JTextField(specialist.getName());
        txtName.setBounds(40, 55, 150, 27);
        pnlCenter.add(txtName);

        lblLastName = new JLabel("Apellido: ");
        lblLastName.setBounds(40, 80, 150, 27);
        pnlCenter.add(lblLastName);

        txtLastName = new JTextField(specialist.getLastName());
        txtLastName.setBounds(40, 105, 150, 27);
        pnlCenter.add(txtLastName);

        lblEmail = new JLabel("Correo: ");
        lblEmail.setBounds(40, 130, 150, 27);
        pnlCenter.add(lblEmail);

        txtEmail = new JTextField(specialist.getEmail());
        txtEmail.setBounds(40, 155, 150, 27);
        pnlCenter.add(txtEmail);

        lblPosition = new JLabel("Cargo: ");
        lblPosition.setBounds(220, 30, 150, 27);
        pnlCenter.add(lblPosition);

        txtPosition = new JTextField(specialist.getPosition());
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

        btnEditSpecialist = new JButton("Editar");
        btnEditSpecialist.addActionListener(adminListener);
        btnEditSpecialist.setActionCommand(BTN_EDIT_SPECIALIST);
        pnlButtons.add(btnEditSpecialist);

        btnCancelEditSpecialist = new JButton("Cancelar");
        btnCancelEditSpecialist.addActionListener(adminListener);
        btnCancelEditSpecialist.setActionCommand(BTN_CANCEL_EDIT_SPECIALIST);
        pnlButtons.add(btnCancelEditSpecialist);

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

    public JButton getBtnEditSpecialist() {
        return btnEditSpecialist;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public void setTxtLastName(JTextField txtLastName) {
        this.txtLastName = txtLastName;
    }

    public void setTxtPassword(JTextField txtPassword) {
        this.txtPassword = txtPassword;
    }

    public void setTxtPosition(JTextField txtPosition) {
        this.txtPosition = txtPosition;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public void setBtnEditSpecialist(JButton btnEditSpecialist) {
        this.btnEditSpecialist = btnEditSpecialist;
    }
}
