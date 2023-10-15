package ExtentReportDemo;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class TestExample {
	@Test
	public void testMethod01() {
		System.out.println("This is test method one");
		Assert.assertTrue(true);
	}
	@Test
	public void testMethodo2() {
		System.out.println("This is test method 02");
		Assert.assertTrue(false);
		
	}
	@Test
	public void testMethod03() {
		System.out.println("This is test method 03");
		Assert.assertTrue(false);
	}
	@Test
	public void testMethod04() {
		System.out.println("This is test method 04");
		Assert.assertTrue(true);
	}
	@Test
	public void testMethod05() {
		System.out.println("This is test method 05");
		throw new SkipException("This test 05 is Skipped");
	}

}
