package View.Listeners;

import Model.Data.League;
import Model.Data.Series;
import View.ApplicationWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ReportListener extends Listener {
    private League league;
    private List<Series> series;


    public ReportListener(ApplicationWindow window, League league, List<Series> series) {
        super(window);
        this.league = league;
        this.series = series;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.panel = this.window.getSeriesPanel();
        this.window.getFacade().sendReport(league, series);
        JLabel reportSent = new JLabel("*REPORT SENT: CHECK MOBILE DEVICE*");
        reportSent.setForeground(Color.MAGENTA);
        reportSent.setBounds(390, 350, 280, 50);
        this.panel.add(reportSent);
        this.window.setContentPane(this.panel);
        this.window.setVisible(true);
    }
}
