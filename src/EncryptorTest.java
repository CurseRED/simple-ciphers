import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EncryptorTest {

    @Test
    public void columnEncrypt() {

    }

    @Test
    public void columnDecrypt() {
    }

    @Test
    public void customGridEncrypt() {
        String plainText = "VisinerIsGood";
        String expected = Encryptor.customGridEncrypt(plainText);
        String actual = "vdsnegiorseio";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void customGridDecrypt() {
    }

    @Test
    public void visenerEncrypt() {
    }

    @Test
    public void visenerDecrypt() {
    }
}