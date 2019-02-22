package mainPackage;

import java.util.ArrayList;
import java.util.List;

public class CacheServer {
	public int ID;
	public int capacity;
	private int crtCapacity;
	
	public List<Video> videoCached;

	public CacheServer(int ID, int capacity) {
		this.ID = ID;
		this.capacity = capacity;
		this.videoCached = new ArrayList<>();
		crtCapacity = 0;
	}

	public boolean addVideo(Video v) {
		if (crtCapacity + v.sizeInMB <= capacity) {
			videoCached.add(v);
			return true;
		} else {
			System.out.println("Cache Server " + ID + " is full!");
			return false;
		}
	}

	@Override
	public String toString() {
		return "CacheServer [ID=" + ID + ", capacity=" + capacity + "]";
	}

}
