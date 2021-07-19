package Model.API;

import Model.Data.League;

import Model.Data.Series;
import Model.Database.Database;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class InputOnline implements InputState {
    private String token;

    public InputOnline() {
        initialiseToken();
    }

    @Override
    public List<League> getLeagues(Database database) {
        List<League> leagues = null;

        try {
            System.out.println("**MAKING LEAGUES API CALL**\n");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("accept", "application/json")
                    .uri(URI.create("https://api.pandascore.co/leagues?token=" + token))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            database.update(response.body());

            ObjectMapper leagueMapper = new ObjectMapper();
            leagues = leagueMapper.readValue(response.body(), new TypeReference<List<League>>() {});

        } catch (IOException | InterruptedException e) {
            System.out.println("Error Fetching Leagues");
        }

        return leagues;
    }

    @Override
    public List<Series> getSeries(League league) {
        List<Series> series = null;

        try {
            System.out.println("**MAKING SERIES API CALL**\n");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("accept", "application/json")
                    .uri(URI.create("https://api.pandascore.co/series?filter[league_id]=" + league.getId() + "&token=" + token))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper seriesMapper = new ObjectMapper();
            series = seriesMapper.readValue(response.body(), new TypeReference<List<Series>>() {});

        } catch (IOException | InterruptedException e) {
            System.out.println("Error Fetching Series");
        }

        return series;
    }

    public void initialiseToken() {
        try {
            File file = new File("src/main/resources/Input Token.txt");
            Scanner sc = new Scanner(file);
            this.token = sc.nextLine();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

}
