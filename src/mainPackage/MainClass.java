package mainPackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MainClass {

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(
			Map<K, V> map) {
		return map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(
						Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
								(e1, e2) -> e1, LinkedHashMap::new));
	}

	public static void cacheData(StreamingProblem sp) {
		HashMap<Integer, List<Request>> requests = new HashMap<>();
		HashMap<Integer, List<CacheServer>> cacheServers = new HashMap<>();
		int maxLen = 0;

		for (int e = 0; e < sp.getE(); e++) {
			Endpoint endpoint = sp.endpoints[e];

			// Create HashMap of requests
			List<Request> listRequests = new ArrayList<>();
			for (int r = 0; r < sp.getR(); r++) {
				if (sp.requests[r].IDofEndpoint == endpoint.ID) {
					listRequests.add(sp.requests[r]);
				}
			}

			if (maxLen < listRequests.size()) {
				maxLen = listRequests.size();
			}

			listRequests.sort(new Comparator<Request>() {
				@Override
				public int compare(Request o1, Request o2) {
					return o1.numOfRequests < o2.numOfRequests ? 1
							: o1.numOfRequests > o2.numOfRequests ? -1 : 0;
				}
			});

			requests.put(endpoint.ID, listRequests);

			// Create HashMap of cache servers
			List<CacheServer> listServers = new ArrayList<>();

			for (Entry<Integer, Integer> element : sortByValue(
					endpoint.latencyOfCache).entrySet()) {

				for (CacheServer c : sp.cacheServers) {
					if (c.ID == element.getKey()) {
						listServers.add(c);
					}
				}
			}

			cacheServers.put(endpoint.ID, listServers);
		}

		for (int i = 0; i < maxLen; i++) {
			for (int j = 0; j < sp.getE(); j++) {
				if (i < requests.get(j).size()) {
					Request r = (requests.get(j).get(i));
					Video v = sp.videos[r.IDofVideo];
					
					for (CacheServer c : cacheServers.get(j)) {
						if (c.addVideo(v)) {
							break;
						}
					}

				} else {
					continue;
				}
			}
		}

	}

	public static void main(String[] args) {
		FileReaderAdapter fra = null;
		FileWriterAdapter fwa = null;

		try {
			fra = new FileReaderAdapter("data.in");
			fra.readData();
			StreamingProblem sp = fra.getStreamingProblem();
			System.out.println(sp);

			cacheData(sp);

			fwa = new FileWriterAdapter("data.out");
			fwa.writeData(sp.cacheServers);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
