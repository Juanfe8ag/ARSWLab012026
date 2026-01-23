package edu.eci.arsw.blacklistvalidator;

public class BlackListThread extends Thread{

    public int serverInit;

    public int serverFin;
    public String host;

    public HostBlacklistsDataSourceFacade skds;

    public int blacklistServerCount;

    public BlackListThread(HostBlacklistsDataSourceFacade skds, int serverInit, int serverFin, String host){
        this.serverInit = serverInit;
        this.serverFin = serverFin;
        this.host = host;
        this.skds = skds;
        blacklistServerCount = 0;
    }

    public void run(){
        for(int i = serverInit; i <= serverFin; i++) {
            if (skds.isInBlacklistServer(i, host)) {
                blacklistServerCount++;
            }
        }
    }

    public int getBlacklistServerCount(){
        return blacklistServerCount;
    }
}
