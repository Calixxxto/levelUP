import calixxxto.Example;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ExampleTest {
    private Example example = new Example();
    private File temp;

    @Before
    public void prepare() throws IOException {
        example.setValue(777);
        temp = File.createTempFile("test", "test");
    }

    @After
    public void cleanup(){
        if (temp != null) {
            temp.delete();
        }
    }

    @Test
    public void testSum(){
        assertEquals(3, new Example().sum(1, 2));
    }

    @Test
    public void testSum2(){
        assertEquals(3, new Example().sum(1, 2));
    }
    @Test
    public void testSum3(){
        assertEquals(3, new Example().sum(1, 2));
    }
}
