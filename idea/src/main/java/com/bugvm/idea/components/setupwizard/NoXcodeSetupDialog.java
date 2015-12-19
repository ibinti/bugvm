package com.bugvm.idea.components.setupwizard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;

import com.bugvm.compiler.util.ToolchainUtil;

import com.intellij.ui.components.labels.LinkLabel;
import com.intellij.ui.components.labels.LinkListener;

public class NoXcodeSetupDialog extends JDialog {
    private JPanel panel;
    private JLabel infoText;
    private JButton nextButton;

    public NoXcodeSetupDialog() {
        setContentPane(panel);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("BugVM Setup");
        infoText.setText("<html>To compile for iOS simulators or devices, you will need a Mac running <strong>Mac OS X 10.x</strong> and <strong>Xcode 7 or higher</strong>. ");

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private void createUIComponents() {
    }
}
