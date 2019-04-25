package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPreparationRequest extends ViewMaster implements ActionListener {

    public ViewPreparationRequest() {
        createAndShowView();
    }

    private void createAndShowView() {

        //Code 5
        setFrameAndPane("Preparação de Pedidos", 10, 10);

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
