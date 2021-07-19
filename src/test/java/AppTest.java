import Model.API.InputState;
import Model.API.OutputState;
import Model.Data.Index;
import Model.Data.League;
import Model.Data.Series;
import Model.Database.Database;
import Model.PandaScoreFacade;
import Model.PandaScoreFacadeImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AppTest {

    @Test
    public void getLeaguesTest()  {
        InputState input = mock(InputState.class);
        Database database = mock(Database.class);
        PandaScoreFacade facade = new PandaScoreFacadeImpl(input, null, database);

        List<League> results = new ArrayList<>();
        LinkedHashMap<Object, Object> videogame = new LinkedHashMap<>();
        videogame.put("name", "CS:GO");
        League league = new League(4572, null, null, "ESL One", null, null, null, videogame);
        results.add(league);

        when(input.getLeagues(database)).thenReturn(results);
        List<League> leagues = facade.getLeagues();

        verify(input, times(1)).getLeagues(database);
        assertEquals(4572, leagues.get(0).getId());
        assertEquals("ESL One", leagues.get(0).getName());
        LinkedHashMap game = (LinkedHashMap) leagues.get(0).getVideogame();
        String gameName = (String) game.get("name");
        assertEquals("CS:GO", gameName);
    }

    @Test
    public void getLeagueSeriesTest() {
        InputState input = mock(InputState.class);
        Database database = mock(Database.class);
        PandaScoreFacade facade = new PandaScoreFacadeImpl(input, null, database);

        LinkedHashMap<Object, Object> videogame = new LinkedHashMap<>();
        videogame.put("name", "CS:GO");
        League league = new League(4572, null, null, "ESL One", null, null, null, videogame);

        List<Series> results = new ArrayList<>();
        Series a = new Series(null, null, null, "Cologne Online: Asia 2020", 0, null, 0, null, null, null, null, null, null, null, null, 0, null, 0);
        Series b = new Series(null, null, null, "Cologne Online: Oceania 2020", 0, null, 0, null, null, null, null, null, null, null, null, 0, null, 0);
        Series c = new Series(null, null, null, "Cologne Online: North America 2020", 0, null, 0, null, null, null, null, null, null, null, null, 0, null, 0);
        results.add(a);
        results.add(b);
        results.add(c);

        when(input.getSeries(league)).thenReturn(results);
        List<Series> series = facade.getSeries(league);
        verify(input, times(1)).getSeries(league);

        assertEquals("Cologne Online: Asia 2020", series.get(0).getFull_name());
        assertEquals("Cologne Online: Oceania 2020", series.get(1).getFull_name());
        assertEquals("Cologne Online: North America 2020", series.get(2).getFull_name());
    }


    @Test
    public void sendReportTest() {
        InputState input = mock(InputState.class);
        OutputState output = mock(OutputState.class);
        Database database = mock(Database.class);
        PandaScoreFacade facade = new PandaScoreFacadeImpl(input, output, database);
        League league = mock(League.class);
        List<Series> series = mock(List.class);
        facade.sendReport(league, series);
        verify(output, times(1)).sendReport(any(), any());
    }

    @Test
    public void databaseCheck() {
        InputState input = mock(InputState.class);
        OutputState output = mock(OutputState.class);
        Database database = mock(Database.class);
        PandaScoreFacade facade = new PandaScoreFacadeImpl(input, output, database);

        when(database.check()).thenReturn(5);
        int result = facade.check();
        assertEquals(5, result);
        verify(database, times(1)).check();
    }

    @Test
    public void databaseUpdate() {
        InputState input = mock(InputState.class);
        OutputState output = mock(OutputState.class);
        Database database = mock(Database.class);
        PandaScoreFacade facade = new PandaScoreFacadeImpl(input, output, database);

        facade.update("Test");
        verify(database, times(1)).update(any());
    }

    @Test
    public void databaseSelect() {
        InputState input = mock(InputState.class);
        OutputState output = mock(OutputState.class);
        Database database = mock(Database.class);

        PandaScoreFacade facade = new PandaScoreFacadeImpl(input, output, database);

        List<League> results = new ArrayList<>();
        LinkedHashMap<Object, Object> videogame = new LinkedHashMap<>();
        videogame.put("name", "CS:GO");
        League league = new League(4572, null, null, "ESL One", null, null, null, videogame);
        results.add(league);

        when(database.select()).thenReturn(results);
        List<League> leagues = facade.select();

        verify(database, times(1)).select();
        assertEquals(4572, leagues.get(0).getId());
        assertEquals("ESL One", leagues.get(0).getName());
        LinkedHashMap game = (LinkedHashMap) leagues.get(0).getVideogame();
        String gameName = (String) game.get("name");
        assertEquals("CS:GO", gameName);
    }

    @Test
    public void singletonTest() {
        Index number = Index.getInstance();
        number.setIndex(10);

        assertEquals(10, number.getIndex());
    }
}
