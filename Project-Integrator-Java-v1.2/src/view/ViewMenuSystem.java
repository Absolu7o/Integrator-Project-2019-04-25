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
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;

public class ViewMenuSystem extends ViewMaster implements ActionListener {

    ControllerMenuSystem controllerMenuSystem = new ControllerMenuSystem();

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

    JButton buttonRegisterGuestCheck = new JButton("Cadastro de Comandas");
    JButton buttonReportUserLogAnalitc = new JButton("Relatório Análitico de Log");
    JButton buttonReportUserLogSynthetic = new JButton("Relatório Sintético de Log");

    public ViewMenuSystem() {
        //Melhorar: quando este método for chamado, apenas deixar painel do Menu visível
        //Trabalhar com diversos paines, um painel será criado quando pârametro for passado
        createAndShowGUI(null, null);
    }

    public ViewMenuSystem(Character cashier, Character attendant) {
        createAndShowGUI(cashier, attendant);
    }

    private void createAndShowGUI(Character cashier, Character attendant) {

        //Code 4
        setFrameAndPane("Menu Principal", 6, 5);
        if ((cashier != null) && (attendant != null)) {
            //Carrega MenuBar
            tempMenubarItem();  //Método Temporario
            //addMenubarItem(); //Melhorar Método
        }

        addComponentDefaultPane();
        setComponentActionEvent();

        menubar.setVisible(true);
        frame.setVisible(true);

    }

    public void addComponentDefaultPane() {

        buttonRegisterGuestCheck = setDefaultButton(buttonRegisterGuestCheck, 0, 0, 2, 5, "BOTH");
        buttonReportUserLogAnalitc = setDefaultButton(buttonReportUserLogAnalitc, 2, 0, 2, 5, "BOTH");
        buttonReportUserLogSynthetic = setDefaultButton(buttonReportUserLogSynthetic, 4, 0, 2, 5, "BOTH");

    }

    private void tempMenubarItem() {

        frame.setJMenuBar(menubar);
        menubar.setOpaque(false);
        //Menu Principal
        menubar.add(menuSystemOption);
        //Logout
        menubar.add(logoutMenu);

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
        buttonReportUserLogAnalitc.addActionListener(this);
        buttonReportUserLogSynthetic.addActionListener(this);

        menuSystemOption.addActionListener(this);
        logoutMenu.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonRegisterGuestCheck) {
            controllerMenuSystem.callRegisterGuestCheck();
        } else if (e.getSource() == buttonReportUserLogAnalitc) {
            try {
                controllerMenuSystem.callReport("UserLogAnalitc");
            } catch (JRException ex) {
                Logger.getLogger(ViewMenuSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == buttonReportUserLogSynthetic) {
            try {
                controllerMenuSystem.callReport("UserLogSynthetic");
            } catch (JRException ex) {
                Logger.getLogger(ViewMenuSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == menuSystemOption) {
            controllerMenuSystem.callMenuSystem();
        } else if (e.getSource() == logoutMenu) {
            menubar.setVisible(false);
            frame.remove(menubar);
            controllerMenuSystem.executeLogout();
        }

    }

}
