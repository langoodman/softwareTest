package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import work.Triangle;

/**
* @author lan_wh
*
* @Description TODO
*
* @Title: TriangleTest.java 
*
* @date ����ʱ�䣺2020��4��8�� ����5:15:43
*
* @Package test
*
* @ClassName TriangleTest
*
* @version 1.0.0
*
*/
@RunWith(Parameterized.class)
public class TriangleTest {

	private int a, b, c;
	private String type;

	@Before
	public void setUp() throws Exception {
	}

	public TriangleTest(int a, int b, int c, String type) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.type = type;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(
				new Object[][] { 
					{ 10, 20, 30, "��������" }, 
					{ 2, 2, 2, "�ȱ�������" }, 
					{ 0, 0, 0, "�������" }, 
					{ 4, 3, 5, "һ��������" },
					{ 3, 3, 4, "����������" }, 
					{ 4, 4, 5, "����������" }, 
					{ 1, 0, 0, "�������" }, 
					{ 1, 1, 1, "�ȱ�������" },
		});
	}

	@Test
	public void testClassify() {
		assertEquals(this.type, Triangle.classify(a, b, c));
	}


}
