package grekz.controller;

import grekz.model.Sudoku;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by juanmend on 10/16/2016.
 */
@RestController
public class SudokuCtrl {

    @RequestMapping(value = "/sudoku", method = RequestMethod.GET)
    public Sudoku sudoku(@RequestParam(value = "state", defaultValue = "default") String state){
        return new Sudoku();
    }

//    @RequestMapping(value = "/sudoku/{}")
}