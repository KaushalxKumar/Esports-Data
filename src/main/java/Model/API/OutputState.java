package Model.API;

import Model.Data.Index;
import Model.Data.League;
import Model.Data.Series;

import javax.swing.*;
import java.util.List;

public interface OutputState {
    /**
     * Sends report data on chosen League to a Twilio configured phone number.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * The chosen League and its Series will be sent to a Twilio configured phone number.<br>
     *
     * @param league The League chosen to include in the report.
     * @param series A list of Series chosen to include in the report.
     */
    void sendReport(League league, List<Series> series);

    /**
     * Formats League and Series data into a report.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * The chosen League and its Series formatted into a report.<br>
     *
     * @param league The League chosen to include in the report.
     * @param series A list of Series chosen to include in the report.
     * @return The formatted string that will be sent as a report.
     */
    default String reportMaker(League league, List<Series> series) {

        StringBuilder message = new StringBuilder();
        message.append(league.toString() + "\n");
        message.append("League ID: " + league.getId() + "\n");
        message.append("Modified At: " + league.getModified_at() + "\n");
        message.append("Slug: " + league.getSlug() + "\n");
        message.append("League URL: " +league.getUrl() + "\n");
        message.append("Image URL: " + league.getImage_url() + "\n");

        Index index = Index.getInstance();
        int number = index.getIndex();

        if (series.size() >= number + 1) {
            message.append("\nMatching Series Was: \n" + series.get(number).getFull_name() + "\n");
        }

        message.append( "\nAll Series:\n");
        for (Series s : series) {
            message.append(s.getFull_name() + "\n");
        }

        return message.toString();
    }
}
