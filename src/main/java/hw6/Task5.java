package hw6;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Task5 {
    private static final String HACKER_NEWS_API = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String NEWS_API_FORMAT = "https://hacker-news.firebaseio.com/v0/item/%d.json";

    public long[] hackerNewsTopStories() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(HACKER_NEWS_API))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String[] ids = response.body().replaceAll("\\[|\\]", "").split(",");
                long[] result = new long[ids.length];

                for (int i = 0; i < ids.length; i++) {
                    result[i] = Long.parseLong(ids[i].trim());
                }

                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new long[0];
    }

    public String news(long id) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(NEWS_API_FORMAT, id)))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // Используем регулярное выражение для извлечения названия новости
                Pattern pattern = Pattern.compile("\"title\"\\s*:\\s*\"([^\"]+)\"");
                Matcher matcher = pattern.matcher(response.body());

                if (matcher.find()) {
                    return matcher.group(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Unable to fetch news title";
    }
}
