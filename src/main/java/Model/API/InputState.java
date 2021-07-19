package Model.API;

import Model.Data.League;
import Model.Data.Series;
import Model.Database.Database;

import java.util.List;

/**
 * Module to access the external input API
 */
public interface InputState {
    /**
     * Returns a list of leagues from the PandaScore API.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * A list of leagues will be obtained by the system.<br>
     *
     * @param database The database to get data.
     * @return The list of leagues obtained from the PandaScore API.
     */
    List<League> getLeagues(Database database);

    /**
     * Returns a list of series from the PandaScore API based on the given league.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * A list of series for the given league will be obtained from the PandaScore API.<br>
     *
     * @param league The league chosen to find all its series.
     * @return The list of series obtained from the PandaScore API.
     */
    List<Series> getSeries(League league);

}
