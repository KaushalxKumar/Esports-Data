package View.Listeners;

import Model.Data.Index;
import View.ApplicationWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class NumberListener extends Listener {
    JButton button;
    JTextField text;

    public NumberListener(ApplicationWindow window, JButton button, JTextField text) {
        super(window);
        this.button = button;
        this.text = text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.panel = this.window.getMainPanel();
        String numberStr = this.text.getText();
        int number = Integer.parseInt(numberStr);

        JLabel error = new JLabel("**Invalid Number Try Again**");
        error.setBounds(440, 500, 200, 100);
        error.setForeground(Color.RED);

        if (number > 4 || number < 0) {
            this.panel.add(error);
            this.window.setContentPane(this.panel);
            this.window.setVisible(true);
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
            Index index = Index.getInstance();
            index.setIndex(number);
        }

    }
}
