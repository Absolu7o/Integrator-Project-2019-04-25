/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brendon
 */
public class TableModel extends AbstractTableModel {

    String[] columnNames;
    Object[][] data;
    boolean enableCol = false;

    public TableModel(String[] columns, Object[][] rows, boolean enableCol) {
        this.columnNames = columns;
        this.data = rows;
        this.enableCol = enableCol;
    }

    //@Override
    public int getRowCount() {
        return data.length;
    }

    //@Override
    public int getColumnCount() {
        return columnNames.length;
    }

    //@Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    //@Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    //@Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    //@Override
    public boolean isCellEditable(int row, int col) {
        //Habilita primeira e última coluna
        if ((col == 0) || ((col == (columnNames.length - 1)) && (enableCol == true))) {
            return true;
        } else {
            return false;
        }
    }

    //@Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

}
