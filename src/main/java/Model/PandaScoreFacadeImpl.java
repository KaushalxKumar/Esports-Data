package Model;

import Model.API.InputState;
import Model.API.OutputState;
import Model.Data.League;
import Model.Data.Series;
import Model.Database.Database;

import java.util.List;

public class PandaScoreFacadeImpl implements PandaScoreFacade {
    InputState input;
    OutputState output;
    Database database;

    public PandaScoreFacadeImpl(InputState input, OutputState output, Database database) {
        this.input = input;
        this.output = output;
        this.database = database;
    }

    @Override
    public List<League> getLeagues() {
        return this.input.getLeagues(this.database);
    }

    @Override
    public List<Series> getSeries(League league) {
        return this.input.getSeries(league);
    }

    @Override
    public void sendReport(League league, List<Series> series) {
        this.output.sendReport(league, series);
    }

    @Override
    public int check() {
        return this.database.check();
    }

    @Override
    public void update(String body) {
        this.database.update(body);
    }

    @Override
    public List<League> select() {
        return this.database.select();
    }

}
