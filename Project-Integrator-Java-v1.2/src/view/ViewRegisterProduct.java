package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewRegisterProduct extends ViewMaster implements ActionListener {

    public ViewRegisterProduct() {
        createAndShowView();
    }

    private void createAndShowView() {

        //Code 10
        setFrameAndPane("Cadastro de Itens", 10, 10, 30, 60);

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
