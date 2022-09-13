package stepik.java_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Accountt {
    private final String owner;
    private final long balance;
    private final boolean locked;

    Accountt(String owner, long balance, boolean locked) {
        this.owner = owner;
        this.balance = balance;
        this.locked = locked;
    }

    public static Comparator<Accountt> getComparatorByLockedBalanceAndOwner() {
        // write your code here
        return Comparator.comparing(Accountt::isLocked).thenComparing(Accountt::getBalance, Comparator.reverseOrder()).thenComparing(Accountt::getOwner);
    }

    public String getOwner() {
        return owner;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public String toString() {
        return owner + " " + balance + " " + locked;
    }

    public static void main(String[] args) {
        List<Accountt> accounts = new ArrayList<>();

        accounts.add(new Accountt("Peter", 1000L, false));
        accounts.add(new Accountt("John", 1000L, false));
        accounts.add(new Accountt("Ivan", 8000L, true));
        accounts.add(new Accountt("Helen", 5000L, false));
        accounts.add(new Accountt("Nicole", 3000L, true));

        accounts.sort(Accountt.getComparatorByLockedBalanceAndOwner());

        accounts.forEach(System.out::println);
    }
}
