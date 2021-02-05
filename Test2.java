import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test2 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{9, 2, 3, 4, 4, 1, 4, 0}, true},
                {new int[]{8, 5, 7, 1, 2, 3, 5, 1}, false},
                {new int[]{3, 8, 4, 6}, false}
        });
    }
    private int[] in;
    private boolean out;

    public Test2(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    private Lesson6Task2 task2;

    @Before
    public void startTest() {
        task2 = new Lesson6Task2();
    }

    @Test
    public void testOnly1And4() {
        Assert.assertEquals(Lesson6Task2.FourAndOne(in), out);
    }
}
