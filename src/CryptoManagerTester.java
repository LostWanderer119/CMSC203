import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CryptoManagerTester {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVigenere() {
		String result = "";
		result = CryptoManager.vigenereEncryption("IHATECIPHERS", "APPLE");
		assertEquals(result, "IWPEICXESIRH");
		result = CryptoManager.vigenereDecryption("IWPEICXESIRH", "APPLE");
		assertEquals(result, "IHATECIPHERS");
	}
	
	@Test
	public void testCaesar() {
		String result = "";
		result = CryptoManager.caesarEncryption("IHATECIPHERS", 2);
		assertEquals(result, "KJCVGEKRJGTU");
		result = CryptoManager.caesarDecryption("KJCVGEKRJGTU", 2);
		assertEquals(result, "IHATECIPHERS");
	}

	@Test
	public void testPlayfair() {
		String result = "";
	    result = CryptoManager.playfairEncryption("LEO", "APPLE");
	    assertEquals(result, "EBH5");
	    result = CryptoManager.playfairDecryption("EBH5", "APPLE");
	    assertEquals(result, "LEO");
	}
}
