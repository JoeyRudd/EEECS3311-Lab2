package lab02;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SodaCanTest {
	static SodaCan s;

	@Test(timeout = 100)
	// @Description(description = "SodaCan Test initialize")
	public void testInitCan() {
		s = new SodaCan("Roots");

		assertTrue(!s.isOpen());
		assertTrue(s.getAmount() == 250);
	}

	@Test(timeout = 100)
	// @Description(description = "SodaCan Test gulp closed")
	public void testGulpClosed() {
		s = new SodaCan("Roots");

		s.gulp();
		assertTrue(s.isOpen() == false);
		assert (s.getAmount() == 250);
	}

	@Test(timeout = 100)
	// @Description(description = "SodaCan Test sip closed")
	public void testSipClosed() {
		s = new SodaCan("Roots");

		s.sip();
		assertTrue(s.isOpen() == false);
		assert (s.getAmount() == 250);
	}

	@Test(timeout = 100)
	// @Description(description = "SodaCan Test does open")
	public void testDoesOpen() {
		s = new SodaCan("Roots");

		s.open();
		assertTrue(s.isOpen());
	}

	@Test(timeout = 100)
	// @Description(description = "SodaCan Test gulp closed")
	public void testGulp() {
		s = new SodaCan("Roots");

		s.open();
		assertTrue(s.gulp() == 50);
	}

	@Test(timeout = 100)
	// @Description(description = "SodaCan Test single sip")
	public void testSip() {
		s = new SodaCan("Roots");

		s.open();
		assertTrue(s.sip() == 10);
	}

	@Test(timeout = 100)
	// @Description(description = "SodaCan Test single sip single gulp")
	public void testGulpSip() {
		s = new SodaCan("Roots");

		s.open();
		s.gulp();
		s.sip();
		assertTrue(s.getAmount() == 250 - 60);
	}

	@Test(timeout = 100)
	// @Description(description = "SodaCan Test sip amount non-negative: 6 gulps")
	public void testGulpNegative() {
		s = new SodaCan("Roots");

		s.open();
		s.gulp();
		s.gulp();
		s.gulp();
		s.gulp();
		s.gulp();
		s.gulp();
		assertTrue(s.getAmount() == 0);
	}

	@Test(timeout = 100)
	// @Description(description = "SodaCan Test sip amount non-negative: 26 sips")
	public void testSipNegative() {
		s = new SodaCan("Roots");

		s.open();
		for (int i = 0; i < 26; i++) {
			s.sip();
		}
		assertTrue(s.getAmount() == 0);
	}

	@Test(timeout = 100)
	// @Description(description = "SodaCan Test gulp non-negative: 23 sips 1 gulp")
	public void testGulpRemaining() {
		s = new SodaCan("Roots");

		s.open();
		for (int i = 0; i < 23; i++) {
			s.sip();
		}
		s.gulp();
		assertTrue(s.getAmount() == 0);
	}

	@Test(timeout = 100)
	// @Description(description = "SodaCan Test has name")
	public void testHasName() {
		s = new SodaCan("Roots");

		assertTrue(s.toString().contains("Roots"));
	}
}
