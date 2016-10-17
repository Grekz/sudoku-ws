package grekz.controller;

import grekz.enumeration.BoardEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author juanmend
 *         Created 10/17/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SudokuCtrlTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void completedSudokuShouldReturnSolvedFlag() throws Exception{
        this.mockMvc.perform(get("/sudoku/" + BoardEnum.SOLVED.getState()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.validGrid").value(true))
                .andExpect(jsonPath("$.solved").value(true));
    }

    @Test
    public void completeSudokuWithOneMoveAndShouldReturnSolvedFlag() throws Exception{
        this.mockMvc
            .perform(get("/sudoku/" + BoardEnum.ONE_TO_SOLVE.getState() + "/move/005"))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(
                jsonPath("$.solved").value(true))
            .andExpect(
                jsonPath("$.validGrid").value(true))
            .andExpect(
                jsonPath("$.previousState").value("/sudoku/" + BoardEnum.ONE_TO_SOLVE.getState()))
            .andExpect(
                jsonPath("$.state").value("/sudoku/" + BoardEnum.SOLVED.getState()));
    }

    @Test
    public void getDefaultSudokuShouldReturnValidGridNotSolved() throws Exception{
        this.mockMvc.perform(get("/sudoku"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.solved").value(false))
                .andExpect(jsonPath("$.validGrid").value(true))
                .andExpect(jsonPath("$.state").value("/sudoku/" + BoardEnum.DEFAULT.getState()));
    }

    @Test
    public void invalidGridAfterOneMove() throws Exception{
        this.mockMvc.perform(get("/sudoku/" + BoardEnum.VALID_FIRST_ROW.getState() + "/move/003"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.solved").value(false))
                .andExpect(jsonPath("$.validGrid").value(false))
                .andExpect(jsonPath("$.state").value("/sudoku/" + BoardEnum.INVALID_FIRST_ROW.getState()))
                .andExpect(jsonPath("$.previousState").value("/sudoku/" + BoardEnum.VALID_FIRST_ROW.getState()));
    }

}