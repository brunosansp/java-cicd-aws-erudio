package br.com.brunosan.restwithspringbootandjava.controllers;

import br.com.brunosan.restwithspringbootandjava.exceptions.UnsuportedMathOperationException;
import br.com.brunosan.restwithspringbootandjava.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static br.com.brunosan.restwithspringbootandjava.converters.NumberConverter.convertToDouble;
import static br.com.brunosan.restwithspringbootandjava.converters.NumberConverter.isNumeric;

@RestController
public class MathController {
    
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {
        
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        
        return SimpleMath.sumNumbers(convertToDouble(numberOne), convertToDouble(numberTwo));
    }
    
    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
                              @PathVariable(value = "numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        
        return SimpleMath.subtraction(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
                                @PathVariable(value = "numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        
        return SimpleMath.multiplication(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public Double division(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return SimpleMath.division(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public Double mean(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return SimpleMath.mean(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/squareroot/{number}")
    public Double squareRoot(@PathVariable(value = "number") String number) {
        if (!isNumeric(number)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return SimpleMath.squareRoot(convertToDouble(number));
    }

}
