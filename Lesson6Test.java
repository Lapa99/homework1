import org.junit.Before;
import org.junit.Test;

public class Lesson6Test {
    private Lesson6Task1 task1;

    @Before
    public void startTest() {
        task1 = new Lesson6Task1();
    }

    @Test(expected = RuntimeException.class)
    public void testAfterLast4Ex() {
        Lesson6Task1.AfterLastFour(new int[]{0, 3, 7, 5, 0, 0, 3, 2});
    }
}