package work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
public class CallTime {
	private static String startingTime;
	private static String endingTime;
	private static long minute;//通话时长
	public static Date startT;
	public static Date endT;
	public CallTime(String startingTime,String endingTime){
		CallTime.startingTime = startingTime;
		CallTime.endingTime = endingTime;
		CallTime.startT = StrToDate(CallTime.startingTime);
		CallTime.endT = StrToDate(CallTime.endingTime);
	}
	
	public static Date StrToDate(String str) {
		   SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		   Date date = null;
		   try {
		    date = format.parse(str);
		   } catch (ParseException e) {
		    e.printStackTrace();
		   }
		   return date;
		}
	public static String DateFormate(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		String sdate = format.format(date);
		return sdate;
	}
	public static long getHoldingTime(){
		long between;
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(startT);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(endT);
		
		between = cal2.getTime().getTime()-cal1.getTime().getTime();
		if(between<0)
			minute =( (cal2.getTime().getTime()-cal1.getTime().getTime())/1000)/60;//得到通话时长
		else
			minute = (between/1000+59)/60;
		//判断接通时间是否在发生转换的日期
		if((cal1.get(Calendar.MONTH) ==Calendar.MARCH && cal1.get(Calendar.DATE) >= 29 && cal1.get(Calendar.DATE) <= 31 && cal1.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
			|| ((cal1.get(Calendar.MONTH) ==Calendar.APRIL && cal1.get(Calendar.DATE) >= 1 && cal1.get(Calendar.DATE) <= 4 && cal1.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)))
		{
			System.out.println("需要转换1");
			if(cal1.get(Calendar.HOUR_OF_DAY)<2 && cal2.get(Calendar.HOUR_OF_DAY)>=3)
				minute -=60;//时间从2点转换到3点减去1h
		}else{
			if((cal2.get(Calendar.MONTH) ==3 && cal2.get(Calendar.DATE) >= 29 && cal2.get(Calendar.DATE) <= 31 && cal2.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
					|| ((cal2.get(Calendar.MONTH) ==4 && cal2.get(Calendar.DATE) >= 1 && cal2.get(Calendar.DATE) <= 4 && cal2.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)))
				//判断结束时间是否在转换的日期
			{
				if(cal2.get(Calendar.HOUR_OF_DAY)>3 )
					minute -=60;
			}
		}
		//将位于转换的时间段内的时间都看作已经转换之后的
		if(cal1.get(Calendar.MONTH) ==Calendar.OCTOBER && cal1.get(Calendar.DATE) >= 25 && cal1.get(Calendar.DATE) <= 31 && cal1.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
		{
			if(cal1.get(Calendar.HOUR_OF_DAY) ==2){
						minute +=60;
			}
		}else{
			if(cal2.get(Calendar.MONTH) ==Calendar.OCTOBER && cal2.get(Calendar.DATE) >= 25 && cal2.get(Calendar.DATE) <= 31 && cal2.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
			{
				if(cal2.get(Calendar.HOUR_OF_DAY)==2)
				{
						minute +=60;
				}
			}
		}
		if(minute>1200 || minute <0){
			System.out.println("时间错误，时限范围不对！");
			return 0;
		}else{
			return minute;
		}
	}
	
	public static String ans() throws IOException {
		
		double telFee;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//字符输入流
		String sd1=br.readLine();//按行读入
		String sd2=br.readLine();
		CallTime ht = new CallTime(sd1,sd2);
		//System.out.println("电话接通时间："+ht.DateFormate(ht.startT));
		//System.out.println("电话结束时间："+ht.DateFormate(ht.endT));
			
		DecimalFormat    df   = new DecimalFormat("0.00"); 
		long minute = ht.getHoldingTime();
		//计算话费
		if(minute <= 20){
			telFee = 0.05*minute;
		}
		else{
			telFee = 1.00 + (minute - 20)*0.1;
		}
//		return "通话时间为："+minute+"分钟" + "本次通话话费为："+df.format(telFee)+"美元";
		return df.format(telFee);
		
	}
}
