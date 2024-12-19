package net.rabhi.strategy;

import net.rabhi.entities.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HystoryStrategy implements StrategyNotifier {
    private List<Transaction> transactionsHystory=new ArrayList<>();
    @Override
    public void notifyStrategy(Transaction transaction) {
        System.out.println("Hystory Strategy Notified");
        transactionsHystory.add(transaction);
        System.out.println("voila la list des transactions : "+ transactionsHystory.toString());
    }
}
