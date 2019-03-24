public class SharedAccount {
    public static void main(String[] args) {
        int[] myWallet = {1, 2, 3}; // 1 dollar, 2 euros, 3 pounds

        Container container = new Container(); // shared container contains a shared int

        for(int m : myWallet){
//            System.out.println("********" +currency[count] + " Transfer Start********" );

            Deposit d = new Deposit(container, m);
            Withdraw w = new Withdraw(container, m);
            d.start();
            w.start();

//            System.out.println("********" + currency[count++]  + " Transfer End********" );
        }
    }
}

class Deposit extends Thread{
    private Container dHold;
    private int balance;

    public Deposit(Container c, int m){
        super("Deposit Money");
        dHold = c;
        balance = m;
    }
    public void run(){
        for(int count = 1; count <= balance; count++){
            dHold.setSharedBalance(count);
        }
    }
}

class Withdraw extends  Thread{
    private Container wHold;
    private int balance;

    public Withdraw(Container c, int m){
        super("Withdraw Money");
        wHold = c;
        balance = m;
    }
    public void run(){
        int val;
        do{
            val = wHold.getSharedBalance();
        }while (val != balance);
    }
}

class Container{
    private int sharedBalance = 0;
    private boolean writeable = true;

    public synchronized void setSharedBalance(int val){ // deposit
        while (!writeable){
            try{
                System.out.println("Waiting for Withdraw...");
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " = " + val+ "\n");
        sharedBalance = val;
        writeable = false;
        notify();

    }
    public synchronized int getSharedBalance(){ // withdraw
        while (writeable){
            try{
                System.out.println("Waiting for Deposit");
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        writeable = true;
        notify();
        System.out.println(Thread.currentThread().getName() + " = " + sharedBalance + "\n");
        return sharedBalance;
    }
}