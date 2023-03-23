import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SayNumberTest {
    @Test
    public void testSayNumber() {
        assertEquals("Zero.", SayNumber.sayNumber(0));
        assertEquals("Eleven.", SayNumber.sayNumber(11));
        assertEquals("One million, forty three thousand, two hundred and eighty three.", SayNumber.sayNumber(1043283));
        assertEquals("Ninety trillion, three hundred and seventy six billion, ten thousand and twelve.", SayNumber.sayNumber(90376000010012L));
    }
}
