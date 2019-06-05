package view;

import components.TableModel;
import controller.ControllerRegisterGuestCheck;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Guestcheck;

public class ViewCashRegister extends ViewMaster implements ActionListener {

    int count = 0;

    JLabel labelTitle = new JLabel("Caixa");
    JLabel labelBarcode = new JLabel("Comanda");

    JTextField fieldBarcode = new JTextField();

    JTable table = new JTable();
    String[] columns = {"", "Item", "Valor"};
    Object[][] rows;

    public ViewCashRegister() {
        createAndShowView();
    }

    private void createAndShowView() {

        //Code 1
        setFrameAndPane("Caixa", 10, 10, 30, 60);

        addComponentDefaultPane();
        setComponentActionEvent();

        frame.setVisible(true);

    }

    private void addComponentDefaultPane() {
        loadTable();
        //table = setDefaultTableList(table, 3, 0, 6, 8, "BOTH");
    }

    public void setComponentActionEvent() {

    }

    private void loadTable() {
        ControllerRegisterGuestCheck controllerGuestCk = new ControllerRegisterGuestCheck();
        List<Guestcheck> guestchecks = controllerGuestCk.listAllGuestCheck();
        rows = new Object[guestchecks.size()][columns.length];
        guestchecks.forEach((guestcheck) -> {
            rows[count][0] = new Boolean(false);
            rows[count][1] = guestcheck.getBarcode();
            rows[count][2] = "SIM";
            count = count + 1;
        });

        table = new JTable(new TableModel(columns, rows, false));
    
    }

    public void actionPerformed(ActionEvent e) {

    }
}
