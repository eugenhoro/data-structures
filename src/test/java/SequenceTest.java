import org.junit.Assert;
import org.junit.Test;
import smb.NumberSequence;

public class SequenceTest {

    @Test
    public void testSequence() {
        NumberSequence numberSequence;

        numberSequence = new NumberSequence(new int[]{1, 2, 3, 7, 8, 10, 12, 13});
        Assert.assertFalse(numberSequence.isSmb());

        numberSequence = new NumberSequence(new int[]{4, 1, 7});
        Assert.assertFalse(numberSequence.isSmb());

        numberSequence = new NumberSequence(new int[]{4, 1, 7, 8, 10, 12, 14, 9});
        Assert.assertTrue(numberSequence.isSmb());

        numberSequence = new NumberSequence(new int[]{4, 1, 4, 1, 4, 1, 4, 1, 3});
        Assert.assertTrue(numberSequence.isSmb());
    }
}

