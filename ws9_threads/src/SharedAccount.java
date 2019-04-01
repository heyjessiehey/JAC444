public class SharedAccount {
    public static void main(String[] args) {
        int[] myWallet = {1, 2, 3}; // 1 dollar, 2 euros, 3 pounds
        String[] currency = {"dollar", "euros", "pounds"};

        Container container = new Container(); // shared container contains a shared int

        Depositer d = new Depositer(container, myWallet, currency);
        Withdrawer w = new Withdrawer(container,myWallet, currency);
        d.start();
        w.start();
    }
}
