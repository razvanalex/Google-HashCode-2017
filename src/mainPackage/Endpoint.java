package mainPackage;

import java.util.HashMap;

public class Endpoint {
	public int ID;
	public int latencyToDataCenter;
	public int numCacheServerConnected;

	public HashMap<Integer, Integer> latencyOfCache;

	public Endpoint(int ID, int latencyToDataCenter,
			int numCacheServerConnected) {
		this.ID = ID;
		this.latencyToDataCenter = latencyToDataCenter;
		this.numCacheServerConnected = numCacheServerConnected;
		latencyOfCache = new HashMap<>(numCacheServerConnected);
	}

	@Override
	public String toString() {
		return "Endpoint [ID=" + ID + ", latencyToDataCenter="
				+ latencyToDataCenter + ", numCacheServerConnected="
				+ numCacheServerConnected + ", latencyOfCache=" + latencyOfCache
				+ "]";
	}

}
