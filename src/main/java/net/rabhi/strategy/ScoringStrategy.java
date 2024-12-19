package net.rabhi.strategy;

import net.rabhi.entities.TypeTransaction;
import net.rabhi.entities.Transaction;

public class ScoringStrategy implements StrategyNotifier {
    private double score=0;
    @Override
    public void notifyStrategy(Transaction transaction) {
        System.out.println("ScoringStrategy");
        if (transaction.getType()== TypeTransaction.VENTE){
            score+=transaction.getMontant();
        }
        else {
            score-=transaction.getMontant();
        }
        System.out.println("le score maintenant est : "+ score);
    }
}
