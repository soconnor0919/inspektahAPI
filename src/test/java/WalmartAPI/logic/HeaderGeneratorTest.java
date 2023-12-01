/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King
 *
 * Names: O'Connor, Sean
 *        Sanders, Alec
 *        Gaines, Geoffrey
 *        Finkler, Aidan
 *
 * Project: csci205_final_project
 * Package: WalmartAPI.logic
 * Class: HeaderGeneratorTest
 *
 * Description:
 * A class that tests the HeaderGenerator class.
 * ****************************************
 */

package WalmartAPI.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that tests the HeaderGenerator class.
 */
class HeaderGeneratorTest {
    /** HeaderGenerator Instance */
    private HeaderGenerator generator;

    /**
     * Set up the test.
     *
     * @throws IOException If an error occurs during the API request or response processing.
     */
    @BeforeEach
    void setUp() throws IOException {
        generator = new HeaderGenerator();
    }

    /**
     * Test the readFileFromResources method.
     */
    @Test
    void readFileFromResources() {
        String content = generator.readFileFromResources("/testText");
        assertEquals("exampleTextFileContents", content);
    }

    /**
     * Test the extractPrivateKey method.
     */
    @Test
    void extractPrivateKey() {
        String key = generator.extractPrivateKey("-----BEGIN PRIVATE KEY-----TESTSTRING-----END PRIVATE KEY-----");
        assertEquals("TESTSTRING", key);
    }

    /**
     * Test the getHeaders method.
     */
    @Test
    void getHeaders() {
        assertTrue(generator.getHeaders().containsKey("WM_CONSUMER.ID"));
        assertTrue(generator.getHeaders().containsKey("WM_CONSUMER.INTIMESTAMP"));
        assertTrue(generator.getHeaders().containsKey("WM_SEC.KEY_VERSION"));
        assertTrue(generator.getHeaders().containsKey("WM_SEC.AUTH_SIGNATURE"));
    }
}