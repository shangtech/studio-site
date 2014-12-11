package net.shangtech.studio.remote;

import java.rmi.Remote;

public interface ISitePropertyRemoteService extends Remote {
	
	public void refreshSiteProperties();
	
}
