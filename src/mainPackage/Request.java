package mainPackage;

public class Request {
	public int numOfRequests;
	public int IDofVideo;
	public int IDofEndpoint;

	public Request(int numOfRequests, int IDofVideo, int IDofEndpoint) {
		this.numOfRequests = numOfRequests;
		this.IDofVideo = IDofVideo;
		this.IDofEndpoint = IDofEndpoint;
	}

	@Override
	public String toString() {
		return "Request [numOfRequests=" + numOfRequests + ", IDofVideo="
				+ IDofVideo + ", IDofEndpoint=" + IDofEndpoint + "]";
	}

	
	
}
