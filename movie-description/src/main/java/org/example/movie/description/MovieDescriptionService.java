package org.example.movie.description;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.apache.http.HttpException;
import java.io.IOException;

public class MovieDescriptionService {
    Client client = new Client();

    public MovieDescriptionService(){
        this.client = new Client();
    }

    public String generateDescription(String movieTitle) throws HttpException, IOException {
        String prompt = "generate a one sentence description of the movie " +movieTitle;
        GenerateContentResponse response = client.models.generateContent("gemini-2.0-flash-001", prompt, null);
        return response.text().replace("\n", "");
    }
//
//    System.out.println("Enter a question for the model:");
//    String query = scanner.nextLine();
//    GenerateContentResponse response = client.models.generateContent("gemini-2.0-flash-001", query, null);
//        System.out.println(response.text());
}
