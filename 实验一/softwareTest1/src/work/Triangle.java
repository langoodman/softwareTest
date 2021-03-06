package work;

/**
* @author lan_wh
*
* @Description TODO
*
* @Title: Triangle.java 
*
* @date 创建时间：2020年4月8日 下午5:11:16
*
* @Package work
*
* @ClassName Triangle
*
* @version 1.0.0
*
*/

public class Triangle {

	/**
	 * 判断数值
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static boolean judge( int a , int b , int c ) {
		if( a < 1 || a > 100 || b < 1 || b > 100 || c < 1 || c > 100 ) return false;
		return true;
	}
	public static String classify(int a, int b, int c) {
		if( !judge( a , b , c ) ) return "输入错误";
		else if (!((a + b > c) && (a + c > b) && (b + c > a))) {
			return "非三角形";
		} 
		else if (a == b && a == c && b == c) {
			return "等边三角形";
		} 
		else if (a != b && a != c && b != c) {
			return "一般三角形";
		}
		else {
			return "等腰三角形";
		}
	}


}
