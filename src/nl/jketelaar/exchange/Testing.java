package nl.jketelaar.exchange;

import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * @author JKetelaar
 */
public class Testing {

    /**
     * Void to test the API
     */
    public static void main(String[] args) throws IOException, ParseException {
        long ts = System.currentTimeMillis();
        System.out.println(Exchange.getPrice(558, true).getName());
        System.out.println(System.currentTimeMillis() - ts + "ms without cache\n");

        ts = System.currentTimeMillis();
        System.out.println(Exchange.getPrice(558, true).getName());
        System.out.println(System.currentTimeMillis() - ts + "ms with cache\n");

        ts = System.currentTimeMillis();
        System.out.println(Exchange.getPrice(558, false).getName());
        System.out.println(System.currentTimeMillis() - ts + "ms without cache, but with cached items\n");
    }
}
