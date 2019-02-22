package mainPackage;

public class Video {
	public int ID;
	public int sizeInMB;

	public Video(int ID, int sizeInMB) {
		this.ID = ID;
		this.sizeInMB = sizeInMB;
	}

	@Override
	public String toString() {
		return "Video [ID=" + ID + ", sizeInMB=" + sizeInMB + "]";
	}

}
