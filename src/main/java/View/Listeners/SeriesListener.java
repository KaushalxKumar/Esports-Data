package View.Listeners;

import Model.Data.Index;
import Model.Data.League;
import Model.Data.Series;
import Model.PandaScoreFacade;
import View.ApplicationWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SeriesListener extends Listener {

    private JComboBox<League> selection;

    public SeriesListener(ApplicationWindow window, JComboBox<League> selection) {
        super(window);
        this.selection = selection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.panel = this.window.getSeriesPanel();
        PandaScoreFacade facade = this.window.getFacade();
        League searchTerm = selection.getItemAt(selection.getSelectedIndex());
        List<Series> series = facade.getSeries(searchTerm);

        JComboBox<Series> seriesResults = new JComboBox<Series>();
        seriesResults.setBounds(360, 450, 280, 100);
        seriesResults.setBackground(Color.WHITE);

        for (Series s : series) {
            seriesResults.addItem(s);
        }

        Index index = Index.getInstance();
        int number = index.getIndex();

        if (series.size() >= number + 1) {
            JLabel selection = new JLabel("This League Has The Following Series: " + series.get(number).getFull_name());
            selection.setBounds(330, 370, 400, 50);
            selection.setHorizontalTextPosition(JLabel.CENTER);
            this.panel.add(selection);
        }

        JButton sendButton = new JButton("SEND REPORT");
        sendButton.setBounds(360, 300, 280, 50);
        sendButton.setBackground(Color.RED);
        ActionListener reportListener = new ReportListener(this.window, searchTerm, series);
        sendButton.addActionListener(reportListener);

        this.panel.add(sendButton);
        this.panel.add(seriesResults);
        this.window.setContentPane(this.panel);
        this.window.setVisible(true);
    }
}
