package mainPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileReaderAdapter {
	private Scanner fileScanner;
	private StreamingProblem streamingProblem;

	public FileReaderAdapter(String fileName) throws FileNotFoundException {
		fileScanner = new Scanner(new FileReader(fileName));
	}

	public void readData() {
		streamingProblem = new StreamingProblem();

		try {
			// Read first line
			streamingProblem.setV(fileScanner.nextInt());
			streamingProblem.setE(fileScanner.nextInt());
			streamingProblem.setR(fileScanner.nextInt());
			streamingProblem.setC(fileScanner.nextInt());
			streamingProblem.setX(fileScanner.nextInt());

			// Init cache servers
			int numCache = streamingProblem.getC();
			streamingProblem.cacheServers = new CacheServer[numCache];
			for (int i = 0; i < numCache; i++) {
				streamingProblem.cacheServers[i] = new CacheServer(i,
						streamingProblem.getX());
			}

			// Init videos and read second line
			streamingProblem.videos = new Video[streamingProblem.getV()];
			for (int i = 0; i < streamingProblem.getV(); i++) {
				streamingProblem.videos[i] = new Video(i,
						fileScanner.nextInt());
			}

			// Init each endpoint
			streamingProblem.endpoints = new Endpoint[streamingProblem.getE()];
			for (int i = 0; i < streamingProblem.getE(); i++) {
				int latencyToServer = fileScanner.nextInt();
				int numCacheConnected = fileScanner.nextInt();
				streamingProblem.endpoints[i] = new Endpoint(i, latencyToServer,
						numCacheConnected);
				Endpoint endpoint = streamingProblem.endpoints[i];

				for (int j = 0; j < numCacheConnected; j++) {
					int key = fileScanner.nextInt();
					int value = fileScanner.nextInt();
					endpoint.latencyOfCache.put(key, value);
				}
			}

			// Init requests
			streamingProblem.requests = new Request[streamingProblem.getR()];
			for (int i = 0; i < streamingProblem.getR(); i++) {
				int IDofVideoR = fileScanner.nextInt();
				int IDofEndpoint = fileScanner.nextInt();
				int numOfRequests = fileScanner.nextInt();

				streamingProblem.requests[i] = new Request(numOfRequests,
						IDofVideoR, IDofEndpoint);
			}

		} catch (NumberFormatException ex) {
			System.out.println("File format error!");

		} finally {
			fileScanner.close();
		}
	}

	public StreamingProblem getStreamingProblem() {
		return streamingProblem;
	}
}
