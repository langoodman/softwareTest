package test8;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class feiyanTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/feiyan.csv",numLinesToSkip = 1)
    public void testXinGuan(Integer num,String illness, String content,String result ) {
        assertEquals(feiyan.feiyan(illness, content),result);
    }
}
