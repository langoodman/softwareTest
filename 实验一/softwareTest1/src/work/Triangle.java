package work;

/**
* @author lan_wh
*
* @Description TODO
*
* @Title: Triangle.java 
*
* @date ����ʱ�䣺2020��4��8�� ����5:11:16
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
	 * �ж���ֵ
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
		if( !judge( a , b , c ) ) return "�������";
		else if (!((a + b > c) && (a + c > b) && (b + c > a))) {
			return "��������";
		} 
		else if (a == b && a == c && b == c) {
			return "�ȱ�������";
		} 
		else if (a != b && a != c && b != c) {
			return "һ��������";
		}
		else {
			return "����������";
		}
	}


}
