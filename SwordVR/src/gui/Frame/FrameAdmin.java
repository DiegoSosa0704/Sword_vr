package gui.Frame;

import Persistence.ConnectionTableAdmin;
import gui.Controller.AdminListener;
import logic.Specialist;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by SOSA-PC on 30/09/2016.
 */
public class FrameAdmin extends JFrame {

    public static final String BTN_SHOW_CREATE_SPECIALIST = "SHOW_CREATE_SPECIALIST";
    public static final String BTN_DELETE_SPECIALIST = "DELETE_SPECIALIST";
    public static final String BTN_SHOW_EDIT_SPECIALIST = "SHOW_EDIT_SPECIALIST";
    private JButton btnEdit;
    private JTabbedPane tabbedPane;
    private JPanel pnlListSpecialists;
    private AdminListener adminListener;
    private JToolBar toolBar;
    private JButton btnCreate;
    private JButton btnDelete;
    private ConnectionTableAdmin tableAdmin;

    private JScrollPane scrollListSpecialists;
    private JTable tableSpecialists;
    private DefaultTableModel tableModelSpecialists;

    public FrameAdmin(ConnectionTableAdmin tableAdmin) {
        this.tableAdmin = tableAdmin;
        this.setTitle("Administrador");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        adminListener = new AdminListener(this, tableAdmin);

        toolBar = new JToolBar();

        btnCreate = new JButton("Crear");
        btnCreate.addActionListener(adminListener);
        btnCreate.setActionCommand(BTN_SHOW_CREATE_SPECIALIST);
        toolBar.add(btnCreate);

        btnDelete = new JButton("Borrar");
        btnDelete.addActionListener(adminListener);
        btnDelete.setActionCommand(BTN_DELETE_SPECIALIST);
        toolBar.add(btnDelete);

        btnEdit = new JButton("Editar");
        btnEdit.addActionListener(adminListener);
        btnEdit.setActionCommand(BTN_SHOW_EDIT_SPECIALIST);
        toolBar.add(btnEdit);

        this.add(toolBar, BorderLayout.NORTH);

        pnlListSpecialists = new JPanel();
        pnlListSpecialists.setLayout(new FlowLayout());

        tableSpecialists = new JTable();
        scrollListSpecialists = new JScrollPane(tableSpecialists);
        scrollListSpecialists.setBorder(BorderFactory.createTitledBorder("Lista Especialistas"));
        pnlListSpecialists.add(scrollListSpecialists);
        this.add(pnlListSpecialists, BorderLayout.CENTER);

        createTable(tableAdmin.getQuerySpecialists());

    }

    public void deleteSpecialist(ArrayList<Specialist> listSpecialists){
        if(tableSpecialists.getSelectedRows() != null){
            for (int i = 0; i < listSpecialists.size(); i++){
                for (int j = 0; j < tableSpecialists.getSelectedRows().length; j++){
                    if(i == tableSpecialists.getSelectedRows()[j]){
                        if (JOptionPane.showConfirmDialog(null, "¿Se encuentra seguro de que desea eliminar a " + "'" + listSpecialists.get(i).getName() + "'" + "?") == JOptionPane.YES_OPTION){
                            int id_specialist = Integer.parseInt(listSpecialists.get(i).getId());
                            tableAdmin.deleteSpecialist(id_specialist);
                        }
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun usuario.");
        }
    }

    public void editSpecialist(ArrayList<Specialist> listSpecialists){
        for (int i = 0; i < listSpecialists.size(); i++){
            for (int j = 0; j < tableSpecialists.getSelectedRows().length; j++){
                if(i == tableSpecialists.getSelectedRows()[j]){
                    if (JOptionPane.showConfirmDialog(null, "¿Desea editar el usuario " + "'" + listSpecialists.get(i).getName() + "'" + "?") == JOptionPane.YES_OPTION){
                        adminListener.showDialogEditSpecialist(listSpecialists.get(i));
                    }
                }
            }
        }
    }

    public void createTable(ArrayList<Specialist> listSpecialist) {

        tableModelSpecialists = new DefaultTableModel();
        tableModelSpecialists.setColumnIdentifiers(new String[]{"Id", "Nombre", "Apellido", "Cargo", "Correo"});
        tableModelSpecialists.setRowCount(listSpecialist.size());

        for (int i = 0; i < listSpecialist.size(); i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    tableModelSpecialists.setValueAt(listSpecialist.get(i).getId(), i, j);
                } else if (j == 1) {
                    tableModelSpecialists.setValueAt(listSpecialist.get(i).getName(), i, j);
                } else if (j == 2) {
                    tableModelSpecialists.setValueAt(listSpecialist.get(i).getLastName(), i, j);
                } else if (j == 3) {
                    tableModelSpecialists.setValueAt(listSpecialist.get(i).getPosition(), i, j);
                } else if (j == 4) {
                    tableModelSpecialists.setValueAt(listSpecialist.get(i).getEmail(), i, j);
                }
            }
        }
        tableSpecialists.setModel(tableModelSpecialists);
    }

    public JPanel getPnlListSpecialists() {
        return pnlListSpecialists;
    }

    public AdminListener getAdminListener() {
        return adminListener;
    }

    public void setPnlListSpecialists(JPanel pnlListSpecialists) {
        this.pnlListSpecialists = pnlListSpecialists;
    }

    public void setAdminListener(AdminListener adminListener) {
        this.adminListener = adminListener;
    }

}
