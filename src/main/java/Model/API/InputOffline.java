package Model.API;

import Model.Data.League;
import Model.Data.Series;
import Model.Database.Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class InputOffline implements InputState {
    List<League> leagues;
    List<Series> series;

    public InputOffline() {
        LinkedHashMap<Object, Object> videogame = new LinkedHashMap<>();
        videogame.put("name", "CS:GO");

        League league = new League(4572, null, null, "ESL One", null, null, null, videogame);
        this.leagues = new ArrayList<>();
        this.leagues.add(league);

        Series a = new Series(null, null, null, "Cologne Online: Asia 2020", 0, null, 0, null, null, null, null, null, null, null, null, 0, null, 0);
        Series b = new Series(null, null, null, "Cologne Online: Oceania 2020", 0, null, 0, null, null, null, null, null, null, null, null, 0, null, 0);
        Series c = new Series(null, null, null, "Cologne Online: North America 2020", 0, null, 0, null, null, null, null, null, null, null, null, 0, null, 0);

        this.series = new ArrayList<>();
        this.series.add(a);
        this.series.add(b);
        this.series.add(c);
    }

    @Override
    public List<League> getLeagues(Database database) {
        System.out.println("**MAKING LEAGUES CALL**\n");

        try {
            File file = new File("src/main/resources/Dummy Data/League Data.txt");
            Scanner sc = new Scanner(file);
            StringBuilder response = new StringBuilder();
            while (sc.hasNextLine()) {
                response.append(sc.nextLine());
            }
            database.update(response.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

        return this.leagues;
    }

    @Override
    public List<Series> getSeries(League league) {
        System.out.println("**MAKING SERIES CALL**\n");
        return this.series;
    }

}
