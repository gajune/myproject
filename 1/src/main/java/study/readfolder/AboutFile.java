package study.readfolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class AboutFile {
	Path filename;
	String folderlocate;

	public AboutFile(String folderlocate , Path path) {
		// TODO Auto-generated constructor stub
		this.filename = path;
		this.folderlocate = folderlocate;
	}

	public byte[] readfile() {
		byte[ ] readBuffer = new byte[1024];
		FileInputStream fileStream = null; // 파일 스트림
		 try {
		       // 바이트 단위로 파일읽기
			 	File filePath = new File(folderlocate + filename);
		        
		        fileStream = new FileInputStream( filePath );// 파일 스트림 생성
		        //버퍼 선언
		        readBuffer = new byte[fileStream.available()];
		        while (fileStream.read( readBuffer ) != -1){}
		        //System.out.println(new String(readBuffer)); //출력

		    } catch (Exception e) {
			e.getStackTrace();
		    }finally {					
		    	try {
		    		if(fileStream != null)
		    			fileStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //스트림 닫기
			}
		return readBuffer;
	}

	public void deletefile() {
		String filePath = folderlocate + filename;

		File deleteFile = new File(filePath);

		// 파일이 존재하는지 체크 존재할경우 true, 존재하지않을경우 false
		if (deleteFile.exists()) {

			// 파일을 삭제합니다.
			if(deleteFile.delete())
				System.out.println("파일을 삭제하였습니다.");

		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}
}
