package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;

public class FileManager {

	final String CUR_PATH = System.getProperty("user.dir") + "\\" + getClass().getPackage().getName() + "\\";

	// cart.txt
	// user.txt
	// item.txt

	public void loadDataFromFile(String fileName) {
		System.out.println(CUR_PATH);
		File file = new File(CUR_PATH + fileName);
		if (!file.exists()) {
			System.out.println("파일이 없습니다.");
			return;
		}
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 파일을 읽어서 데이터를 로드한다.
		// 파일이 없으면 파일이 없다는 메세지를 생성하고 종료
		// 파일이 있으면 데이터를 로드한다.

	}

	public void saveFileFromData(String fileName) {
		// 데이터를 파일에 저장한다.
		// 파일이 없으면 파일을 생성하고 데이터를 저장한다.
		// 파일이 있으면 기존 파일에 덮어쓰기 한다.
		File file = new File(CUR_PATH + fileName);
		try (FileWriter fw = new FileWriter(file);){
			
		} catch (Exception e) {
			// TODO: handle exception
		}


	}

}
