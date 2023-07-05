package telran.measure.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.measure.*;

class LengthTest {
Length leng1 = new Length(1, LengthUnit.km);
Length leng2 = new Length(500, LengthUnit.m);
Length leng3 = new Length(50_000, LengthUnit.cm);

@BeforeEach
void setUp() throws Exception {
	
}

	@Test
	void testEqualsObject() {
		assertTrue(leng2.equals(leng3));
		assertEquals(leng2, leng3);
		assertNotEquals(leng1, leng2);
	}
	@Test
	void testCompareTo() {
	assertTrue(leng2.compareTo(leng1) < 0);
	assertTrue(leng1.compareTo(leng2) > 0);
	assertTrue(leng2.compareTo(leng3) == 0);
	}
	@Test
	void
	testConvert() {
	Length l = leng3.convert(LengthUnit.m);
	assertEquals(leng2.getAmount(), l.getAmount());
	assertEquals(leng2.getUnit(), l.getUnit());
	}
	@Test
	void testToString() {
	assertEquals("500.0m", leng2.toString());
	}
	@Test
	void testBetween() {
	Length leng = LengthUnit.m.between(leng2, leng1);
	assertEquals(leng.getAmount(), leng2.getAmount());
	assertEquals(leng.getUnit(), leng2.getUnit());
	assertEquals(leng.getUnit(), LengthUnit.m);
	}

}
