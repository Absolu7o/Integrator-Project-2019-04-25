package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCashRegister extends ViewMaster implements ActionListener {

    public ViewCashRegister() {
        createAndShowView();
    }

    private void createAndShowView() {

        //Code 1
        setFrameAndPane("Caixa", 10, 10);

        addComponentDefaultPane();
        setComponentActionEvent();

        frame.setVisible(true);

    }

    private void addComponentDefaultPane() {

    }

    private void setComponentActionEvent() {

    }

    public void actionPerformed(ActionEvent e) {

    }

}
