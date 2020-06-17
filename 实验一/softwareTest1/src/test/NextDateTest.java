package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import work.NextDate;

/**
* @author lan_wh
*
* @Description TODO
*
* @Title: NextDateTest.java 
*
* @date 创建时间：2020年4月8日 下午5:23:28
*
* @Package test
*
* @ClassName NextDateTest
*
* @version 1.0.0
*
*/
@RunWith(Parameterized.class)
public class NextDateTest {
	private int y, m, d;
	private String nextDay;

	@Before
	public void setUp() throws Exception {
	}

	public NextDateTest(int y, int m, int d, String nextDay) {
		this.y = y;
		this.m = m;
		this.d = d;
		this.nextDay = nextDay;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(
				new Object[][] { 
					{ 2000, 3, 23, "2000 3 24" }, 
					{ 2000, 3, 31, "2000 4 1" }, 
					{ 2000, 4, 30, "2000 5 1" }, 
					{ 2000, 12, 31, "2001 1 1" },
					{ 2001, 2, 28, "2001 3 1" },
					{ 2008, 2, 28, "2008 2 29" },
		});
	}

	@Test
	public void testClassify() {
		assertEquals(this.nextDay, NextDate.getNextDay(y, m, d));
	}
}
