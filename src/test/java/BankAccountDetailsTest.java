import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


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

}
