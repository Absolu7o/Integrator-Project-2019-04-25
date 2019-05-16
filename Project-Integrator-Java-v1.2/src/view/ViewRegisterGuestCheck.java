package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.ControllerRegisterGuestCheck;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Guestcheck;
import components.MyTableModel;

public class ViewRegisterGuestCheck extends ViewMaster implements ActionListener, ListSelectionListener {

    ControllerRegisterGuestCheck controllerGuestCk = new ControllerRegisterGuestCheck();

    JLabel labelTitle = new JLabel("Cadastro de Comandas");
    JLabel labelCode = new JLabel("Código");
    JLabel labelDescription = new JLabel("Descrição");
    JLabel labelActive = new JLabel("Ativo?");

    JButton buttonInsert = new JButton("Adicionar");
    JButton buttonDelete = new JButton("Excluir");
    JButton buttonEdit = new JButton("Alterar");
    JButton buttonSearch = new JButton("Q");

    JTextField fieldCode = new JTextField();
    JTextField fieldBarcode = new JTextField();

    String[] columnNames = {"","Código", "Cód. Barras", "Ativo?"};
    Object[][] data = new Object[10][4];
    //DefaultTableModel tableModel = new DefaultTableModel(null, header);
    JTable table = new JTable();
    ListSelectionModel select = table.getSelectionModel();

    String[] item = {"SIM", "NÃO"};
    JComboBox comboboxActive = new JComboBox(item);

    public ViewRegisterGuestCheck() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {

        //Code 9
        setFrameAndPane("Cadastro de Comandas", 10, 9);

        //table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        //table.setFillsViewportHeight(true);
        //testTable();
        addComponentDefaultPane();
        setComponentActionEvent();

        frame.setVisible(true);

    }

    private void testTable() {
        //tableModel.setColumnIdentifiers(header);
//        TableColumn column = null;
//        column = table.getColumnModel().getColumn(0);
//        column.setPreferredWidth(10); //third column is bigger
//        column = table.getColumnModel().getColumn(1);
//        column.setPreferredWidth(200); //third column is bigger
//        column = table.getColumnModel().getColumn(2);
//        column.setPreferredWidth(40); //third column is bigger

    }

    private void addComponentDefaultPane() {

        //Label
        labelTitle = setDefaultLabel(labelTitle, 0, 0, 1, 10, "HORIZONTAL");
        labelCode = setDefaultLabel(labelCode, 2, 0, 1, 1, "HORIZONTAL");
        labelDescription = setDefaultLabel(labelDescription, 2, 2, 1, 2, "HORIZONTAL");
        labelActive = setDefaultLabel(labelActive, 2, 5, 1, 1, "HORIZONTAL");

        //TextField
        fieldCode = setDefaultField(fieldCode, 2, 1, 1, 1, "HORIZONTAL");
        fieldBarcode = setDefaultField(fieldBarcode, 2, 4, 1, 1, "HORIZONTAL");

        //Combobox
        comboboxActive = setDefaultCombobox(comboboxActive, 2, 6, 1, 1, "HORIZONTAL");

        //Botões
        buttonInsert = setDefaultButton(buttonInsert, 1, 0, 1, 3, "BOTH");
        buttonDelete = setDefaultButton(buttonDelete, 1, 3, 1, 3, "BOTH");
        buttonEdit = setDefaultButton(buttonEdit, 1, 6, 1, 3, "BOTH");
        buttonSearch = setDefaultButton(buttonSearch, 2, 8, 1, 1, "BOTH");

        //Table
        table = setDefaultTableList(table, 3, 0, 6, 9, "BOTH");

    }

    private void setComponentActionEvent() {

        buttonInsert.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonEdit.addActionListener(this);
        buttonSearch.addActionListener(this);

        select.addListSelectionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonInsert) {
            System.out.println("Inserir");
        } else if (e.getSource() == buttonDelete) {
            System.out.println("Excluir");
        } else if (e.getSource() == buttonEdit) {
            System.out.println("Editar");
        } else if (e.getSource() == buttonSearch) {
            List<Guestcheck> guestchecks = controllerGuestCk.findResult();
            guestchecks.forEach((guestcheck) -> {
                data[guestcheck.getCode()][0] = new Boolean(false);
                data[guestcheck.getCode()][1] = guestcheck.getCode();
                data[guestcheck.getCode()][2] = guestcheck.getBarcode();
            });
            table.setModel(new MyTableModel(columnNames,data));
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int code = 0;
        String Data = "";
        int[] row = table.getSelectedRows();
        int[] column = table.getSelectedColumns();
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < column.length; j++) {
                Data = (String) "" + table.getValueAt(row[i], column[j]);
                code = (int) table.getValueAt(row[i], table.getColumn("Código").getModelIndex());
            }
        }
        System.out.println("Code: " + code + "\tSelect > " + Data);
    }

}
