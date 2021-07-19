package Model.API;

import Model.Data.League;
import Model.Data.Series;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

public class OutputOnline implements OutputState {

    private String SID;
    private String token;
    private String to;
    private String from;

    public OutputOnline() {
        initialiseTokens();
    }

    @Override
    public void sendReport(League league, List<Series> series) {
        String credentials = this.SID + ":" + this.token;
        String encoded = new String(Base64.getEncoder().encode(credentials.getBytes()));
        String authorizationHeader = "Basic " + encoded;

        String body = this.reportMaker(league, series);
        String message = "To=" + this.to + "&From=" + this.from + "&Body=" + body;

        try {
            System.out.println("**SENDING REPORT API CALL**");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(message))
                    .header("Content-type", "application/x-www-form-urlencoded")
                    .header("Authorization", authorizationHeader)
                    .uri(URI.create("https://api.twilio.com/2010-04-01/Accounts/AC4487edb1eeb3b02660c4c8c09ee042ed/Messages.json"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            System.out.println("Error Sending Report");
            e.printStackTrace();
        }

    }

    public void initialiseTokens() {
        try {
            File file = new File("src/main/resources/Output Token.txt");
            Scanner sc = new Scanner(file);
            this.SID = sc.nextLine();
            this.token = sc.nextLine();
            this.to = sc.nextLine();
            this.from = sc.nextLine();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

}
