package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewRegisterTableList extends ViewMaster implements ActionListener {

    JLabel labelTitle = new JLabel("Cadastro de Mesas");
    JLabel labelCode = new JLabel("Código");
    JLabel labelDescription = new JLabel("Descrição");
    JLabel labelActive = new JLabel("Ativo?");

    JButton buttonFirst = new JButton("|<");
    JButton buttonPrevious = new JButton("<");
    JButton buttonNext = new JButton(">");
    JButton buttonLast = new JButton(">|");
    JButton buttonInsert = new JButton("+");
    JButton buttonDelete = new JButton("-");
    JButton buttonEdit = new JButton("E");
    JButton buttonConfirm = new JButton("v");
    JButton buttonCancel = new JButton("x");
    JButton buttonRefresh = new JButton("R");
    JButton buttonSearch = new JButton("Q");

    JTextField fieldCode = new JTextField();
    JTextField fieldDescription = new JTextField();

    String[] item = {"SIM", "NÃO"};
    JComboBox comboboxActive = new JComboBox(item);

    public ViewRegisterTableList() {
        createAndShowView();
    }

    private void createAndShowView() {

        //Code 12
        setFrameAndPane("Cadastro de Mesas", 10, 10);

        addComponentDefaultPane();
        setComponentActionEvent();

        buttonConfirm.setEnabled(false);
        buttonCancel.setEnabled(false);

        frame.setVisible(true);

    }

    private void addComponentDefaultPane() {

        //Label
        labelTitle = setDefaultLabel(labelTitle, 0, 0, 1, 10, "HORIZONTAL");
        labelCode = setDefaultLabel(labelCode, 3, 0, 1, 2, "HORIZONTAL");
        labelDescription = setDefaultLabel(labelDescription, 4, 0, 1, 2, "HORIZONTAL");
        labelActive = setDefaultLabel(labelActive, 4, 5, 1, 1, "HORIZONTAL");

        //TextField
        fieldCode = setDefaultField(fieldCode, 3, 2, 1, 1, "HORIZONTAL");
        fieldDescription = setDefaultField(fieldDescription, 4, 2, 1, 3, "HORIZONTAL");

        //Combobox
        comboboxActive = setDefaultCombobox(comboboxActive, 4, 6, 1, 1, "HORIZONTAL");

        //Bot�es
        buttonFirst = setDefaultButton(buttonFirst, 1, 0, 1, 1, "BOTH");
        buttonPrevious = setDefaultButton(buttonPrevious, 1, 1, 1, 1, "BOTH");
        buttonNext = setDefaultButton(buttonNext, 1, 2, 1, 1, "BOTH");
        buttonLast = setDefaultButton(buttonLast, 1, 3, 1, 1, "BOTH");
        buttonInsert = setDefaultButton(buttonInsert, 1, 4, 1, 1, "BOTH");
        buttonDelete = setDefaultButton(buttonDelete, 1, 5, 1, 1, "BOTH");
        buttonEdit = setDefaultButton(buttonEdit, 1, 6, 1, 1, "BOTH");
        buttonConfirm = setDefaultButton(buttonConfirm, 1, 7, 1, 1, "BOTH");
        buttonCancel = setDefaultButton(buttonCancel, 1, 8, 1, 1, "BOTH");
        buttonRefresh = setDefaultButton(buttonRefresh, 1, 9, 1, 1, "BOTH");
        buttonSearch = setDefaultButton(buttonSearch, 3, 3, 1, 1, "BOTH");

    }

    private void setComponentActionEvent() {

        buttonFirst.addActionListener(this);
        buttonPrevious.addActionListener(this);
        buttonNext.addActionListener(this);
        buttonLast.addActionListener(this);
        buttonInsert.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonEdit.addActionListener(this);
        buttonConfirm.addActionListener(this);
        buttonCancel.addActionListener(this);
        buttonRefresh.addActionListener(this);
        buttonSearch.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonFirst) {
            System.out.println("Primeiro");
        } else if (e.getSource() == buttonPrevious) {
            System.out.println("Anterior");
        } else if (e.getSource() == buttonNext) {
            System.out.println("Pr�ximo");
        } else if (e.getSource() == buttonLast) {
            System.out.println("�ltimo");
        } else if (e.getSource() == buttonInsert) {
            System.out.println("Inserir");
        } else if (e.getSource() == buttonDelete) {
            System.out.println("Excluir");
        } else if (e.getSource() == buttonEdit) {
            System.out.println("Editar");
        } else if (e.getSource() == buttonConfirm) {
            System.out.println("Confirmar");
        } else if (e.getSource() == buttonCancel) {
            System.out.println("Cancelar");
        } else if (e.getSource() == buttonRefresh) {
            System.out.println("Atualizar");
        } else if (e.getSource() == buttonSearch) {
            System.out.println("Pesquisar");
        }

    }

}
