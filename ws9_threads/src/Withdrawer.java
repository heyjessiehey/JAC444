class Withdrawer extends  Thread{ // Consumer
    private Container wHold;
    private int[] balance;
    private String[] currency;

    public Withdrawer(Container c, int[] m, String[] cur){
        super("Withdrawer Money");
        wHold = c;
        balance = m;
        currency = cur;
    }

    @Override
    public void run(){
        int val;
        int i = 0;
        do{
            val = wHold.getSharedBalance(currency[i++]);
        }while (val != 3);
    }
}