import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;

public class MovieBuilder {

    private String title;
    private PriceCodes code;

    private MovieBuilder() {
    }

    public static MovieBuilder create()
    {
        return new MovieBuilder();
    }

    public MovieBuilder withTitle(String title){
        this.title = title;
        return this;
    }

    public MovieBuilder withPriceCode(PriceCodes priceCode){
        this.code = priceCode;
        return this;
    }

    public Movie build(){
        return new Movie(title, code);
    }
}
