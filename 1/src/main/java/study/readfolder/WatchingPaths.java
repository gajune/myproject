package study.readfolder;

import java.io.IOException;

import java.nio.file.FileSystem;

import java.nio.file.FileSystems;

import java.nio.file.Path;

import java.nio.file.StandardWatchEventKinds;

import java.nio.file.WatchEvent;

import java.nio.file.WatchKey;

import java.nio.file.WatchService;

import java.util.List;

public class WatchingPaths {
	String folderlocate;

	public WatchingPaths(String folderlocate) {
		// TODO Auto-generated constructor stub
		this.folderlocate = folderlocate;
	}

	public void watchFolder() throws IOException {
		FileSystem fs = FileSystems.getDefault();
		Path watchPath = fs.getPath(folderlocate);
		WatchService watchService = fs.newWatchService();
		watchPath.register(watchService,
				StandardWatchEventKinds.ENTRY_CREATE);
				//StandardWatchEventKinds.ENTRY_MODIFY,
				//StandardWatchEventKinds.ENTRY_DELETE);
		while (true) {
			try {
				// 지정된 디렉토리에 변경이되는지 이벤트를 모니터링한다.
				WatchKey changeKey = watchService.take();
				List<WatchEvent<?>> watchEvents = changeKey.pollEvents();
				for (WatchEvent<?> watchEvent : watchEvents) {
					// Ours are all Path type events:
					WatchEvent<Path> pathEvent = (WatchEvent<Path>) watchEvent;
					Path path = pathEvent.context();
					WatchEvent.Kind<Path> eventKind = pathEvent.kind();
					if (eventKind.name().equals("ENTRY_CREATE")) {
						AboutFile f = new AboutFile(folderlocate , path );
						System.out.println(new String(f.readfile()));
						f.deletefile();
					}
					//System.out.println(eventKind + " for path: " + path);
				}
				 changeKey.reset(); // Important!
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// public static void main(String[] args) throws IOException {
//
// FileSystem fs = FileSystems.getDefault();
//
// Path watchPath = fs.getPath("D:\\테스트");
//
// WatchService watchService = fs.newWatchService();
//
// watchPath.register(watchService,
//
// StandardWatchEventKinds.ENTRY_CREATE,
//
// StandardWatchEventKinds.ENTRY_MODIFY,
//
// StandardWatchEventKinds.ENTRY_DELETE);
//
// while (true) {
//
// try {
//
// // 지정된 디렉토리에 변경이되는지 이벤트를 모니터링한다.
//
// WatchKey changeKey = watchService.take();
//
// List<WatchEvent<?>> watchEvents = changeKey.pollEvents();
//
// for (WatchEvent<?> watchEvent : watchEvents) {
//
// // Ours are all Path type events:
//
// WatchEvent<Path> pathEvent = (WatchEvent<Path>) watchEvent;
//
// Path path = pathEvent.context();
//
// WatchEvent.Kind<Path> eventKind = pathEvent.kind();
// if(eventKind.equals("ENTRY_CREATE") || eventKind.equals("ENTRY_MODIFY")){
//
// }
// System.out.println(eventKind + " for path: " + path);
//
// }
//
// changeKey.reset(); // Important!
//
// } catch (InterruptedException e) {
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
// }
