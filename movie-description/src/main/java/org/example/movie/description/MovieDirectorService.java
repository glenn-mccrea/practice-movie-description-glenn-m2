package org.example.movie.description;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.apache.http.HttpException;

import java.io.IOException;

public class MovieDirectorService {
    Client client = new Client();

    public MovieDirectorService(){
        this.client = new Client();
    }

    public String generateDirector(String movieTitle) throws HttpException, IOException {
        String prompt = "fetch the director of the film " +movieTitle + " simply return the name and nothing else.";
        GenerateContentResponse response = client.models.generateContent("gemini-2.0-flash-001", prompt, null);
        return response.text().replace("\n", "");
    }



//    request:
//    get description
//    get director
//            format as json
//
//
//            return
//    newDescription = description: ""
//    newDirector = director: "director"

//
//    CompletableFuture<String> call1 = geminiClient.askAsync(promptA);
//    CompletableFuture<String> call2 = geminiClient.askAsync(promptB);
//
//    String result1 = call1.get();
//    String result2 = call2.get();
//
//return new CombinedResponse(result1, result2);

}
