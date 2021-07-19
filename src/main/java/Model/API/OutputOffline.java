package Model.API;

import Model.Data.League;
import Model.Data.Series;

import java.util.List;

public class OutputOffline implements OutputState {
    @Override
    public void sendReport(League league, List<Series> series) {
        System.out.println("**SENDING REPORT**\n");
        System.out.println(this.reportMaker(league, series));
    }
}
