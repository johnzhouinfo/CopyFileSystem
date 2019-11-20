/*
 * Created by JFormDesigner on Wed Nov 20 14:27:05 EST 2019
 */

package info.johnzhou.View;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author John Zhou
 */
public class CFSView extends JFrame {
    public CFSView() {
        initComponents();
    }

    private void quitButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        depthField = new JTextField();
        buttonBar = new JPanel();
        copyButton = new JButton();
        quitButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new MigLayout(
                        "insets dialog,hidemode 3",
                        // columns
                        "[fill]" +
                                "[fill]",
                        // rows
                        "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]"));

                //---- label1 ----
                label1.setText("Select source file:");
                contentPanel.add(label1, "cell 0 0");

                //---- label2 ----
                label2.setText("Target path:");
                contentPanel.add(label2, "cell 0 3");

                //---- label3 ----
                label3.setText("Depth:");
                contentPanel.add(label3, "cell 0 5");

                //---- depthField ----
                depthField.setHorizontalAlignment(SwingConstants.TRAILING);
                contentPanel.add(depthField, "cell 1 5");
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setLayout(new MigLayout(
                        "insets dialog,alignx right",
                        // columns
                        "[button,fill]" +
                                "[button,fill]",
                        // rows
                        null));

                //---- copyButton ----
                copyButton.setText("Copy");
                buttonBar.add(copyButton, "cell 0 0");

                //---- quitButton ----
                quitButton.setText("Quit");
                quitButton.addActionListener(e -> quitButtonActionPerformed(e));
                buttonBar.add(quitButton, "cell 1 0");
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField depthField;
    private JPanel buttonBar;
    private JButton copyButton;
    private JButton quitButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
