import org.junit.Assert;
import org.junit.Test;
import smb.NumberSequence;

public class SequenceTest {

    @Test
    public void testSequence() {
        NumberSequence numberSequence = new NumberSequence(new int[]{1, 2, 3, 7});

        Assert.assertFalse(numberSequence.isSmb());

        numberSequence = new NumberSequence(new int[]{4, 1, 7, 2});

        Assert.assertTrue(numberSequence.isSmb());

        numberSequence = new NumberSequence(new int[]{4, 1, 4, 2});

        Assert.assertFalse(numberSequence.isSmb());
    }
}

