package View.Listeners;

import View.ApplicationWindow;

import java.awt.event.ActionEvent;

public class EnterListener extends Listener {
    public EnterListener(ApplicationWindow window) {
        super(window);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.panel = this.window.getLeaguesPanel();
        this.window.setContentPane(this.panel);
        this.window.setVisible(true);
    }
}
