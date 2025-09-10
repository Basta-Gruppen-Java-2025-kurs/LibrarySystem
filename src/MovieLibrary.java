import java.util.ArrayList;


public class MovieLibrary
{
    public static void main(String[] args)
    {
        Movie movie = new Movie("test", "Horror", 2002, 7.6);
        addMovie(movie);
        showAllMovies();
    }

    static ArrayList<Movie> library = new ArrayList<Movie>();

    public static void addMovie(Movie aMovie)
    {
        library.add(aMovie);
    }

    public static void showAllMovies()
    {
        for (Movie movie : library)
        {
            System.out.println("Name: " + movie.title + ", year: " + movie.year + ", grade: " + movie.grade);
        }
    }

    public ArrayList<Movie> filterGenre(String aGenre)
    {
        ArrayList<Movie> moviesWithSelectedGenre = new ArrayList<Movie>();

        for (Movie movie : library)
        {
            if (movie.genre.toLowerCase() == aGenre.toLowerCase())
            {
                moviesWithSelectedGenre.add(movie);
            }
        }
       return moviesWithSelectedGenre;
    }

    public ArrayList<Movie> filterGrade(Double aMinimumGrade)
    {
        ArrayList<Movie> moviesWithSelectedGrade = new ArrayList<Movie>();

        for (Movie movie : library)
        {
            if (movie.grade >= aMinimumGrade)
            {
                moviesWithSelectedGrade.add(movie);
            }
        }
       return moviesWithSelectedGrade;
    }

    public void genomsnittsBetyg(ArrayList<Double> betyg)
    {

    }

    public void filmFrånÅr(ArrayList<String> titlar, ArrayList<Integer> år, int årtal)
    {

    }

}
