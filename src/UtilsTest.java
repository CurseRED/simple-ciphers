import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    private String expected, actual;

    @Test
    public void cleanTextEng() {
        expected = Utils.cleanTextEng("One two three Four");
        actual = "onetwothreefour";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cleanTextRus() {
        expected = Utils.cleanTextRus("Один два три Четыре Ёлка зелёная");
        actual = "одиндватричетыреёлказелёная";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cleanTextEng_NO_NULL() {
        expected = Utils.cleanTextEng(null);
        Assert.assertNotNull(expected);
    }

    @Test
    public void cleanTextRus_NO_NULL() {
        expected = Utils.cleanTextRus(null);
        Assert.assertNotNull(expected);
    }

    @Test
    public void cleanTextEng_EMPTY() {
        expected = Utils.cleanTextEng("");
        actual = "";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cleanTextRus_EMPTY() {
        expected = Utils.cleanTextRus("");
        actual = "";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cleanTextEng_GARBAGE() {
        expected = Utils.cleanTextEng("123ONe./ TWO ,,,  321 /ThReE!!!:::");
        actual = "onetwothree";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cleanTextRus_GARBAGE() {
        expected = Utils.cleanTextRus("123ОДин./ ДВА ,,,  321 /ТрИ!!!:::");
        actual = "одиндватри";
        Assert.assertEquals(expected, actual);
    }
}