import testing.VatCalculator;

import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * Created by MM on 8/15/2016.
 */
public class VatCalculatorTest {

    @Test
    public void testGetVatOnAmount(){
        VatCalculator calc = new VatCalculator();

        double expected = 21;

        Assert.assertEquals(calc.getVatOnAmount(100), expected);
        Assert.assertNotEquals(calc.getVatOnAmount(120), expected);
    }
}