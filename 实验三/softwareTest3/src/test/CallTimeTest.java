package test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TelFeeTest {
	@ParameterizedTest
	@CsvFileSource(resources = "Call.csv",numLinesToSkip = 1)
	public void testTelFee(Integer num,String startDate, String endDate, String retValue) {
		assertEquals(retValue, TelFee.bill(startDate, endDate));
	}
}