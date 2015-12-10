package TwoSigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidSocketAddressTest {

	@Test
	public void testIsValidSocket() {
		
		String trueAddr = "1.2.3.4:2034";
		String falseAddr = "1.2.3.4:201134";
		
		assertEquals(true, ValidSocketAddress.isValidSocket(trueAddr));
		assertEquals(false, ValidSocketAddress.isValidSocket(falseAddr));
	}

	//@Test
	public void testIsValidPort() {
		//fail("Not yet implemented");
		
		
		String truePort = "080";
		String falsePort = "";
	
		
		assertEquals(true, ValidSocketAddress.isValidPort(truePort));
		assertEquals(false, ValidSocketAddress.isValidPort(falsePort));
	}

	//@Test
	public void testIsValidIP() {
		
		String tureIP = "172.5.2.3";
		String falseIP = "0001.6532568.5.6";
		
		assertEquals("True IP Failed",true, ValidSocketAddress.isValidIP(tureIP));
		assertEquals("false IP failed", false, ValidSocketAddress.isValidIP(falseIP));
		
		
		
		//fail("Not yet implemented");
	}

}
