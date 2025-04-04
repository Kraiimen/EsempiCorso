package org.generation.italy.bankProject.accounting;

import java.util.HashSet;
import java.util.Set;

public class InMemoryClientRepository implements ClientRepository {

    private HashSet<Client> clientHashSet = new HashSet<>();



    @Override
    public Client getByClientCode(String clientCode) throws NullPointerException {
        if(clientHashSet.contains(clientCode)){
            for(Client i : clientHashSet){
                if(i.getClientCode().equals(clientCode)){
                    return i;
                }
            }
        }
        throw new NullPointerException(); //QUESTA è UN ECCEZIONE GENERICA DA SOSTITUIRE

    }

    @Override
    public Set<Client> getByNumAccounts(int numAccounts) {
        HashSet<Client> clientsByNumAccounts= new HashSet<>();
        for(Client i : clientHashSet){
            if(i.getNumberOfAccounts() == numAccounts){
                clientsByNumAccounts.add(i);
            }
        }
        return clientsByNumAccounts;

    }

    @Override
    public Set<Client> getByTotalBalance(double balance) {
        HashSet<Client> clientsByTotalBalance= new HashSet<>();
        for(Client i : clientHashSet){
            if(i.getTotalBalance() >= balance){
                clientsByTotalBalance.add(i);
            }
        }
        return clientsByTotalBalance;
    }

    @Override
    public Set<Client> getAllTaxEvaders() {
        HashSet<Client> taxEvaders = new HashSet<>();
        for(Client i : clientHashSet){
            if(i.isATaxEvader()){
                taxEvaders.add(i);
            }
        }
        return taxEvaders;
    }
}
