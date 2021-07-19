package Model;

import Model.Data.League;
import Model.Data.Series;

import java.util.List;

/**
 * The main access view for users of the PandaScore module.
 */
public interface PandaScoreFacade {
    /**
     * Returns a list of leagues from the PandaScore API.<br><br>
     * <b>Preconditions:</b><br>
     * The PandaScoreFacade must have been injected with a non-null instance of a InputState module via the constructor.<br>
     * <b>Postconditions:</b><br>
     * A list of leagues will be obtained by the system.<br>
     *
     * @return The list of leagues obtained from the PandaScore API.
     */
    List<League> getLeagues();

    /**
     * Returns a list of series from the PandaScore API based on the given league.<br><br>
     * <b>Preconditions:</b><br>
     * The PandaScoreFacade must have been injected with a non-null instance of a InputState module via the constructor.<br>
     * <b>Postconditions:</b><br>
     * A list of series for the given league will be obtained from the PandaScore API.<br>
     *
     * @param league The league chosen to find all its series.
     * @return The list of series obtained from the PandaScore API.
     */
    List<Series> getSeries(League league);

    /**
     * Sends report data on chosen League to a Twilio configured phone number.<br><br>
     * <b>Preconditions:</b><br>
     * The PandaScoreFacade must have already obtained League and Series from the PandaScoreAPI.<br>
     * <b>Postconditions:</b><br>
     * The chosen League and its Series will be sent to a Twilio configured phone number.<br>
     *
     * @param league The League chosen to include in the report.
     * @param series A list of Series chosen to include in the report.
     */
    void sendReport(League league, List<Series> series);

    /**
     * Checks if cached league data exists.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>I.<br>
     * <b>Postconditions:</b><br>
     * User is notified if a cached version exits<br>
     */
    int check();

    /**
     * Updates database with recently retrieved API data.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>I.<br>
     * <b>Postconditions:</b><br>
     * Database is updated with fresh data.<br>
     */
    void update(String body);

    /**
     * Returns a list of series from a database cache based on the given league.<br><br>
     * <b>Preconditions:</b><br>
     * The PandaScoreFacade must have been injected with a non-null instance of a Database module via the constructor.<br>
     * <b>Postconditions:</b><br>
     * A list of leagues will be obtained by the system.<br>
     *
     * @return The list of series obtained from the database.
     */
    List<League> select();
}
