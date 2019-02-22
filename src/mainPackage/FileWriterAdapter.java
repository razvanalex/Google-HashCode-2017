package mainPackage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class FileWriterAdapter {
	private PrintWriter pw;

	public FileWriterAdapter(String fileName) throws IOException {
		pw = new PrintWriter(new FileWriter(fileName));
	}

	public void writeData(CacheServer[] cacheServers) {

		try {
			int n = 0;
			for (int i = 0; i < cacheServers.length; i++) {
				if (!cacheServers[i].videoCached.isEmpty()) {
					n++;
				}
			}

			pw.println(n);

			for (int i = 0; i < cacheServers.length; i++) {
				if (!cacheServers[i].videoCached.isEmpty()) {
					pw.print(cacheServers[i].ID + " ");
					Iterator<Video> iter = cacheServers[i].videoCached
							.iterator();

					while (iter.hasNext()) {
						pw.print(iter.next().ID + " ");
					}
					pw.print('\n');
				}
			}

		} finally {
			pw.close();

		}

	}
}
