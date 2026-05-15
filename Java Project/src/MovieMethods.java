import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MovieMethods{

    Scanner sc = new Scanner(System.in);
    public ArrayList<MovieObject> movies = new ArrayList<>();


    public void loadMovies(){
            movies.clear();
            try {
                File file = new File("Movies.txt");

                if (!file.exists()) {
                    System.out.println("Movies.txt not found.");
                    return;
                }//end of if

                Scanner reader = new Scanner(file);

                int lineNumber = 0;

                while (reader.hasNextLine()) {
                    //creating a thing to hold the string line to sort through
                    String line = reader.nextLine();
                    lineNumber++;
                    if (line == null || line.strip().isEmpty()) continue;
                    String[] p = line.split(",");
                    //splitting the string line  into words to sort through
                    for (int i = 0; i < p.length; i++) {
                        p[i] = p[i].trim();
                    }//end of for

                    String movieName = p[0];
                    int movieRelease = Integer.parseInt(p[1]);
                    String dominantFigure = p[2];
                    String genre = p[3];
                    int starRating = Integer.parseInt(p[4]);

                    movies.add(new MovieObject(movieName, movieRelease,dominantFigure,genre,starRating));
                }//end of while
                reader.close();
            }//end of try
            catch (FileNotFoundException e) {
                System.out.println("No previous movie file found.");
                //catching the exception if movie is not found.
            }//end of catch

    }//end of loadMovies


    public void saveMovies(){
        if (movies == null || movies.isEmpty()) {
            System.out.println("No Movies to save. File not overwritten.");
            return;
        }//end of checking for nulls or empty
            try (PrintWriter pw = new PrintWriter("Movies.txt")) {
                for (MovieObject a : movies) {
                    if (a.isValid()){
                        pw.println(a);
                    }//end of if
                    else{
                        System.out.println("The Movie details " +
                                "you have inputted are invalid");
                    }//en of else
                } //end of for
            }//end of try
            catch (FileNotFoundException e){
                    System.out.println("No previous Movie file found.");
                }//End of catch
    }//end of save movies

    public void addMovie(MovieObject a) {
        if (!a.isValid()){
            System.out.println("Movie contains invalid values.");
            return;
        }//end of check for valid.
        else if (a.isValid()){
            System.out.println("Movies values correct, movie saved successfully.");
            movies.add(a);
        }//end of check for valid
        else{
            System.out.print("An error has occurred");
            //Don't think this would ever run, added just in case
        }//end of final check
        //adding the movie
    }//end of add movie

    public void removeMovie(String movieName){
        boolean found1 = false;
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getMovieName().equalsIgnoreCase(movieName)) {
                movies.remove(i);
                found1 = true;
                break;
            }//end of if
        }//end of for
        if (found1 == false){
            System.out.println("Movie not found.");
        }//end of if
        else if (found1 == true){
            System.out.println("Movie has been removed");
        }// end of else if
    }//end of remove movies


    public MovieObject searchByMovieName(String movieName) {
        for (int i = 0; i < movies.size(); i++) { //sorting by length of arraylist
            MovieObject a = movies.get(i);
            if (a.getMovieName().equalsIgnoreCase(movieName)) {
                return a;   //if its found
            } //end of if
        }//end of for
        System.out.println("Movie not found or null values inputted.");
        return null;
        //if not found
    }//end of search by name


    public MovieObject searchByStarRating(int starRating) {
        for (int i = 0; i < movies.size(); i++) { //sorting by length of arraylist
            MovieObject a = movies.get(i);
            if (a.getStarRating() == starRating) {
                return a;   //if its found
            } //end of if
        }//end of for
        System.out.println("Movie not found or null values inputted.");
        return null;
        //if not found
    }//end of search by starRating


    public MovieObject searchByGenre(String genre) {
        for (int i = 0; i < movies.size(); i++) { //sorting by length of arraylist
            MovieObject a = movies.get(i);
            if (a.getGenre().equalsIgnoreCase(genre)) {
                return a;   //if its found
            } //end of if
        }//end of for
        System.out.println("Movie not found or null values inputted.");
        return null;
        //if not found
    }//end of search by genre
    //creating blank variables

    public MovieObject searchBySelectedDates(int MovieYearChoiceMin,int MovieYearChoiceMax){
        for (int i = 0; i < movies.size(); i++) { //sorting by length of arraylist
            MovieObject a = movies.get(i);
            if (a.getMovieRelease() > MovieYearChoiceMin && a.getMovieRelease() < MovieYearChoiceMax){
                return a;   //if its found
            } //end of if
        }//end of for
        System.out.println("Movie not found or null values inputted.");
        return null;
        //if not found
    }//end of search by selected dates


    public MovieObject searchByActorActressName(String dominantFigure) {
        for (int i = 0; i < movies.size(); i++) { //sorting by length of arraylist
            MovieObject a = movies.get(i);
            if (a.getDominantFigure().equalsIgnoreCase(dominantFigure)) {
                return a;   //if its found
            } //end of if
        }//end of for
        System.out.println("Movie not found or null values inputted.");
        return null;
        //if not found
    }//end of search by dominant figure.

    public void listAllDominantPeople(){
        for( int i = 0; i < movies.size(); i++){
            System.out.println("Actors/Actresses: " + movies.get(i).getDominantFigure());
        }//end of for
    }//end of list all dominant People

    public void report() {

        System.out.println("Movie Report for");

        //creating a lst for the counts and types
        ArrayList<String> types = new ArrayList<String>();
        ArrayList<Integer> counts = new ArrayList<Integer>();

        for (int i = 0; i < movies.size(); i++) {
            String type = movies.get(i).getGenre();
            int index = -1;
            //looking for movie in list
            for (int j = 0; j < types.size(); j++) {
                if (types.get(j).equals(type)) {
                    index = j;
                    break;
                }//end of if
            }//end of for

            if (index == -1) {
                //if the movie is not found in the index, it adds it.
                types.add(type);
                counts.add(1);
            }//end if statement
            else {
                //if the movie already exists, it increases the count
                counts.set(index, counts.get(index) + 1);
            }//end of else
        }//end of for

        //prints the count for each type of movie.
        for (int i = 0; i < types.size(); i++) {
            System.out.println(types.get(i) + " the count is " + counts.get(i));
        }//end of for

        //find the dominating color
        //setting the string to none, in case of two equal amounts ect
        String dominantGenre = "None";

        int dominantCount = 0;
        for (int i = 0; i < movies.size(); i++) {
            String genre = movies.get(i).getGenre();
            int genreCount = 0;
            //incrementing the colors for each count of movie.
            for (int j = 0; j < movies.size(); j++) {
                if (movies.get(j).getGenre().equalsIgnoreCase(genre)) {
                    genreCount++;
                }//end of if
            }//end of for
            if (genreCount > dominantCount) {
                dominantCount = genreCount;
                dominantGenre = genre;
                //setting the dominant color and count so it can be printed
            }//end of if
        }//end of for
        System.out.println("Dominant Genre: " + dominantGenre);
    }//end of report


    public void listMovies(){
        for (MovieObject a : movies){
            System.out.println(a);
        }//end of for printing each movie
    }//end of list all movies
}//end of class
