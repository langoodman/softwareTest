package work;

/**
* @author lan_wh
*
* @Description TODO
*
* @Title: NextDate.java 
*
* @date ����ʱ�䣺2020��4��8�� ����5:23:17
*
* @Package work
*
* @ClassName NextDate
*
* @version 1.0.0
*
*/

public class NextDate {
	/**
	 * �ж��ǲ�������
	 * @param y
	 * @return
	 */
	public static boolean isRunNian(int y) {
		if( ( y % 4 == 0 && y % 100 != 0 ) || y % 400 == 0 ) return true;
		return false;
	}
	/**
	 * ���ǲ����������һ��
	 * @param y
	 * @param m
	 * @param d
	 * @return
	 */
	public static boolean isLastDay( int y , int m , int d ) {
		if( m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12 ){
			return d == 31;
		}
		else{
			if( isRunNian(y) ){
				if( m == 2 ) return d == 29;
			}
			else{
				if( m == 2 ) return d == 28;
			}
			return d == 30;
		}
	}
	/**
	 * ��һ��
	 * @param y
	 * @param m
	 * @param d
	 * @return
	 */
	public static String getNextDay( int y , int m , int d ) {
		if( m <= 0 || m > 12 || d > 31 || d <= 0 || y > 2050 || y < 1900 ) return "�������";
		if( m != 12 ){
			if( isLastDay( y , m , d ) ){
				m++;
				d = 1;
				return y + " " + m + " " + d;
			}
			else{
				d++;
				return y + " " + m + " " + d;
			}
		}
		else{
			if( isLastDay( y , m , d ) ){
				y++;
				d = 1;
				m = 1;
				return y + " " + m + " " + d;
			}
			else{
				d++;
				return y + " " + m + " " + d;
			}
		}
	}
	
	
	
	
	

}
