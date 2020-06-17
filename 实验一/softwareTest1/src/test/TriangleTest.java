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
* @date 创建时间：2020年4月8日 下午5:15:43
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
					{ 10, 20, 30, "非三角形" }, 
					{ 2, 2, 2, "等边三角形" }, 
					{ 0, 0, 0, "输入错误" }, 
					{ 4, 3, 5, "一般三角形" },
					{ 3, 3, 4, "等腰三角形" }, 
					{ 4, 4, 5, "等腰三角形" }, 
					{ 1, 0, 0, "输入错误" }, 
					{ 1, 1, 1, "等边三角形" },
		});
	}

	@Test
	public void testClassify() {
		assertEquals(this.type, Triangle.classify(a, b, c));
	}


}
