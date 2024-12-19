package net.rabhi.strategy;

import net.rabhi.entities.Transaction;

public class DefaultStrategyNotif implements StrategyNotifier {
    @Override
    public void notifyStrategy(Transaction transaction) {
        System.out.println("Strategy par defaut");
    }
}
