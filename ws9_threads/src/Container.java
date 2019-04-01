class Container{
    private int sharedBalance = 0;
    private boolean writeable = true;

    public synchronized void setSharedBalance(int val, String cur){ // Depositer
        while (!writeable){
            try{
                System.out.println("Waiting for Withdraw...");
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() +  " " + val + " " + cur + "\n");
        sharedBalance = val;
        writeable = false;
        notify();

    }
    public synchronized int getSharedBalance(String cur){ // Withdrawer
        while (writeable){
            try{
                System.out.println("Waiting for Deposit...");
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        writeable = true;
        notify();
        System.out.println(Thread.currentThread().getName() + " "  + sharedBalance + " " + cur + "\n");
        return sharedBalance;
    }
}