package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewRegisterAdditional extends ViewMaster implements ActionListener {

    public ViewRegisterAdditional() {
        createAndShowView();
    }

    private void createAndShowView() {

        //Code 6
        setFrameAndPane("Cadastro de Adicionais", 10, 10);

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
