package net.rabhi.ObserverDesign;

import net.rabhi.entities.Agent;
import net.rabhi.entities.Transaction;

public interface ObserverAgent {
    void notifier(Agent agent, Transaction transaction);
}
