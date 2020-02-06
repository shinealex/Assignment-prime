package jm.shine.rbs.prime.controller;

import jm.shine.rbs.prime.exception.CustomException;
import jm.shine.rbs.prime.model.PrimeNumber;
import jm.shine.rbs.prime.model.PrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeController {

    @Autowired
    PrimeService primeService;

    @GetMapping("primes/{limit}")
    public PrimeNumber getPrimeNumber(@PathVariable Integer limit) throws CustomException {
        return primeService.getPrimeNumber(limit);
    }
}
