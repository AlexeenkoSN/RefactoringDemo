import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void shouldStatementContainRightPriceWhenRegularMoviePassed(){
        Customer testee = new Customer("");
        Movie movie = new Movie("", PriceCodes.Regular);
        Rental rental = new Rental(movie, 3);
        testee.addRental(rental);

        Assert.assertTrue(testee.Statement().contains("3.5"));
    }
}
