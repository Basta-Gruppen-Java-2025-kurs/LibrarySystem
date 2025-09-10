import java.util.ArrayList;


public class MovieLibrary
{
    public static void main(String[] args)
    {
        addMovie("Spöken", "Horror", 2002, 2.4);
        addMovie("Triceratops", "Documentary", 2002, 8.0);
        addMovie("Egypten", "Documentary", 2002, 1.2);
        addMovie("Tony Hawks skating", "Action", 2002, 7.6);
        addMovie("Mission Impossible 76", "Action", 2078, 3.2);
        addMovie("The Road", "Drama", 2009, 7.2);
        addMovie("The Shawshank Redemption", "Drama", 1994, 9.3);
        addMovie("The Lord of the Rings", "Fantasy", 2003, 9.0);

        System.out.println("All movies:");
        showAllMovies();
        System.out.println();

        System.out.println("Drama movies:");
        showAllMovies(filterGenre("Drama"));
        System.out.println();
        System.out.println("Movies above average grade");
        showAllMovies(filterGrade(averageGrade()));
        System.out.println();
        System.out.println("Movies from 2002");
        showAllMovies(moviesFromYear(2002));
    }

    static ArrayList<Movie> library = new ArrayList<Movie>();

    public static void addMovie(Movie aMovie)
    {
        library.add(aMovie);
    }

    public static void addMovie(String aTitle, String aGenre, int aYear, double aGrade)
    {
        Movie movie = new Movie(aTitle, aGenre, aYear, aGrade);
        library.add(movie);
    }

    public static void showAllMovies()
    {
        for (Movie movie : library)
        {
            System.out.println("Name: " + movie.title + ", genre: " +movie.genre + ", year: " + movie.year + ", grade: " + movie.grade);
        }
    }

    public static void showAllMovies(ArrayList<Movie> aLibrary)
    {
        for (Movie movie : aLibrary)
        {
            System.out.println("Name: " + movie.title + ", genre: " +movie.genre + ", year: " + movie.year + ", grade: " + movie.grade);
        }
    }

    public static ArrayList<Movie> filterGenre(String aGenre)
    {
        ArrayList<Movie> moviesWithSelectedGenre = new ArrayList<Movie>();

        for (Movie movie : library)
        {
            if (movie.genre == aGenre)
            {
                moviesWithSelectedGenre.add(movie);
            }
        }
       return moviesWithSelectedGenre;
    }

    public static ArrayList<Movie> filterGrade(Double aMinimumGrade)
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

    public static double averageGrade()
    {
        return library.stream().mapToDouble(p->p.grade).average().orElse(-1);
    }

    public static ArrayList<Movie> moviesFromYear(int aYear)
    {
        ArrayList<Movie> moviesWithSelectedYear = new ArrayList<Movie>();

        for (Movie movie : library)
        {
            if (movie.year == aYear)
            {
                moviesWithSelectedYear.add(movie);
            }
        }
       return moviesWithSelectedYear;
    }
}
