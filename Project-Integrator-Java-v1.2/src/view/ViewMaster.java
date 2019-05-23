package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

public abstract class ViewMaster{

    static GridBagLayout grid = new GridBagLayout();
    static GridBagConstraints c = new GridBagConstraints();
    static JFrame frame = new JFrame();
    static JPanel pane = new JPanel();

    static JFrame newFrame;
    static JPanel newPane = new JPanel();

    static Font fontText = new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 14);
    static Font fontButton = new Font("Arial", Font.BOLD, 14);

    static Dimension sizeDefault = new Dimension(60, 30);

    static Color colorDefaultWhite = Color.decode("#FFFFFF"); // Branco
    static Color colorDefaultBlack = Color.decode("#000000"); // Preto
    static Color colorDefaultBlue = Color.decode("#0030FF"); // Azul
    static Color colorDefaultBackground = Color.decode("#F4F4F4"); // Branco Cinzento //#D4D4D4

    public static void setConstraints() {

        c.insets = new Insets(3, 3, 3, 3);
        c.fill = GridBagConstraints.BOTH;

//        frame.addWindowListener(new WindowListener() {
//
//            @Override
//            public void windowOpened(WindowEvent arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void windowIconified(WindowEvent arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void windowDeiconified(WindowEvent arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void windowDeactivated(WindowEvent arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void windowClosing(WindowEvent arg0) {
//                System.out.println("Foi");
//                System.exit(0);
//
//            }
//
//            @Override
//            public void windowClosed(WindowEvent arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void windowActivated(WindowEvent arg0) {
//                // TODO Auto-generated method stub
//
//            }
//        });
        frame.setExtendedState(frame.MAXIMIZED_BOTH);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(pane);

    }

    public static void closeApp() {
        //Erro no sistema, FECHA Aplicação
        pane.setVisible(false);
        pane.removeAll();
        pane.add(new JLabel("<html>[x_x]<br />ERRO 404</html>"));
        pane.setVisible(true);
    }

    public void setFrameAndPane(String title, int counRow, int countColumn, int lenghtRow, int lenghtColumn) {

        pane.setVisible(false);
        pane.removeAll();

        setGridLayout(counRow, countColumn, lenghtRow, lenghtColumn);

        //Definir um grid Padr�o??
        pane.setLayout(grid);
        pane.setBackground(colorDefaultBackground);

        pane.setVisible(true);
        frame.setTitle("Macro Tech - " + title);

    }

    public void addAndSetNewFrameAndPane(String title, int counRow, int countColumn, int lenghtRow, int lenghtColumn) {

        newFrame = new JFrame();
        setGridLayout(counRow, countColumn, lenghtRow, lenghtColumn);

        newPane.setLayout(grid);
        newPane.setBackground(colorDefaultBackground);
        newPane.setVisible(true);

        newFrame.add(newPane);
        newFrame.setSize(425, 300);
        newFrame.setTitle("Macro Tech - " + title);
        newFrame.setResizable(false);
        newFrame.setLocation((frame.getHeight() / 2), (frame.getWidth() / 5));
        newFrame.setVisible(true);

        frame.setEnabled(false);

    }

    public void closeNewFrame() {
        newPane.setVisible(false);
        newPane.removeAll();
        
        newFrame.setVisible(false);
        newFrame.removeAll();
        
        frame.setEnabled(true);
        //Porque 'frame' é minimizado?
        frame.show();
    }

    public void setGridLayout(int counRow, int countColumn, int lenghtRow, int lenghtColumn) {

        grid.columnWidths = new int[countColumn];
        for (int i = 0; i < grid.columnWidths.length; i++) {
            grid.columnWidths[i] = lenghtColumn;
        }

        grid.rowHeights = new int[counRow];
        for (int i = 0; i < grid.rowHeights.length; i++) {
            grid.rowHeights[i] = lenghtRow;
        }

    }

    public JButton setDefaultButton(JButton button, int gridy, int gridx, int gridheight, int gridwidth, String text) {

        button.setFont(fontButton);
        button.setPreferredSize(sizeDefault);
        button.setBackground(colorDefaultBlue);
        button.setForeground(colorDefaultWhite);
        button.setFocusable(false);

        pane.add(button, setGridBagConstraints(gridy, gridx, gridheight, gridwidth, text));

        return button;
    }

    public JButton setCustomButton(JButton button, int gridy, int gridx, int gridheight, int gridwidth, String text) {

        button.setFont(fontButton);
        button.setPreferredSize(sizeDefault);
        button.setBackground(colorDefaultBlue);
        button.setForeground(colorDefaultWhite);
        button.setFocusable(false);

        newPane.add(button, setGridBagConstraints(gridy, gridx, gridheight, gridwidth, text));

        return button;
    }

    public JLabel setDefaultLabel(JLabel label, int gridy, int gridx, int gridheight, int gridwidth, String text) {

        label.setPreferredSize(sizeDefault);
        label.setFont(fontText);
        label.setBackground(colorDefaultWhite);
        label.setForeground(colorDefaultBlack);

        pane.add(label, setGridBagConstraints(gridy, gridx, gridheight, gridwidth, text));

        return label;
    }

    public JLabel setCustomLabel(JLabel label, int gridy, int gridx, int gridheight, int gridwidth, String text) {

        label.setPreferredSize(sizeDefault);
        label.setFont(fontText);
        label.setBackground(colorDefaultWhite);
        label.setForeground(colorDefaultBlack);

        newPane.add(label, setGridBagConstraints(gridy, gridx, gridheight, gridwidth, text));

        return label;
    }

    public JTable setDefaultTableList(JTable table, int gridy, int gridx, int gridheight, int gridwidth, String text) {

        table.setFont(fontText);
        table.setBackground(colorDefaultBlue);
        table.setForeground(colorDefaultBlack);

        pane.add(table, setGridBagConstraints(gridy, gridx, gridheight, gridwidth, text));

        return table;
    }

    public JTextField setDefaultField(JTextField field, int gridy, int gridx, int gridheight, int gridwidth,
            String text) {

        field.setPreferredSize(sizeDefault);
        field.setFont(fontText);
        field.setBackground(colorDefaultWhite);
        field.setForeground(colorDefaultBlack);

        pane.add(field, setGridBagConstraints(gridy, gridx, gridheight, gridwidth, text));

        return field;
    }

    public JTextField setCustomField(JTextField field, int gridy, int gridx, int gridheight, int gridwidth,
            String text) {

        field.setPreferredSize(sizeDefault);
        field.setFont(fontText);
        field.setBackground(colorDefaultWhite);
        field.setForeground(colorDefaultBlack);

        newPane.add(field, setGridBagConstraints(gridy, gridx, gridheight, gridwidth, text));

        return field;
    }

    public JPasswordField setDefaultPasswordField(JPasswordField field, int gridy, int gridx, int gridheight, int gridwidth,
            String text) {

        field.setPreferredSize(sizeDefault);
        field.setFont(fontText);
        field.setBackground(colorDefaultWhite);
        field.setForeground(colorDefaultBlack);

        pane.add(field, setGridBagConstraints(gridy, gridx, gridheight, gridwidth, text));

        return field;
    }

    public JComboBox setDefaultCombobox(JComboBox combobox, int gridy, int gridx, int gridheight, int gridwidth,
            String text) {

        combobox.setPreferredSize(sizeDefault);
        combobox.setFont(fontText);
        combobox.setBackground(colorDefaultWhite);
        combobox.setForeground(colorDefaultBlack);
        combobox.setVisible(true);

        pane.add(combobox, setGridBagConstraints(gridy, gridx, gridheight, gridwidth, text));

        return combobox;
    }

    public GridBagConstraints setGridBagConstraints(int gridy, int gridx, int gridheight, int gridwidth, String text) {

        c.gridy = gridy;
        c.gridx = gridx;
        c.gridheight = gridheight;
        c.gridwidth = gridwidth;

        if (text.equals("HORIZONTAL")) {
            c.fill = GridBagConstraints.HORIZONTAL;
        } else if (text.equals("BOTH")) {
            c.fill = GridBagConstraints.BOTH;
        } else if (text.equals("ABOVE_BASELINE")) {
            c.fill = GridBagConstraints.ABOVE_BASELINE;
        }

        return c;

    }

}
