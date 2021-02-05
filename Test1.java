import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test1 {
    @ParameterizedTest
    public static Collection<Object[][]> data() {
        return (Arrays.asList(new Object[][]{
                {new int[]{1, 6, 4, 5, 2, 1, 0}, new int[]{5, 2, 1, 0}},
                {new int[]{4, 3, 7, 5, 4, 4, 1, 9}, new int[]{1, 9}}
        });
    }
    private int[] in;
    private int[] out;

    public Test1(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }
    private Lesson6Task1 task1;
    @Before
    public void startTest() {
        task1 = new Lesson6Task1();
    }
    @Test
    public void testAfterLastFour() {
        Assert.assertArrayEquals(out, Lesson6Task1.AfterLastFour(in));
    }
    @Test(expected = RuntimeException.class)
    public void testAfterLastFourEx() {
        Lesson6Task1.AfterLastFour(new int[] {3, 2, 1, 5, 0, 0, 1, 2})
    }
}