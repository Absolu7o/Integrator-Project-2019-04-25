package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControllerLogin;
import javax.swing.JPasswordField;

public class ViewLogin extends ViewMaster implements ActionListener {

    ControllerLogin controllerLogin = new ControllerLogin();
    JButton buttonLogin = new JButton("Login");
    JLabel labelLogin = new JLabel("Login");
    JLabel labelPassword = new JLabel("Senha");
    JTextField fieldLogin = new JTextField();
    JPasswordField fieldPassword = new JPasswordField();

    public ViewLogin() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {

        //Code 3
        setFrameAndPane("Login", 3, 3);

        addComponentDefaultPane();
        setComponentActionEvent();

        frame.setVisible(true);

    }

    private void addComponentDefaultPane() {

        //Label
        labelLogin = setDefaultLabel(labelLogin, 0, 0, 1, 1, "HORIZONTAL");
        labelPassword = setDefaultLabel(labelPassword, 1, 0, 1, 1, "HORIZONTAL");

        //TextField
        fieldLogin = setDefaultField(fieldLogin, 0, 1, 1, 2, "HORIZONTAL");
        fieldPassword = setDefaultPasswordField(fieldPassword, 1, 1, 1, 2, "HORIZONTAL");

        //Botões
        buttonLogin = setDefaultButton(buttonLogin, 2, 0, 1, 3, "BOTH");

    }

    private void setComponentActionEvent() {

        buttonLogin.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonLogin) {
            controllerLogin.executeLogin(fieldLogin.getText(), fieldPassword.getText());
        }

    }

}
