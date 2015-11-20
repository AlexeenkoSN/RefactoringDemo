import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.Rental;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class RentalTest {
    @Test
    public void shouldRentalContainRightRentalDaysWhenCreated(){
        Movie dummy = mock(Movie.class);
        Rental rental = new Rental(dummy, 4);

        Assert.assertEquals("Check rental correctness", 4, rental.getDaysRented());
    }

    @Test
    public void shouldRentalContainRightMovieWhenCreated(){
        Movie dummy = mock(Movie.class);
        Rental rental = new Rental(dummy, 4);

        Assert.assertEquals("Check movie correctness" ,dummy, rental.getMovie());
    }
}
