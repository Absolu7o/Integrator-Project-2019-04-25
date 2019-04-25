package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewRegisterComboItem extends ViewMaster implements ActionListener {

    public ViewRegisterComboItem() {
        createAndShowView();
    }

    private void createAndShowView() {

        //Code 8
        setFrameAndPane("Cadastro de Combos", 10, 10);

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
