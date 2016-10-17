package grekz.controller;

import grekz.model.Sudoku;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by juanmend on 10/16/2016.
 */
@RestController
public class SudokuCtrl {

    @RequestMapping(value = {"/sudoku","/sudoku/"}, method = RequestMethod.GET)
    public Sudoku sudoku(){//@RequestParam(value = "state", defaultValue = "default") String state){
//        System.out.println("calling sudoku simple");
        return new Sudoku("default");
    }

    @RequestMapping(value = {"/sudoku/{state}/move/{move}", "/sudoku/{state}/move/{move}/"})
    public Sudoku sudoku(@PathVariable("state") String state, @PathVariable("move") String move) throws Exception {
//        System.out.println("Calling param state url" + state + "  -  " +  move );
        return new Sudoku(state, move);
    }

    @RequestMapping(value = {"/sudoku/{state}/", "/sudoku/{state}"})
    public Sudoku sudoku(@PathVariable("state") String state ){
//        System.out.println("Calling param state url" + state );
        return new Sudoku(state);
    }
}