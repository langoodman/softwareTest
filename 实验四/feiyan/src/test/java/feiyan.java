import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
class feiyanTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/feiyan.csv",numLinesToSkip = 1)
    public void testXinGuan(Integer num,String symptom, String contact,String result ) {
        assertEquals(result, feiyan.feiyan(symptom, contact));
    }

}