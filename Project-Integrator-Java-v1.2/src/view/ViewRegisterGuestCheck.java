package view;

import components.MyTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.ControllerRegisterGuestCheck;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import model.Company;
import model.Guestcheck;

public class ViewRegisterGuestCheck extends ViewMaster implements ActionListener, ListSelectionListener {

    ControllerRegisterGuestCheck controllerGuestCk = new ControllerRegisterGuestCheck();
    Guestcheck guestCheck = new Guestcheck();

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
    JButton buttonSearch = new JButton("Q");

    JTextField fieldCode = new JTextField();
    JTextField fieldBarcode = new JTextField();

    JTextField fieldNewCode = new JTextField();
    JTextField fieldNewBarcode = new JTextField();

    String[] columnNames = {"", "Código", "Cód. Barras"};
    Object[][] data = new Object[10][3];
    //DefaultTableModel tableModel = new DefaultTableModel(null, header);
    JTable table = new JTable();
    ListSelectionModel select = table.getSelectionModel();

    public ViewRegisterGuestCheck() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {

        //Code 9
        setFrameAndPane("Cadastro de Comandas", 10, 12, 30, 60);

        addComponentDefaultPane();
        setComponentActionEvent();

        frame.setVisible(true);

    }

    private void addComponentDefaultPane() {

        //Label
        labelTitle = setDefaultLabel(labelTitle, 0, 0, 1, 10, "HORIZONTAL");
        labelCode = setDefaultLabel(labelCode, 2, 0, 1, 1, "HORIZONTAL");
        labelBarcode = setDefaultLabel(labelBarcode, 2, 2, 1, 2, "HORIZONTAL");

        //TextField
        fieldCode = setDefaultField(fieldCode, 2, 1, 1, 1, "HORIZONTAL");
        fieldBarcode = setDefaultField(fieldBarcode, 2, 4, 1, 1, "HORIZONTAL");

        //Botões
        buttonInsert = setDefaultButton(buttonInsert, 1, 0, 1, 3, "BOTH");
        buttonDelete = setDefaultButton(buttonDelete, 1, 3, 1, 3, "BOTH");
        buttonEdit = setDefaultButton(buttonEdit, 1, 6, 1, 3, "BOTH");
        buttonSearch = setDefaultButton(buttonSearch, 2, 7, 1, 1, "BOTH");

        //Table
        table = setDefaultTableList(table, 3, 0, 6, 8, "BOTH");

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
        controllerGuestCk.insertGuestCheck(new Guestcheck(0, new Company(1), fieldBarcode.getText(), null));
        closeNewFrame();
    }

    private void updateGuestCheck() {
        controllerGuestCk.updateGuestCheck(guestCheck);
    }

    private void loadTable() {
        List<Guestcheck> guestchecks = controllerGuestCk.listAllGuestCheck();
        guestchecks.forEach((guestcheck) -> {
            data[guestcheck.getCode()][0] = new Boolean(false);
            data[guestcheck.getCode()][1] = guestcheck.getCode();
            data[guestcheck.getCode()][2] = guestcheck.getBarcode();
        });
        System.out.println("1");
        table.setModel(new MyTableModel(columnNames, data));
        System.out.println("2");

    }

    class MyTableModel extends AbstractTableModel {

        private String[] columnNames;
        private Object[][] data;

        public MyTableModel(String[] columnNames,Object[][] data) {
            this.columnNames=columnNames;
            this.data=data;
        }
        
        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            System.out.println("Setting value at " + row + "," + col
                    + " to " + value
                    + " (an instance of "
                    + value.getClass() + ")");

            data[row][col] = value;
            fireTableCellUpdated(row, col);

            System.out.println("New value of data:");
            printDebugData();

        }

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i = 0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j = 0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }

}
