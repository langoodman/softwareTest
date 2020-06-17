package work;

/**
* @author lan_wh
*
* @Description TODO
*
* @Title: Money.java 
*
* @date ����ʱ�䣺2020��4��8�� ����7:56:36
*
* @Package work
*
* @ClassName Money
*
* @version 1.0.0
*
*/

public class Money {
	private static int qiangji = 45;
	private static int qiangtuo = 30;
	private static int qiangguan = 25;
	public static String get( int qj , int qt , int qg ) {
		double ans = 0.0;
		if( qj == -1 ) return "�������ۻ����";
		else{
			if( qj < 1 || qj > 70 ) return "ǹ��������������";
			if( qt < 1 || qt >= 80 ) return "ǹ��������������";
			if( qg <= 1 || qg >= 90 ) return "ǹ��������������";
			double qjSale = qiangji * qj;
			double qtSale = qiangtuo * qt;
			double qgSale = qiangguan * qg;
			double sum = qjSale + qtSale + qgSale;
			if( sum > 1800 ){
				ans = 0.1 * 1000 + 0.15 * 800 + 0.2 * ( sum - 1800 );
			}
			else if( sum > 1000 ){
				ans = 0.1 * 1000 + 0.15 * ( sum - 1000 );
			}
			else ans = 0.1 * sum;
			return String.valueOf(ans) + "��Ԫ";
		}
		
	}
	
	public static void main(String[] args) {
		System.out.print(get(13,21,38));
	}
	
	
	
	
	
	

}
