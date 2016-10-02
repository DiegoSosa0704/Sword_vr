package gui.Controller;

import Persistence.ConnectionTableAdmin;
import gui.Dialog.DialogAdminEditSpecialist;
import gui.Frame.FrameAdmin;
import gui.Dialog.DialogAdminCreate;
import logic.Specialist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by SOSA-PC on 30/09/2016.
 */
public class AdminListener implements ActionListener {

    private FrameAdmin frameAdmin;
    private ConnectionTableAdmin tableAdmin;
    private DialogAdminCreate adminCreate;
    private DialogAdminEditSpecialist editSpecialist;

    public AdminListener(FrameAdmin frameAdmin, ConnectionTableAdmin tableAdmin) {
        this.frameAdmin = frameAdmin;
        this.tableAdmin = tableAdmin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case FrameAdmin.BTN_SHOW_CREATE_SPECIALIST:
                showDialogCreateSpecialist();
                break;

            case DialogAdminCreate.BTN_ADD_SPECIALIST:
                tableAdmin.addSpecialist(adminCreate.getTxtName().getText(),
                        adminCreate.getTxtLastName().getText(), adminCreate.getTxtPassword().getText(),
                        adminCreate.getTxtPosition().getText(), adminCreate.getTxtEmail().getText());
                adminCreate.getTxtName().setText("");
                adminCreate.getTxtLastName().setText("");
                adminCreate.getTxtPosition().setText("");
                adminCreate.getTxtPassword().setText("");
                adminCreate.getTxtEmail().setText("");
                frameAdmin.createTable(tableAdmin.getQuerySpecialists());
                break;

            case FrameAdmin.BTN_DELETE_SPECIALIST:
                frameAdmin.deleteSpecialist(tableAdmin.getQuerySpecialists());
                frameAdmin.createTable(tableAdmin.getQuerySpecialists());
                break;

            case FrameAdmin.BTN_SHOW_EDIT_SPECIALIST:
                frameAdmin.editSpecialist(tableAdmin.getQuerySpecialists());
                break;

            case DialogAdminEditSpecialist.BTN_EDIT_SPECIALIST:
                tableAdmin.updateSpecialist(Integer.parseInt(editSpecialist.getSpecialist().getId()), editSpecialist.getTxtName().getText(), editSpecialist.getTxtLastName().getText(), editSpecialist.getTxtPosition().getText(), editSpecialist.getTxtPassword().getText(), editSpecialist.getTxtEmail().getText());
                frameAdmin.createTable(tableAdmin.getQuerySpecialists());
                editSpecialist.setVisible(false);
                break;

            case DialogAdminEditSpecialist.BTN_CANCEL_EDIT_SPECIALIST:
                editSpecialist.setVisible(false);
                break;

            case DialogAdminCreate.BTN_CANCEL_CREATE_SPECIALIST:
                adminCreate.setVisible(false);
                break;
        }

    }

    public void showDialogCreateSpecialist() {
        adminCreate = new DialogAdminCreate(this);
        adminCreate.setVisible(true);
    }

    public void showDialogEditSpecialist(Specialist specialist) {
        editSpecialist = new DialogAdminEditSpecialist(this, specialist);
        editSpecialist.setVisible(true);
    }

}
