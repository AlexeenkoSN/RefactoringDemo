import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void shouldStatementContainRightPriceWhenRegularMoviePassedAndDaysLessOrEqualThanTwo() {
        Customer testee = new Customer("");
        Movie movie = new Movie("", PriceCodes.Regular);
        Rental rental = new Rental(movie, 1);
        testee.addRental(rental);
        Assert.assertTrue("Check price correctness for Regular movie", testee.buildStatement().contains("2"));
    }

    @Test
    public void shouldStatementContainRightPriceWhenRegularMoviePassedDaysMoreThanTwo(){
        Customer testee = new Customer("");
        Movie movie = new Movie("", PriceCodes.Regular);
        Rental rental = new Rental(movie, 3);
        testee.addRental(rental);
        Assert.assertTrue("Check price correctness for Regular movie", testee.buildStatement().contains("3.5"));
    }

    @Test
    public void shouldStatementContainRightPriceWhenNewReleaseMoviePassed(){
        Customer testee = new Customer("");
        Movie movie = new Movie("", PriceCodes.NewRelease);
        Rental rental = new Rental(movie, 3);
        testee.addRental(rental);
        Assert.assertTrue("Check price correctness for new release movie", testee.buildStatement().contains("9"));
    }

    @Test
    public void shouldStatementContainRightPriceWhenChildrenMoviePassedWhenDaysLassOrEqualThanThree(){
        Customer testee = new Customer("");
        Movie movie = new Movie("", PriceCodes.Childrens);
        Rental rental = new Rental(movie, 1);
        testee.addRental(rental);
        Assert.assertTrue("Check price correctness for children's movie", testee.buildStatement().contains("1.5"));
    }

    @Test
    public void shouldStatementContainRightPriceWhenChildrenMoviePassedWhenDaysMoreThanThree(){
        Customer testee = new Customer("");
        Movie movie = new Movie("", PriceCodes.Childrens);
        Rental rental = new Rental(movie, 5);
        testee.addRental(rental);
        Assert.assertTrue("Check price correctness for children's movie", testee.buildStatement().contains("3"));
    }

    @Test
    public void shouldRenterPointsBeCorrectWhenRegularMoviePassed()
    {
        Movie movie = MovieBuilder
                .create()
                .withPriceCode(PriceCodes.Regular)
                .build();
        Rental rental = new Rental(movie, 1);

        Customer testee = new Customer("");
        testee.addRental(rental);

        Assert.assertTrue("Check renter points correctness for Regular movie", testee.buildStatement().contains("1"));
    }

    @Test
    public void shouldRenterPointsBeCorrectWhenChildrenMoviePassed()
    {
        Movie movie = MovieBuilder
                .create()
                .withPriceCode(PriceCodes.Childrens)
                .build();
        Rental rental = new Rental(movie, 1);

        Customer testee = new Customer("");
        testee.addRental(rental);

        Assert.assertTrue("Check renter points correctness for children movie", testee.buildStatement().contains("1"));
    }

    @Test
    public void shouldRenterPointsBeCorrectWhenOneDayRentalForReleaseMovie()
    {
        Movie movie = MovieBuilder
                .create()
                .withPriceCode(PriceCodes.NewRelease)
                .build();
        Rental rental = new Rental(movie, 1);

        Customer testee = new Customer("");
        testee.addRental(rental);

        Assert.assertTrue("Check renter points correctness for children movie", testee.buildStatement().contains("1"));
    }

    @Test
    public void shouldRenterPointsBeCorrectWhenMoreThanOneDayRentalForReleaseMovie()
    {
        Movie movie = MovieBuilder
                .create()
                .withPriceCode(PriceCodes.NewRelease)
                .build();
        Rental rental = new Rental(movie, 3);

        Customer testee = new Customer("");
        testee.addRental(rental);

        Assert.assertTrue("Check renter points correctness for children movie", testee.buildStatement().contains("2"));
    }

}
