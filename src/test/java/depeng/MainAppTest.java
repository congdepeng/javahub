package depeng;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainAppTest {

    @Test
    public void testAdd() throws Exception {
        MainApp mainApp = new MainApp();
        assertEquals(mainApp.add(1, 2), 3);
    }
}