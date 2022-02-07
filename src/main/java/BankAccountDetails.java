import java.util.ArrayList;
import java.util.List;
public class BankAccountDetails {private static Double AccountBal=0.00;
   public String date;
   public Double cashDeposited;
   public Double cashWithdrawn;
   public List<String> st=new ArrayList<String>();

    public void credit(Double currentCredit,String currentDate)
    {   if(currentCredit<0.0){
            throw new IllegalArgumentException("Are you kidding me?");
        }
        this.cashDeposited=currentCredit;
        this.date=currentDate;
        AccountBal=AccountBal+currentCredit;
        this.cashWithdrawn=0.00;

    }
    public void debit(Double currentDebit,String currentDate)
    {
        if(currentDebit<0.0)
        {
            throw new IllegalArgumentException("Are you comedy me");
        }
        this.cashWithdrawn=currentDebit;
        this.date=currentDate;
        this.cashDeposited=0.00;
        if(currentDebit>AccountBal)
        {
            throw new IllegalArgumentException("Account Bal low");
        }
        else
            AccountBal=AccountBal-currentDebit;
    }
    public void addStatement()
    {
     String state=date+"||";
     state=state+ Double.toString(cashDeposited)+"||";
     state=state+ Double.toString(cashWithdrawn)+"||";
     state=state+ Double.toString(AccountBal);
     st.add(state);
    }
    public List<String> getStatement()
    {
        return st;
    }

}
