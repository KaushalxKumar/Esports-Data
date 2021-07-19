package View.Listeners;

import Model.Data.League;
import Model.PandaScoreFacade;
import View.ApplicationWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchLeaguesListener extends Listener {

    public SearchLeaguesListener(ApplicationWindow window) {
        super(window);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.panel = this.window.getLeaguesPanel();
        PandaScoreFacade facade = this.window.getFacade();
        List<League> leagues = null;

        if (facade.check() != 0) {
            int selection = JOptionPane.showConfirmDialog(this.window,"A Cached Version Exists, Do You Want To Use It?");
            this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            if (selection == JOptionPane.YES_OPTION){
                leagues = facade.select();
            } else if (selection == JOptionPane.CANCEL_OPTION) {
                return;
            } else if (selection == JOptionPane.CLOSED_OPTION) {
                return;
            } else {
                leagues = facade.getLeagues();
            }

        } else {
            leagues = facade.getLeagues();
        }

        JComboBox<League> results = new JComboBox<League>();
        results.setBounds(360, 450, 280, 100);
        results.setBackground(Color.WHITE);
        for (League league : leagues) {
            results.addItem(league);
        }

        JLabel count = new JLabel( " Leagues Found: " + leagues.size());
        count.setBounds(450, 350, 500, 50);
        count.setBackground(Color.LIGHT_GRAY);
        JLabel instructions = new JLabel("Select A League & Then Press More Details");
        instructions.setBounds(376, 390, 500, 50);
        JButton detailsButton = new JButton("MORE DETAILS");
        detailsButton.setBounds(360, 600, 280, 50);
        detailsButton.setBackground(Color.LIGHT_GRAY);
        ActionListener seriesListener = new SeriesListener(this.window, results);
        detailsButton.addActionListener(seriesListener);

        this.panel.add(count);
        this.panel.add(instructions);
        this.panel.add(detailsButton);
        this.window.add(results);
        this.window.setContentPane(this.panel);
        this.window.setVisible(true);
    }

}
