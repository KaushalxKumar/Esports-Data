package View;

import Model.PandaScoreFacade;
import View.Listeners.EnterListener;
import View.Listeners.NumberListener;
import View.Listeners.SearchLeaguesListener;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * The main access view for users of the application.
 */
public class ApplicationWindow extends JFrame {

    private PandaScoreFacade facade;

    private JPanel main;
    private JPanel leagues;
    private JPanel series;
    private JTextField text;

    /**
     * Constructor for the GUI.<br><br>
     * <b>Preconditions:</b><br>
     * none.<br>
     * <b>Postconditions:</b><br>
     * none.<br>
     *
     * @param facade The facade that abstarcts application logic.
     */
    public ApplicationWindow(PandaScoreFacade facade) {
        this.facade = facade;
        initSeries();
        initLeague();
        initMain();


    }

    /**
     * Initialiser for main window.<br><br>
     * <b>Preconditions:</b><br>
     * none.<br>
     * <b>Postconditions:</b><br>
     * none.<br>
     */
    public void initMain() {
        this.main = new JPanel();
        this.main.setBackground(Color.WHITE);
        this.main.setLayout(null);
        this.main.setSize(1000,800);

        JLabel slogan = new JLabel();
        slogan.setBounds(0, 20, 1000 ,200);
        slogan.setIcon(new ImageIcon("src/main/resources/Images/slogan.png"));
        slogan.setVerticalAlignment(JLabel.CENTER);
        slogan.setHorizontalAlignment(JLabel.CENTER);

        JLabel logo = new JLabel();
        logo.setBounds(0, 700, 1000 ,200);
        logo.setIcon(new ImageIcon("src/main/resources/Images/logo.png"));
        logo.setVerticalAlignment(JLabel.BOTTOM);
        logo.setHorizontalAlignment(JLabel.CENTER);

        JButton enterButton = new JButton("EXPLORE LEAGUES");
        enterButton.setBounds(420, 400, 200, 100);
        enterButton.setBackground(Color.LIGHT_GRAY);
        ActionListener getStarted = new EnterListener(this);
        enterButton.addActionListener(getStarted);
        enterButton.setEnabled(false);

        JLabel instructions = new JLabel("Input A Number From 0 - 4 & Press Enter");
        instructions.setBounds(410, 300, 400, 50);

        this.text = new JTextField();
        this.text.setHorizontalAlignment(JTextField.CENTER);
        this.text.setBounds(420, 350, 200, 40);
        this.text.setBackground(Color.LIGHT_GRAY);
        ActionListener numberSelection = new NumberListener(this, enterButton, this.text);
        this.text.addActionListener(numberSelection);

        this.main.add(instructions);
        this.main.add(this.text);
        this.main.add(slogan);
        this.main.add(logo);
        this.main.add(enterButton);

        this.setTitle("PandaScore API eSports Data");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(main);
        this.setResizable(false);
        this.setSize(1000, 1000);
        this.setVisible(true);
    }

    /**
     * Initialiser for the leagues window.<br><br>
     * <b>Preconditions:</b><br>
     * none.<br>
     * <b>Postconditions:</b><br>
     * none.<br>
     */
    public void initLeague() {
        this.leagues = new JPanel();
        this.leagues.setSize(1000,800);
        this.leagues.setLayout(null);
        this.leagues.setBackground(Color.WHITE);

        JButton searchLeaguesButton = new JButton("FIND ME LEAGUES");
        searchLeaguesButton.setBounds(360, 300, 280, 50);
        searchLeaguesButton.setBackground(Color.LIGHT_GRAY);
        ActionListener findLeagues = new SearchLeaguesListener(this);
        searchLeaguesButton.addActionListener(findLeagues);

        JLabel logoText = new JLabel();
        logoText.setIcon(new ImageIcon("src/main/resources/Images/logo.png"));
        logoText.setBounds(200, 10, 1000 ,200);
        logoText.setVerticalAlignment(JLabel.TOP);
        logoText.setHorizontalAlignment(JLabel.LEFT);

        this.leagues.add(logoText);
        this.leagues.add(searchLeaguesButton);
    }

    /**
     * Initialiser for series window.<br><br>
     * <b>Preconditions:</b><br>
     * none.<br>
     * <b>Postconditions:</b><br>
     * none.<br>
     */
    public void initSeries() {
        this.series = new JPanel();
        this.series.setSize(1000,800);
        this.series.setLayout(null);
        this.series.setBackground(Color.WHITE);

        JLabel seriesLogo = new JLabel();
        seriesLogo.setIcon(new ImageIcon("src/main/resources/Images/logo.png"));
        seriesLogo.setBounds(200, 10, 1000 ,200);
        seriesLogo.setVerticalAlignment(JLabel.TOP);
        seriesLogo.setHorizontalAlignment(JLabel.LEFT);

        JLabel searchedLeague = new JLabel( "All Series For The Chosen League");
        searchedLeague.setBounds(400, 400, 500, 50);
        searchedLeague.setBackground(Color.LIGHT_GRAY);

        JLabel instructions = new JLabel("SELECT A SERIES BEFORE HITTING SEND");
        instructions.setBounds(390, 250, 280, 50);

        this.series.add(instructions);
        this.series.add(searchedLeague);
        this.series.add(seriesLogo);
    }

    /**
     * Simple accessor for the facade.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The application facade.
     */
    public PandaScoreFacade getFacade() {
        return this.facade;
    }

    /**
     * Simple accessor for series window.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series window.
     */
    public JPanel getSeriesPanel() {
        return this.series;
    }

    /**
     * Simple accessor for league window.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The league window.
     */
    public JPanel getLeaguesPanel() {
        return this.leagues;
    }

    /**
     * Simple accessor for main window.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The mian window.
     */
    public JPanel getMainPanel() {
        return this.main;
    }
}
