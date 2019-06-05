package view;

import components.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.ControllerRegisterGuestCheck;
import java.util.List;
import model.Company;
import model.Guestcheck;
import components.TableModel;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.JTableHeader;

public class ViewRegisterGuestCheck extends ViewMaster implements ActionListener {

    ControllerRegisterGuestCheck controllerGuestCk = new ControllerRegisterGuestCheck();
    Guestcheck guestCheck = new Guestcheck();
    
    ImageIcon searchIcon = new ImageIcon(getClass().getResource("/icon/searchIcon.png"));
    
    JLabel labelTitle = new JLabel("Cadastro de Comandas");
    JLabel labelCode = new JLabel("Código");
    JLabel labelBarcode = new JLabel("Cód. de Barras");

    JLabel labelNewCode = new JLabel("Código");
    JLabel labelNewBarcode = new JLabel("Cód. de Barras");

    JButton buttonInsert = new JButton("Adicionar");
    JButton buttonConfirmIns = new JButton("Confirmar");
    JButton buttonConfirmUpd = new JButton("Confirmar");
    JButton buttonCancel = new JButton("Cancelar");
    JButton buttonDelete = new JButton("Excluir");
    JButton buttonEdit = new JButton("Alterar");
    JButton buttonSearch = new JButton(searchIcon);
    
    JTextField fieldCode = new JTextField();
    JTextField fieldBarcode = new JTextField();

    JTextField fieldNewCode = new JTextField();
    JTextField fieldNewBarcode = new JTextField();

    JTable table = new JTable();
    String[] columns = {"", "Código", "Cód. Barras"};
    Object[][] rows;

    int count = 0;

    public ViewRegisterGuestCheck() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {

        //Code 9
        searchIcon.setDescription("BUSCAR");
    
        setFrameAndPane("Cadastro de Comandas", 10,10, 20, 64);

        addComponentDefaultPane();
        setComponentActionEvent();

        frame.setVisible(true);

    }

    private void addComponentDefaultPane() {

        //Linha 0
        labelCode = setDefaultLabel(labelCode, 0, 0, 1, 1, "HORIZONTAL");
        fieldCode = setDefaultField(fieldCode, 0, 1, 1, 2, "HORIZONTAL");
        buttonInsert = setDefaultButton(buttonInsert, 0, 6, 1, 1, "BOTH");

        //Linha 1
        labelBarcode = setDefaultLabel(labelBarcode, 1, 0, 1, 2, "HORIZONTAL");
        fieldBarcode = setDefaultField(fieldBarcode, 1, 2, 1, 3, "HORIZONTAL");
        buttonSearch = setDefaultButton(buttonSearch, 1, 5, 1, 1, "BOTH");
        buttonDelete = setDefaultButton(buttonDelete, 1, 6, 1, 1, "BOTH");
        
        //Linha 2
        table = setDefaultTableList(table, 2, 0, 8, 7, "BOTH");
        
        //buttonEdit = setDefaultButton(buttonEdit, 10, 0, 1, 3, "BOTH");
        

    }

    private void setComponentActionEvent() {

        buttonInsert.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonEdit.addActionListener(this);
        buttonSearch.addActionListener(this);

        //select.addListSelectionListener(this);
    }

    private void loadTable() {

        List<Guestcheck> guestchecks;

        guestchecks = controllerGuestCk.listAllGuestCheck();
        rows = new Object[guestchecks.size()][columns.length];
        count = 0;

        guestchecks.forEach((guestcheck) -> {
            rows[count][0] = new Boolean(false);
            rows[count][1] = guestcheck.getCode();
            rows[count][2] = guestcheck.getBarcode();
            count = count + 1;
        });

        table.setModel(new TableModel(columns, rows, false));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Default Frame
        if (e.getSource() == buttonInsert) {
            addFrameInsert();
        } else if (e.getSource() == buttonDelete) {
            System.out.println("Excluir");
        } else if (e.getSource() == buttonEdit) {
            addFrameUpdate();
        } else if (e.getSource() == buttonSearch) {
            loadTable();
        } else //New Frame
        if (e.getSource() == buttonConfirmIns) {
            insertGuestCheck();
        } else if (e.getSource() == buttonConfirmUpd) {
            updateGuestCheck();
        } else if (e.getSource() == buttonCancel) {
            closeNewFrame();
        }
    }

    private void addFrameInsert() {

        addAndSetNewFrameAndPane("Adicionar Comanda", 4, 4, 30, 60);

        labelNewBarcode = setCustomLabel(labelNewBarcode, 0, 0, 1, 4, "HORIZONTAL");
        fieldNewBarcode = setCustomField(fieldNewBarcode, 1, 0, 1, 4, "HORIZONTAL");

        buttonConfirmIns = setCustomButton(buttonConfirmIns, 2, 0, 1, 2, "BOTH");
        buttonCancel = setCustomButton(buttonCancel, 2, 2, 1, 2, "BOTH");

        buttonConfirmIns.addActionListener(this);
        buttonCancel.addActionListener(this);

    }

    private void addFrameUpdate() {

        addAndSetNewFrameAndPane("Editar Comanda", 4, 4, 30, 60);

        guestCheck = controllerGuestCk.selectGuestCheck(0);
        fieldNewCode.setText(String.valueOf(guestCheck.getCode()));
        fieldNewBarcode.setText(guestCheck.getBarcode());
        System.out.println(guestCheck.getBarcode());

        labelNewCode = setCustomLabel(labelNewCode, 0, 0, 1, 2, "HORIZONTAL");
        fieldNewCode = setCustomField(fieldNewCode, 0, 2, 1, 2, "HORIZONTAL");

        labelNewBarcode = setCustomLabel(labelNewBarcode, 1, 0, 1, 4, "HORIZONTAL");
        fieldNewBarcode = setCustomField(fieldNewBarcode, 2, 0, 1, 4, "HORIZONTAL");

        buttonConfirmUpd = setCustomButton(buttonConfirmUpd, 3, 0, 1, 2, "BOTH");
        buttonCancel = setCustomButton(buttonCancel, 3, 2, 1, 2, "BOTH");

        buttonConfirmUpd.addActionListener(this);
        buttonCancel.addActionListener(this);

    }

    private void insertGuestCheck() {
        controllerGuestCk.insertGuestCheck(new Guestcheck(0, new Company(1), fieldNewBarcode.getText(), null));
        closeNewFrame();
    }

    private void updateGuestCheck() {
        controllerGuestCk.updateGuestCheck(guestCheck);
    }

}
