import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class BankAccountDetailsTest {
    @Test
    public void checkForError()
    {
       BankAccountDetails test1=new BankAccountDetails();
        Assert.assertThrows(IllegalArgumentException.class,()->{
            test1.debit(555.67,"06-07-2022");
        });
    }
    @Test
    public void checkIfValid()
    {
        BankAccountDetails test1=new BankAccountDetails();
        test1.credit(7777.98,"06-07-2023");
        test1.addStatement();
        test1.debit(789.00,"02-07-2024");
        test1.addStatement();
        List<String> checkFy=new ArrayList<String>();
        checkFy.add("06-07-2023||7777.98||0.0||7777.98");
        checkFy.add("02-07-2024||0.0||789.0||6988.98");
        Assert.assertEquals(checkFy,test1.getStatement());
    }
    @Mock
    BankAccountDetails mockitoTest1=mock(BankAccountDetails.class);
    @Test
    public void checkIfValid1()
    {
        mockitoTest1.credit(7777.98,"06-07-2023");
        mockitoTest1.addStatement();
        mockitoTest1.debit(789.00,"02-07-2024");
        mockitoTest1.addStatement();
        List<String> checkFy=new ArrayList<String>();
        checkFy.add("06-07-2023||7777.98||0.0||7777.98");
        checkFy.add("02-07-2024||0.0||789.0||6988.98");
        when(mockitoTest1.getStatement()).thenReturn(checkFy);
        verify(mockitoTest1).getStatement();
    }

}
