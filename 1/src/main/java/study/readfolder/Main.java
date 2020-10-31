package study.readfolder;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		WatchingPaths a = new WatchingPaths("D:\\테스트\\");
		a.watchFolder();
	}
}
