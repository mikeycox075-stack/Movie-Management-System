public class MovieObject {
    private String movieName;
    private int movieRelease;
    private String dominantFigure;
    private String genre;
    public int starRating;
    //setting

    public boolean isValid() {
        return movieName != null && !movieName.isBlank()
                && movieRelease > 1920 && movieRelease < 2030
                && dominantFigure != null && !dominantFigure.isBlank()
                && genre != null && !genre.isBlank()
                && starRating > 0 && starRating <= 5;
    }//end of is valid

    //creating my objects
    public MovieObject(String movieName, int movieRelease, String dominantFigure, String genre, int starRating) {
        this.movieName = movieName;
        this.movieRelease = movieRelease;
        this.dominantFigure = dominantFigure;
        this.genre = genre;
        this.starRating = starRating;
    }//end of movie objects

        // Getters and setters

        //creating getters

        public String getMovieName(){
            return movieName;
        }//end of moiveName

        public int getMovieRelease(){
            return movieRelease;
        }//end of movieRelease

        public String getDominantFigure(){
            return dominantFigure;
        }//end of dominantFigure

        public String getGenre(){
            return genre;
        }//end of genre

        public int getStarRating(){
            return starRating;
        }//end of starRating

        //creating setters

        public void setMovieName(String movieName){
            this.movieName = movieName;
        }//end of movieName

        public void setMovieRelease(int movieRelease){
            this.movieRelease = movieRelease;
        }//end of movieRelease

        public void setDominantFigure(String dominantFigure){
            this.dominantFigure = dominantFigure;
        }//end of weight

        public void setGenre(String genre){
            this.genre = genre;
        }//end of genre

        public void setStarRating(int starRating){
            this.starRating = starRating;
        }//end of starRating

    @Override
    public String toString() {
        return movieName + "," + movieRelease + "," + dominantFigure + "," + genre + "," + starRating;
    }//end of to string
}//end of class
