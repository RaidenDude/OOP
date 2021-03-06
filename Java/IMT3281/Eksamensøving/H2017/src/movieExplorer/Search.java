package movieExplorer;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

import static movieExplorer.Constants.APIKEY;

/**
 * Class containing functions to search for different actors/movies on themoviedb.org
 */
public class Search {

    /**
     * Constructor to throw exception if a user attempts to create a new Search
     * @throws InstantiationException The exception to throw on instantiation
     */
    public Search() throws InstantiationException {
        throw new InstantiationException("Search class should not be instantiated, use member functions!");
    }


    /**
     * Performs a multi-search (search with multiple results) after an actor
     * @param actorName The actor to search for
     * @return An instance of the custom JSON class with the data
     */
    public static JSON multiSearch(String actorName) {
        String response = null;
        String request = "https://api.themoviedb.org/3/search/multi?api_key=APIKEY&language=en-US&query=ACTOR&page=1&include_adult=false";
        request = request.replace("APIKEY", APIKEY);
        actorName = actorName.replace(" ", "%20");
        request = request.replace("ACTOR", actorName);

        System.out.println("Search request: " + request);

        try {
            response = Unirest.get(request).asString().getBody();
            System.out.println(response);		// Outputs JSON response from server.
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return new JSON(response);
    }

    /**
     * Performs a search for actors in a given movie
     * @param movieIndex The index of the movie to find actors for
     * @return An instance of the custom JSON class with data about the actors
     */
    public static JSON actors(int movieIndex) {
        String response = null;
        String request = "https://api.themoviedb.org/3/movie/MOVIEID/credits?api_key=APIKEY";
        request = request.replace("APIKEY", APIKEY);
        request = request.replace("MOVIEID", String.valueOf(movieIndex));

        System.out.println("Search request: " + request);

        try {
            response = Unirest.get(request).asString().getBody();
            System.out.println(response);		// Outputs JSON response from server.
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return new JSON(response);
    }

    /**
     * Performs a search for which movies a given actor has partaken in
     * @param actorIndex The index of the actor to search for
     * @return An instance of the custom JSON class with data about the movies the actor has played in
     */
    public static JSON takesPartIn(int actorIndex) {
        String response = null;
        String request = "https://api.themoviedb.org/3/discover/movie?api_key=APIKEY&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_people=ACTORID";
        request = request.replace("APIKEY", APIKEY);
        request = request.replace("ACTORID", String.valueOf(actorIndex));

        System.out.println("Search request: " + request);

        try {
            response = Unirest.get(request).asString().getBody();
            System.out.println(response);		// Outputs JSON response from server.
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return new JSON(response);
    }

    /**
     * Performs a search for all TV genres stored in themoviedb.org
     * @return An instance of the custom JSON class with data about all available TV genres
     */
    public static JSON tvGenres() {
        String response = null;
        String request = "https://api.themoviedb.org/3/genre/tv/list?api_key=APIKEY&language=en-US";
        request = request.replace("APIKEY", APIKEY);

        System.out.println("Search request: " + request);

        try {
            response = Unirest.get(request).asString().getBody();
            System.out.println(response);		// Outputs JSON response from server.
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return new JSON(response);
    }

    /**
     * Performs a search for all movie genres stored in themoviedb.org
     * @return An instance of the custom JSON class with data about all available movie genres
     */
    public static JSON movieGenres() {
        String response = null;
        String request = "https://api.themoviedb.org/3/genre/movie/list?api_key=APIKEY&language=en-US";
        request = request.replace("APIKEY", APIKEY);

        System.out.println("Search request: " + request);

        try {
            response = Unirest.get(request).asString().getBody();
            System.out.println(response);		// Outputs JSON response from server.
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return new JSON(response);
    }
}
