package net.rabhi.strategy;

import net.rabhi.entities.Transaction;

public interface StrategyNotifier {
    public void notifyStrategy(Transaction transaction);
}
