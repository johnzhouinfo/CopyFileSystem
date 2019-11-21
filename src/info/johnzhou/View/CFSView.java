/*
 * Created by JFormDesigner on Wed Nov 20 14:27:05 EST 2019
 */

package info.johnzhou.View;

import info.johnzhou.CFS.Impl.CFSServiceImpl;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author John Zhou
 */
public class CFSView extends JFrame {
    File sourceFile, sourcePath, targetPath;
    int depth = 1;
    List<File> sourceFileList;
    private CFSServiceImpl cfsService = new CFSServiceImpl();

    public CFSView() {
        initComponents();
    }

    private File selectPath() {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.showSaveDialog(null);
        return f.getSelectedFile();
    }

    private void quitButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void sourcePathMouseClicked(MouseEvent e) {
        sourcePath = selectPath();
        if (sourcePath != null) {
            sourcePathField.setText(sourcePath.toString());
            sourceFileList = cfsService.getFolderInfo(sourcePath);
            sourceList.setListData(sourceFileList.stream().map(File::getName).toArray());
        }
    }

    private void targetPathMouseClicked(MouseEvent e) {
        targetPath = selectPath();
        if (targetPath != null) {
            targetPathField.setText(targetPath.toString());
            List<File> result = cfsService.getFolderInfo(targetPath);
            targetList.setListData(result.stream().map(File::getName).toArray());
        }
    }


    private void copyButtonActionPerformed(ActionEvent e) {
        if (sourceList.getSelectedIndex() == -1) {
            MsgLabel.setText("Please select source file");
            return;
        }
        sourceFile = sourceFileList.get(sourceList.getSelectedIndex());

        try {
            depth = Integer.parseInt(depthField.getText());
            MsgLabel.setText("Successful copied " + cfsService.copyFile(sourceFile, targetPath, depth));
        } catch (IOException e1) {
            MsgLabel.setText("Unable to copy file");
            e1.printStackTrace();
        } catch (NumberFormatException e1) {
            MsgLabel.setText("Only accept number in depth field");
        }

        MsgLabel.setVisible(true);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label4 = new JLabel();
        sourcePathField = new JTextField();
        MsgLabel = new JLabel();
        label5 = new JLabel();
        targetPathField = new JTextField();
        label3 = new JLabel();
        depthField = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        sourceList = new JList();
        scrollPane2 = new JScrollPane();
        targetList = new JList();
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
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                        // rows
                        "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]"));

                //---- label4 ----
                label4.setText("Source Path");
                contentPanel.add(label4, "cell 0 0");

                //---- sourcePathField ----
                sourcePathField.setText("Click to select");
                sourcePathField.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        sourcePathMouseClicked(e);
                    }
                });
                contentPanel.add(sourcePathField, "cell 1 0");

                //---- MsgLabel ----
                MsgLabel.setText("WARING_Msg");
                MsgLabel.setForeground(Color.red);
                contentPanel.add(MsgLabel, "cell 9 0");

                //---- label5 ----
                label5.setText("Target Path");
                contentPanel.add(label5, "cell 0 1");

                //---- targetPathField ----
                targetPathField.setText("Click to select");
                targetPathField.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        targetPathMouseClicked(e);
                    }
                });
                contentPanel.add(targetPathField, "cell 1 1");

                //---- label3 ----
                label3.setText("Depth:");
                contentPanel.add(label3, "cell 9 1");

                //---- depthField ----
                depthField.setHorizontalAlignment(SwingConstants.TRAILING);
                depthField.setText("1");
                contentPanel.add(depthField, "cell 10 1,width 50");

                //---- label1 ----
                label1.setText("Select source file:");
                contentPanel.add(label1, "cell 0 2");

                //---- label2 ----
                label2.setText("Target path:");
                contentPanel.add(label2, "cell 9 2");

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(sourceList);
                }
                contentPanel.add(scrollPane1, "cell 0 4 2 1");

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(targetList);
                }
                contentPanel.add(scrollPane2, "cell 9 4 2 1");
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
                copyButton.addActionListener(e -> copyButtonActionPerformed(e));
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
    private JLabel label4;
    private JTextField sourcePathField;
    private JLabel MsgLabel;
    private JLabel label5;
    private JTextField targetPathField;
    private JLabel label3;
    private JTextField depthField;
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JList sourceList;
    private JScrollPane scrollPane2;
    private JList targetList;
    private JPanel buttonBar;
    private JButton copyButton;
    private JButton quitButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
