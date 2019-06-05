package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import controller.ControllerMenuSystem;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.Userpermission;

public class ViewMenuSystem extends ViewMaster implements ActionListener {

    ControllerMenuSystem controllerMenuSystem = new ControllerMenuSystem();
    Userpermission userpermission;

    JMenuBar menubar = new JMenuBar();
    JMenu optionMenu = new JMenu("Opções");
    JMenuItem logoutMenu = new JMenuItem("Logout");
    JMenuItem menuSystemOption = new JMenuItem("Menu Principal");
    JMenu preferences = new JMenu("Preferências");
    JMenu setTheme = new JMenu("Tema");
    JMenu setColor = new JMenu("Cor em Destaque");

    ButtonGroup groupTheme = new ButtonGroup();
    JRadioButtonMenuItem lighTheme = new JRadioButtonMenuItem("Claro");
    JRadioButtonMenuItem darkTheme = new JRadioButtonMenuItem("Escuro");

    ButtonGroup groupColor = new ButtonGroup();
    JRadioButtonMenuItem colorBlue = new JRadioButtonMenuItem("Azul");
    JRadioButtonMenuItem colorGreen = new JRadioButtonMenuItem("Verde");
    JRadioButtonMenuItem colorYellow = new JRadioButtonMenuItem("Amarelo");
    JRadioButtonMenuItem colorOrange = new JRadioButtonMenuItem("Laranja");
    JRadioButtonMenuItem colorRed = new JRadioButtonMenuItem("Vermelho");

    ImageIcon exeIcon = new ImageIcon(getClass().getResource("/icon/exeIcon.png"));
    
    JLabel labelManager = new JLabel("Gerenciamento");
    JLabel labelAttendant = new JLabel("Atendimento");
    JLabel labelCashier = new JLabel("Caixa");

    JButton buttonRegisterGuestCheck = new JButton("Cadastro de Comandas", exeIcon);
    JButton buttonRegisterComboProduct = new JButton("Cadastro de Combos", exeIcon);
    JButton buttonRegisterTableList = new JButton("Cadastro de Mesas", exeIcon);
    JButton buttonRegisterProductCategory = new JButton("<html>Cadastro de Categorias<br />e Adicionais</html>", exeIcon);
    JButton buttonRegisterProduct = new JButton("Cadastro de Produtos", exeIcon);
    JButton buttonReportUserLog = new JButton("Relatórios de Usuário", exeIcon);
    JButton buttonCashRegister = new JButton("Caixa", exeIcon);
    JButton buttonRequest = new JButton("Pedidos", exeIcon);
    JButton buttonDeliveryRequest = new JButton("Entrega de Pedidos", exeIcon);
    JButton buttonPreparationRequest = new JButton("Preaparação de Pedidos", exeIcon);

    JButton buttonProgram3 = new JButton();

    public ViewMenuSystem() {
        //Melhorar: quando este método for chamado, apenas deixar painel do Menu visível
        //Trabalhar com diversos paines, um painel será criado quando pârametro for passado
        createAndShowGUI();
    }

    public ViewMenuSystem(Userpermission userpermission) {
        this.userpermission = userpermission;
        createAndShowGUI();
    }

    private void createAndShowGUI() {

        //Code 4
        setFrameAndPane("Menu Principal", 15, 20, 30, 60);

        addMenubarItem();
        addComponentDefaultPane();
        setComponentActionEvent();

        menubar.setVisible(true);
        frame.setVisible(true);

    }

    public void addComponentDefaultPane() {
        int counLine = 0;

        if (userpermission.getManager()) {

            labelManager = setDefaultLabel(labelManager, counLine, 0, 1, 20, "HORIZONTAL");
            counLine++;

            buttonRegisterGuestCheck = setDefaultButton(buttonRegisterGuestCheck, counLine, 0, 2, 6, "BOTH");
            buttonRegisterTableList = setDefaultButton(buttonRegisterTableList, counLine, 6, 2, 6, "BOTH");
            buttonRegisterProductCategory = setDefaultButton(buttonRegisterProductCategory, counLine, 12, 2, 6, "BOTH");

            counLine = counLine + 2;

            buttonRegisterProduct = setDefaultButton(buttonRegisterProduct, counLine, 0, 2, 6, "BOTH");
            buttonRegisterComboProduct = setDefaultButton(buttonRegisterComboProduct, counLine, 6, 2, 6, "BOTH");
            buttonReportUserLog = setDefaultButton(buttonReportUserLog, counLine, 12, 2, 6, "BOTH");

            counLine = counLine + 3;
        }

        if (userpermission.getAttendant()) {

            labelAttendant = setDefaultLabel(labelAttendant, counLine, 0, 1, 20, "HORIZONTAL");
            counLine++;

            buttonRequest = setDefaultButton(buttonRequest, counLine, 0, 2, 6, "BOTH");
            buttonPreparationRequest = setDefaultButton(buttonPreparationRequest, counLine, 6, 2, 6, "BOTH");
            buttonDeliveryRequest = setDefaultButton(buttonDeliveryRequest, counLine, 12, 2, 6, "BOTH");

            counLine = counLine + 3;
        }

        if (userpermission.getCashier()) {

            labelCashier = setDefaultLabel(labelCashier, counLine, 0, 1, 20, "HORIZONTAL");
            counLine++;

            buttonCashRegister = setDefaultButton(buttonCashRegister, counLine, 0, 2, 6, "BOTH");
            counLine = counLine + 2;
        }
        if (userpermission.getStocker()) {

        }

    }

    private void addMenubarItem() {

        frame.setJMenuBar(menubar);
        menubar.setOpaque(false);

        //Opções
        menubar.add(optionMenu);
        optionMenu.add(preferences);
        preferences.add(setTheme);
        preferences.add(setColor);
        setTheme.add(lighTheme);
        setTheme.add(darkTheme);
        setColor.add(colorBlue);
        setColor.add(colorGreen);
        setColor.add(colorYellow);
        setColor.add(colorOrange);
        setColor.add(colorRed);
        groupTheme.add(lighTheme);
        groupTheme.add(darkTheme);
        lighTheme.setSelected(true);
        groupColor.add(colorBlue);
        groupColor.add(colorGreen);
        groupColor.add(colorYellow);
        groupColor.add(colorOrange);
        groupColor.add(colorRed);
        colorOrange.setSelected(true);

        //Menu Principal
        menubar.add(menuSystemOption);
        //Logout
        menubar.add(logoutMenu);

    }

    private void setComponentActionEvent() {

        buttonRegisterGuestCheck.addActionListener(this);
        buttonRegisterTableList.addActionListener(this);
        buttonRegisterProductCategory.addActionListener(this);
        buttonRegisterProduct.addActionListener(this);
        buttonRegisterComboProduct.addActionListener(this);
        buttonReportUserLog.addActionListener(this);
        buttonRequest.addActionListener(this);
        buttonPreparationRequest.addActionListener(this);
        buttonDeliveryRequest.addActionListener(this);
        buttonCashRegister.addActionListener(this);

        menuSystemOption.addActionListener(this);
        logoutMenu.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonRegisterGuestCheck) {
            controllerMenuSystem.callRegisterGuestCheck();
        } else if (e.getSource() == buttonReportUserLog) {
            //Montar Relatório
        } else if (e.getSource() == buttonCashRegister) {
            new ViewCashRegister();
        } else if (e.getSource() == menuSystemOption) {
            controllerMenuSystem.callMenuSystem();
        } else if (e.getSource() == logoutMenu) {
            menubar.setVisible(false);
            frame.remove(menubar);
            controllerMenuSystem.executeLogout();
        }

    }

}
