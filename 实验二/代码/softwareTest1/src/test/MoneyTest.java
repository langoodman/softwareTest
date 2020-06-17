package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import work.Money;

/**
* @author lan_wh
*
* @Description TODO
*
* @Title: MoneyTest.java 
*
* @date ����ʱ�䣺2020��4��8�� ����7:56:45
*
* @Package test
*
* @ClassName MoneyTest
*
* @version 1.0.0
*
*/
@RunWith(Parameterized.class)
public class MoneyTest {
	private int qj, qt, qg;
	private String ans;

	@Before
	public void setUp() throws Exception {
	}

	public MoneyTest(int qj, int qt, int qg, String ans) {
		this.qj = qj;
		this.qt = qt;
		this.qg = qg;
		this.ans = ans;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(
				new Object[][] { 
					{ 1, 2, 3, "18.0��Ԫ" }, 
					{ 100, 390, 210, "ǹ��������������" }, 
					{ 13, 21, 38, "293.0��Ԫ" }, 
					{ 10, 23, 22, "203.5��Ԫ" }, 
		});
	}

	@Test
	public void testClassify() {
		assertEquals(this.ans, Money.get(qj, qt, qg));
	}

}
