package net.shangtech.studio.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISitePropertyRemoteService extends Remote {
	
	public void refreshSiteProperties() throws RemoteException;
	
}
