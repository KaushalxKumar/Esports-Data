package View.Listeners;

import View.ApplicationWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main event handler and controller between the view and model.
 */
public abstract class Listener implements ActionListener {
    protected ApplicationWindow window;
    protected JPanel panel;

    /**
     * Default action listener constructor.
     * <b>Preconditions:</b><br>
     * None.<br>
     * <b>Postconditions:</b><br>
     * None.<br>
     *
     * @param window The main application window.
     */
    public Listener(ApplicationWindow window){
        this.window = window;
    }

    /**
     * Performs actions altering the view.<br><br>
     * <b>Preconditions:</b><br>
     * None.<br>
     * <b>Postconditions:</b><br>
     * None.<br>
     *
     * @param e The specific action event..
     */
    public abstract void actionPerformed(ActionEvent e);
}