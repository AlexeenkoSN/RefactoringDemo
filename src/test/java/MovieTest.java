import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import org.junit.Assert;
import org.junit.Test;

public class MovieTest {
    @Test
    public void shouldPriceAndTitleBeFilledWhenConstructed()
    {
        String expectedTitle = "StarWars";
        PriceCodes expectedPriceCode = PriceCodes.regular;
        Movie testee = new Movie(expectedTitle, expectedPriceCode);

        Assert.assertEquals("Check that title filled", expectedTitle, testee.getTitle());
        Assert.assertEquals("Check that price code filled", expectedPriceCode, testee.getPriceCode());
    }
}
