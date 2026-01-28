package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.ArrayList;

public class BlackListThread extends Thread{

    public int serverInit;

    public int serverFin;
    public String host;
    public HostBlacklistsDataSourceFacade skds;
    public int blacklistServerCount;
    ArrayList<Integer> ocurrences;


    public BlackListThread(HostBlacklistsDataSourceFacade skds, int serverInit, int serverFin, String host){
        this.serverInit = serverInit;
        this.serverFin = serverFin;
        this.host = host;
        this.skds = skds;
        blacklistServerCount = 0;
        ocurrences = new ArrayList<Integer>();
    }

    public void run(){
        for(int i = serverInit; i < serverFin; i++) {
            if (skds.isInBlackListServer(i, host)) {
                blacklistServerCount++;
                ocurrences.add(i);
            }
        }
    }

    public int getBlacklistServerCount(){
        return blacklistServerCount;
    }

    public int getServersCounted(){
        return serverFin - serverInit;
    }

    public ArrayList<Integer> getOccurrences(){
        return ocurrences;
    }
}
