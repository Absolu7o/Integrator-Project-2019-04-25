package view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewRegisterProductCategory extends ViewMaster implements ActionListener {

    JLabel labelTitle = new JLabel("Cadastro de Categorias");
    JLabel labelCode = new JLabel("C�digo");
    JLabel labelDescription = new JLabel("Descrição");

    JButton buttonInsert = new JButton("+");
    JButton buttonDelete = new JButton("-");
    JButton buttonEdit = new JButton("E");
    JButton buttonRefresh = new JButton("R");
    JButton buttonSearch = new JButton("Q");

    JTextField fieldCode = new JTextField();
    JTextField fieldDescription = new JTextField();

    public ViewRegisterProductCategory() {
        createAndShowView();
    }

    private void createAndShowView() {

        //Code 7
        setFrameAndPane("Cadastro de Categorias", 10, 10, 30, 60);

        addComponentDefaultPane();
        setComponentActionEvent();

        frame.setVisible(true);

    }

    private void addComponentDefaultPane() {

        //Label
        labelTitle = setDefaultLabel(labelTitle, 0, 0, 1, 10, "HORIZONTAL");
        labelCode = setDefaultLabel(labelCode, 3, 0, 1, 2, "HORIZONTAL");
        labelDescription = setDefaultLabel(labelDescription, 4, 0, 1, 2, "HORIZONTAL");

        //TextField
        fieldCode = setDefaultField(fieldCode, 3, 2, 1, 1, "HORIZONTAL");
        fieldDescription = setDefaultField(fieldDescription, 4, 2, 1, 3, "HORIZONTAL");

        //Bot�es
        buttonInsert = setDefaultButton(buttonInsert, 1, 4, 1, 1, "BOTH");
        buttonDelete = setDefaultButton(buttonDelete, 1, 5, 1, 1, "BOTH");
        buttonEdit = setDefaultButton(buttonEdit, 1, 6, 1, 1, "BOTH");
        buttonRefresh = setDefaultButton(buttonRefresh, 1, 9, 1, 1, "BOTH");
        buttonSearch = setDefaultButton(buttonSearch, 3, 3, 1, 1, "BOTH");

    }

    private void setComponentActionEvent() {

        buttonInsert.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonEdit.addActionListener(this);
        buttonRefresh.addActionListener(this);
        buttonSearch.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonInsert) {
            System.out.println("Inserir");
        } else if (e.getSource() == buttonDelete) {
            System.out.println("Excluir");
        } else if (e.getSource() == buttonEdit) {
            System.out.println("Editar");
        } else if (e.getSource() == buttonRefresh) {
            System.out.println("Atualizar");
        } else if (e.getSource() == buttonSearch) {
            System.out.println("Pesquisar");
        }
    }

}
