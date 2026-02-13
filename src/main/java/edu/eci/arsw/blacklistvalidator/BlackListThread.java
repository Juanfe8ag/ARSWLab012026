package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class BlackListThread extends Thread{

    public int serverInit;
    public int current;
    public int serverFin;
    public String host;
    public HostBlacklistsDataSourceFacade skds;
    public AtomicInteger blacklistServerCount;
    public AtomicBoolean blacklistedServer;
    public AtomicInteger blacklistedServerCount;
    public int BLACK_LIST_SERVER_COUNT;
    ArrayList<Integer> ocurrences;


    public BlackListThread(HostBlacklistsDataSourceFacade skds, int serverInit, int serverFin, String host, AtomicInteger blacklistServerCount, AtomicBoolean blacklistedServer, AtomicInteger blacklistedServerCount, int BLACK_LIST_SERVER_COUNT){
        this.serverInit = serverInit;
        this.serverFin = serverFin;
        this.host = host;
        this.skds = skds;
        this.blacklistServerCount = blacklistServerCount;
        this.blacklistedServer = blacklistedServer;
        this.BLACK_LIST_SERVER_COUNT = BLACK_LIST_SERVER_COUNT;
        this.blacklistedServerCount = blacklistedServerCount;
        ocurrences = new ArrayList<Integer>();
    }

    public void run(){
        for(int i = serverInit; i < serverFin; i++) {
            if(blacklistedServer.get()) {break;}
            blacklistedServerCount.incrementAndGet();
            if (skds.isInBlackListServer(i, host)) {
                current = blacklistServerCount.incrementAndGet();
                ocurrences.add(i);
            }
            if (current >= BLACK_LIST_SERVER_COUNT){
                blacklistedServer.set(true);
                break;
            }
        }
    }

    public AtomicInteger getBlacklistServerCount(){
        return blacklistServerCount;
    }

    public int getServersCounted(){
        return blacklistedServerCount.get();
    }

    public ArrayList<Integer> getOccurrences(){
        return ocurrences;
    }
}
