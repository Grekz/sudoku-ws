package grekz;

import grekz.controller.SudokuCtrl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author juanmend
 *         Created 10/17/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAppTest {

    @Autowired
    private SudokuCtrl controller;

    @Test
    public void contextLoads() throws Exception{
        assertThat(controller).isNotNull();
    }
}