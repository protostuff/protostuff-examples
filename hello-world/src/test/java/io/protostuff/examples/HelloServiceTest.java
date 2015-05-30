package io.protostuff.examples;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@code HelloService}
 *
 * @author Kostiantyn Shchepanovskyi
 */
public class HelloServiceTest {

    public static final byte[] REQUEST = new byte[]{0x0A, 0x03, '4', '2', '!'};
    public static final byte[] RESPONSE = new byte[]{0x0A, 0x0A, 'H', 'e', 'l', 'l', 'o', ',', ' ', '4', '2', '!'};

    private HelloService service;

    @Before
    public void setUp() throws Exception {
        service = new HelloService();
    }

    @Test
    public void testSearch() throws Exception {
        byte[] responseData = service.hello(REQUEST);
        Assert.assertArrayEquals(RESPONSE, responseData);
    }

}