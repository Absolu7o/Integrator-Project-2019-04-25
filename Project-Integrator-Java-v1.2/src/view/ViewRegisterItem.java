package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewRegisterItem extends ViewMaster implements ActionListener {

    public ViewRegisterItem() {
        createAndShowView();
    }

    private void createAndShowView() {

        //Code 10
        setFrameAndPane("Cadastro de Itens", 10, 10);

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
