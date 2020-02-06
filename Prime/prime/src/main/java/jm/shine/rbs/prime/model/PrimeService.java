package jm.shine.rbs.prime.model;

import jm.shine.rbs.prime.exception.CustomException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class PrimeService {

    public PrimeNumber getPrimeNumber(Integer limit)  throws CustomException {
        if(limit > 1000000)
            throw new CustomException(
                "I cannot handle this value",
                "You've entered an incorrect number, please try 10, 100 even 10000 :-)",
                "Validate the given Input",
                "For safe side Limit set to One Lakh, this can be increased based on the Resource available",
                "mail to shinekuttiadi@gmail.com");

        return getPrimesFinderMethod(limit);
    }

    /**
     * Concurrently find the prime numbers !!
     *
     */
    @Cacheable(value = "primNumber", key = "#limit")
    public PrimeNumber getPrimesFinderMethod( Integer limit) {

        PrimeNumber number = new PrimeNumber(limit, new LinkedList<>());

        number.setPrimeNumbers(Stream
                .iterate(2, n -> n + 1)
                .parallel()
                .limit(limit)
                .filter(PrimeService :: isPrime)
                .collect(Collectors.toList()));

        return number;
    }

    private  static boolean isPrime(Integer input) {
        return IntStream.range(2, input).noneMatch(i -> input % i == 0);
    }
}
