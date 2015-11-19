import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.Rental;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

/**
 * Created by root on 19.11.2015.
 */
public class RentalTest {
    @Test
    public void shouldRentalContainRightRentalDaysWhenCreated(){
        Movie dummy = mock(Movie.class);
        Rental rental = new Rental(dummy, 4);

        Assert.assertEquals(4, rental.getDaysRented());
    }

    @Test
    public void shouldRentalContainRightMovieWhenCreated(){
        Movie dummy = mock(Movie.class);
        Rental rental = new Rental(dummy, 4);

        Assert.assertEquals(dummy, rental.getMovie());
    }
}
