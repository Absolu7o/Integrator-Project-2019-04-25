package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewDeliveryRequest extends ViewMaster implements ActionListener {

    public ViewDeliveryRequest() {
        createAndShowView();
    }

    private void createAndShowView() {

        //Code 2
        setFrameAndPane("Entrega de Pedidos", 10, 10);

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
