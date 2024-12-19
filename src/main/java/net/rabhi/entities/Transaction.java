package net.rabhi.entities;

import java.util.Date;

public class Transaction {
    private int id;
    private Date date;
    private double montant;
    private TypeTransaction type;

    public Transaction(int id, Date date, double montant, TypeTransaction type) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.type = type;
    }

    public Transaction() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public TypeTransaction getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", montant=" + montant +
                ", type=" + type +
                '}';
    }


    public TransactionBuilder builder(){
        return new TransactionBuilder();
    }

    public static class TransactionBuilder {
        private Transaction transaction = new Transaction();

        public TransactionBuilder id(int id) {
            transaction.setId(id);
            return this;
        }
        public TransactionBuilder date(Date date) {
            transaction.setDate(date);
            return this;
        }
        public TransactionBuilder montant(double montant) {
            transaction.setMontant(montant);
            return this;
        }
        public TransactionBuilder type(TypeTransaction type) {
            transaction.setType(type);
            return this;
        }
        public Transaction build(){
            return this.transaction;
        }
    }
}


