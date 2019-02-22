package mainPackage;

import java.util.Arrays;

/**
 * @author razvan
 *
 */
public class StreamingProblem {
	private int V;	// number of videos
	private int E;	// number of endpoints
	private int R;	// number of request descriptions
	private int C;	// number of cache servers
	private int X;	// size of each cache server in megabytes	

	public Video[] videos;
	public CacheServer[] cacheServers;
	public Endpoint[] endpoints;
	public Request[] requests;
	
	/**
	 * Get the number of videos
	 * 
	 * @param v
	 */
	public int getV() {
		return V;
	}

	/**
	 * Set the number of videos
	 * 
	 * @param v
	 */
	public void setV(int v) throws NumberFormatException {
		if (1 <= v && v <= 10000)
			V = v;
		else
			throw new NumberFormatException();
	}

	/**
	 * Get the number of endpoints
	 * 
	 * @return
	 */
	public int getE() {
		return E;
	}

	/**
	 * Set the number of endpoints
	 * 
	 * @param e
	 */
	public void setE(int e) throws NumberFormatException {
		if (1 <= e && e <= 1000)
			E = e;
		else
			throw new NumberFormatException();
	}

	/**
	 * Get the number of request descriptions
	 * 
	 * @return
	 */
	public int getR() {
		return R;
	}

	/**
	 * Set the number of request descriptions
	 * 
	 * @param r
	 */
	public void setR(int r) throws NumberFormatException {
		if (1 <= r && r <= 1000000)
			R = r;
		else
			throw new NumberFormatException();
	}

	/**
	 * Get the number of cache servers
	 * 
	 * @return
	 */
	public int getC() {
		return C;
	}

	/**
	 * Set the number of cache servers
	 * 
	 * @param c
	 */
	public void setC(int c) throws NumberFormatException {
		if (1 <= c && c <= 1000)
			C = c;
		else
			throw new NumberFormatException();
	}

	/**
	 * Get the capacity of each cache server in megabytes
	 * 
	 * @return
	 */
	public int getX() {
		return X;
	}

	/**
	 * Set the capacity of each cache server in megabytes
	 * 
	 * @param x
	 */
	public void setX(int x) throws NumberFormatException {
		if (1 <= x && x <= 500000)
			X = x;
		else
			throw new NumberFormatException();
	}

	@Override
	public String toString() {
		return "StreamingProblem [V=" + V + ", E=" + E + ", R=" + R + ", C=" + C
				+ ", X=" + X + ", videos=" + Arrays.toString(videos)
				+ ", cacheServers=" + Arrays.toString(cacheServers)
				+ ", endpoints=" + Arrays.toString(endpoints) + ", requests="
				+ Arrays.toString(requests) + "]";
	}
	
	
	


}
