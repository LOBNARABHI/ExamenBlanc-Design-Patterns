package net.rabhi.ObserverDesign;

public interface ObservableAgent {
    void souscription(ObserverAgent observer);
    void removeObserver(ObserverAgent observer);
}
