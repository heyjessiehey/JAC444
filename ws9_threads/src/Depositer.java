public class Depositer extends Thread{ // Producer
    private Container dHold;
    private int[] balance;
    private String[] currency;

    public Depositer(Container c, int[] m, String[] cur){
        super("Depositer Money");
        dHold = c;
        balance = m;
        currency = cur;
    }

    @Override
    public void run(){
        int i = 0;
        for(int count = 1; count <= 3; count++){
            dHold.setSharedBalance(count, currency[i++]);
        }
    }
}