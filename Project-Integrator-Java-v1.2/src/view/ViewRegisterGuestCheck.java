package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.ControllerRegisterGuestCheck;

public class ViewRegisterGuestCheck extends ViewMaster implements ActionListener {

    ControllerRegisterGuestCheck controllerGuestCk = new ControllerRegisterGuestCheck();

    JLabel labelTitle = new JLabel("Cadastro de Comandas");
    JLabel labelCode = new JLabel("Código");
    JLabel labelDescription = new JLabel("Descrição");
    JLabel labelActive = new JLabel("Ativo?");

    JButton buttonInsert = new JButton("Adicionar");
    JButton buttonDelete = new JButton("Excluir");
    JButton buttonEdit = new JButton("Alterar");
    JButton buttonSearch = new JButton("Q");

    JTextField fieldCode = new JTextField();
    JTextField fieldBarcode = new JTextField();

    JTable table = new JTable(1, 3);

    String[] item = {"SIM", "NÃO"};
    JComboBox comboboxActive = new JComboBox(item);

    public ViewRegisterGuestCheck() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {

        //Code 9
        setFrameAndPane("Cadastro de Comandas", 10, 12);

        addComponentDefaultPane();
        setComponentActionEvent();

        frame.setVisible(true);

    }

    private void addComponentDefaultPane() {

        //Label
        labelTitle = setDefaultLabel(labelTitle, 0, 0, 1, 10, "HORIZONTAL");
        labelCode = setDefaultLabel(labelCode, 2, 0, 1, 1, "HORIZONTAL");
        labelDescription = setDefaultLabel(labelDescription, 2, 2, 1, 2, "HORIZONTAL");
        labelActive = setDefaultLabel(labelActive, 2, 5, 1, 1, "HORIZONTAL");

        //TextField
        fieldCode = setDefaultField(fieldCode, 2, 1, 1, 1, "HORIZONTAL");
        fieldBarcode = setDefaultField(fieldBarcode, 2, 4, 1, 1, "HORIZONTAL");

        //Combobox
        comboboxActive = setDefaultCombobox(comboboxActive, 2, 6, 1, 1, "HORIZONTAL");

        //Botões
        buttonInsert = setDefaultButton(buttonInsert, 1, 0, 1, 3, "BOTH");
        buttonDelete = setDefaultButton(buttonDelete, 1, 3, 1, 3, "BOTH");
        buttonEdit = setDefaultButton(buttonEdit, 1, 6, 1, 3, "BOTH");
        buttonSearch = setDefaultButton(buttonSearch, 2, 7, 1, 1, "BOTH");

        //Table
        table = setDefaultTableList(table, 3, 0, 6, 8, "BOTH");

    }

    private void setComponentActionEvent() {

        buttonInsert.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonEdit.addActionListener(this);
        buttonSearch.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonInsert) {
            System.out.println("Inserir");
        } else if (e.getSource() == buttonDelete) {
            System.out.println("Excluir");
        } else if (e.getSource() == buttonEdit) {
            System.out.println("Editar");
        } else if (e.getSource() == buttonSearch) {
            System.out.println("Pesquisar");
        }
    }

}
