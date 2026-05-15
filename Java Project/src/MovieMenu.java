import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieMenu {
    public static void main(String[] args) {
        MovieMethods MovieInstance = new MovieMethods();
        Scanner sc = new Scanner(System.in);
        int choice;

        try {
            do {
                System.out.println("");
                System.out.println("Restarting Programme");
                System.out.println("Hello. Welcome to the " +
                        "Movie Selecting tool created by Michael Cox");
                System.out.println("");

                System.out.println("""
                         +===== Movie Selecting Menu =====+
                         1.| Find me a Movie
                         2 | List all Movies
                         3 | Movie Report
                         4 | Add Movie
                         5 | Remove Movie
                         0 | Exit
                        """);

                System.out.print("Choice: ");
                choice = sc.nextInt();
                sc.nextLine();
                //if for Find me a movie
                if (choice == 1) {
                    System.out.println("You have selected 'Find me a movie'");
                    System.out.println("How would you like to find the movie?");
                    System.out.println("""
                         +===== Movie Location Menu =====+
                         1.| Star rating
                         2 | Actor or actress name
                         3 | Movie Genre
                         4 | Between dates of release
                         5 | Movie Name
                         0 | Exit
                        """);
                    System.out.print("Choice: ");
                    int FindMovieChoice = sc.nextInt();
                    sc.nextLine();

                    if (FindMovieChoice == 1){
                        System.out.println("Selected: Star rating");
                        System.out.println("This is between 1 - 5");
                        System.out.print("Enter rating: ");
                        int starRating = sc.nextInt();
                        sc.nextLine();
                        MovieInstance.loadMovies();
                        System.out.println("");
                        System.out.println("Loading Movies");
                        MovieObject result  =
                        MovieInstance.searchByStarRating(starRating);
                        if (result != null) {
                            System.out.println(result);
                        }//end of if
                        else{
                            System.out.println("Movies searched for do not exist within" +
                                    "movie records, please check if the values are correct");
                        }//end of else
                        System.out.println("");
                    }//end of star rating if

                    else if (FindMovieChoice == 2){
                        MovieInstance.loadMovies();
                        MovieInstance.listAllDominantPeople();
                        System.out.println("Selected: Actor/Actress");
                        System.out.println("Please enter their name");
                        System.out.println("");
                        System.out.print("Name: ");
                        String dominantFigure = sc.nextLine();
                        System.out.println("");
                        System.out.println("Loading Movies");
                        MovieObject result  =
                        MovieInstance.searchByActorActressName(dominantFigure);
                        if (result != null) {
                            System.out.println(result);
                        }//end of if
                        else{
                            System.out.println("Movies searched for do not exist within" +
                                    "movie records, please check if the values are correct");
                        }//end of else
                        System.out.println("");
                        //Call a function that lists all actors/actresses
                    }//end of Actor or Actress if

                    else if (FindMovieChoice == 3){
                        System.out.println("Selected: movie Genre");
                        System.out.println("Please type the genre in one word " +
                                "like this 'Scifi");
                        System.out.println("Please enter the genre");
                        System.out.print("genre; ");
                        String genre = sc.nextLine();
                        MovieInstance.loadMovies();
                        System.out.println("");
                        System.out.println("Loading Movies");
                        MovieObject result  =
                        MovieInstance.searchByGenre(genre);
                        if (result != null) {
                            System.out.println(result);
                        }//end of if
                        else{
                            System.out.println("Movies searched for do not exist within" +
                                    "movie records, please check if the values are correct");
                        }//end of else
                        System.out.println("");
                        //call a function that lists all movie genres
                    }//End of Genre if

                    else if (FindMovieChoice == 4){
                        //call a function that lists the decades
                        System.out.println("Selected: Between dates of release");
                        System.out.println("Please input two years for us to search between");
                        int MovieYearChoiceMin;
                        int MovieYearChoiceMax;
                        System.out.print("minimum: ");
                        MovieYearChoiceMin = sc.nextInt();
                        sc.nextLine();
                        System.out.print("maximum: ");
                        MovieYearChoiceMax = sc.nextInt();
                        sc.nextLine();
                        MovieInstance.loadMovies();
                        System.out.println("");
                        System.out.println("Loading Movies");
                        MovieObject result  =
                        MovieInstance.searchBySelectedDates(MovieYearChoiceMin,MovieYearChoiceMax);
                        if (result != null) {
                            System.out.println(result);
                        }//end of if
                        else{
                            System.out.println("Movies searched for do not exist within" +
                                    "movie records, please check if the values are correct");
                        }//end of else
                        System.out.println("");
                            //call a function that lists all movie genres
                    }//end of decade if

                    else if (FindMovieChoice == 5){
                        System.out.println("Selected: movie name");
                        System.out.println("Please enter the name");
                        System.out.print("name: ");
                        String movieName = sc.nextLine();
                        MovieInstance.loadMovies();
                        System.out.println("");
                        System.out.println("Loading Movies");
                        MovieObject result  =
                        MovieInstance.searchByMovieName(movieName);
                        if (result != null) {
                            System.out.println(result);
                        }//end of if
                        else{
                            System.out.println("Movies searched for do not exist within" +
                                    "movie records, please check if the values are correct");
                        }//end of else
                        System.out.println("");
                        //call a function that lists all movie genres
                    }//End of Name if
                    else{
                        return;
                    }//end of else
                }//end of find me a movie if
                //end of find me a movie

                else if (choice == 2){
                    System.out.println("You have selected 'List all movies'");
                    MovieInstance.loadMovies();
                    System.out.println("");
                    System.out.println("Loading Movies");
                    System.out.println("");
                    MovieInstance.listMovies();
                    System.out.println("");
                    //call a function that lists all movies
                }//end of list all movies

                else if (choice == 3){
                    System.out.println("You have selected 'Movie Report'");
                    MovieInstance.loadMovies();
                    System.out.println("");
                    System.out.println("Loading Movies");
                    System.out.println("");
                    MovieInstance.report();
                    System.out.println("");
                    //call a function that lists a movie report
                }//end of decade

                else if (choice == 4){
                    MovieInstance.loadMovies();
                    System.out.println("You have selected 'Add Movie'");
                    System.out.println("");
                    System.out.println("Loading Movies");
                    System.out.println("");
                    addMovieMenu(MovieInstance, sc);
                    System.out.println("");
                    MovieInstance.saveMovies();
                    System.out.println("");
                    //call add movie
                }//end of decade

                else if (choice == 5){
                    System.out.println("You have selected 'Remove Movie'");
                    System.out.println("Selected: movie name");
                    System.out.println("Please enter the name: ");
                    System.out.print("name: ");
                    String movieName = sc.nextLine();
                    MovieInstance.loadMovies();
                    System.out.println("");
                    System.out.println("Loading Movies");
                    System.out.println("");
                    MovieInstance.removeMovie(movieName);
                    System.out.println("");
                    MovieInstance.saveMovies();
                    System.out.println("");
                    //call remove movie
                }//end of decade
                else{
                    System.out.print("Exiting the System.");
                }//end of exit
            }//end of do

            while (choice != 0);
        }//end of try
        catch (Exception e){
            System.out.println("Please enter a valid number");
        }//end of exception
    }//end of main

    private static void addMovieMenu(MovieMethods MovieInstance, Scanner sc) {

        System.out.print("Name: ");
        String addMovieName = sc.nextLine();
        //gets the name

        System.out.print("Movie Release: ");
        int addMovieRelease = sc.nextInt();
        sc.nextLine();
        //gets the movie Release

        System.out.print("Dominant Figure: ");
        String addDominantFigure = sc.nextLine();
        //gets the dominantFigure

        System.out.print("Genre: ");
        String addGenre = sc.nextLine();
        //gets the Genre

        System.out.print("Star rating: ");
        int starRating = sc.nextInt();
        sc.nextLine();
        //gets the Star rating

        MovieInstance.addMovie(new MovieObject(addMovieName, addMovieRelease,addDominantFigure,addGenre,starRating));
        System.out.println("Movie instance attempts to save the movie");
    }//end of add movies

}//end of class
