package br.com.brunosan.restwithspringbootandjava;

import br.com.brunosan.restwithspringbootandjava.exceptions.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
//        return 1D;
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
        
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
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
        
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
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
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
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
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }
    
    @RequestMapping(value = "/squareroot/{number}")
    public Double squareRoot(@PathVariable(value = "number") String number) {
        if (!isNumeric(number)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(convertToDouble(number));
    }
    
    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        // BR 10,25 US 10.25
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }
    
    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
//        return Double.isNaN(Double.parseDouble(strNumber));
    }
}
