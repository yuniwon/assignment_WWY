package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import dao.ItemDAO;
import dao.UserDAO;

public class FileManager {

	final static String CUR_PATH = System.getProperty("user.dir") + "\\shop\\src\\"
			+ FileManager.class.getPackage().getName()
			+ "\\";

	// cart.txt
	// user.txt
	// item.txt

	public static String loadDataFromFile(String fileName) {
		// 파일을 읽어서 데이터를 로드한다.
		// 파일이 없으면 파일이 없다는 메세지를 생성하고 종료
		// 파일이 있으면 데이터를 로드한다.
		System.out.println(CUR_PATH);
		File file = new File(CUR_PATH + fileName);
		if (!file.exists()) {
			System.out.println("파일이 없습니다.");
			return "";
		}
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
			String line = "";
			String data = "";
			while ((line = br.readLine()) != null) {
				data += line + "\n";
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void saveFileFromData(UserDAO udao, ItemDAO idao) {
		// 데이터를 파일에 저장한다.
		// 파일이 없으면 파일을 생성하고 데이터를 저장한다.
		// 파일이 있으면 기존 파일에 덮어쓰기 한다.
		// user 데이터 저장
		String data = "";
		File file = null;
		if (udao.users.size() != 0) {
			for (int i = 0; i < udao.users.size(); i++) {
				data += udao.users.get(i).getId() + "/" + udao.users.get(i).getPw() + "/" + udao.users.get(i).getName()
						+ "\n";
			}
			data = data.substring(0, data.length() - 1);
			file = new File(CUR_PATH + "User.txt");
			try (FileWriter fw = new FileWriter(file);) {
				if (!file.exists()) {
					try {
						file.createNewFile();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				fw.write(data);
			} catch (Exception e) {
				System.out.println("user 파일 저장 실패");
				e.printStackTrace();
				return;
			}
		}

		// Cart 데이터 저장
		if (idao.carts.size() != 0) {
			data = "";
			for (int i = 0; i < idao.carts.size(); i++) {
				data += idao.carts.get(i).getUserId() + "/" + idao.carts.get(i).getItemName() + "\n";
			}
			data = data.substring(0, data.length() - 1);
			file = new File(CUR_PATH + "Cart.txt");
			try (FileWriter fw = new FileWriter(file);) {
				fw.write(data);
			} catch (Exception e) {
				System.out.println("Cart 파일 저장 실패");
				e.printStackTrace();
				return;
			}
		}
		// item 데이터 저장
		if (idao.items.size() != 0) {
			data = "";
			for (int i = 0; i < idao.items.size(); i++) {
				data += idao.items.get(i).getName() + "/" + idao.items.get(i).getPrice() + "/"
						+ idao.items.get(i).getCategory()
						+ "\n";
			}
			data = data.substring(0, data.length() - 1);
			file = new File(CUR_PATH + "Item.txt");
			try (FileWriter fw = new FileWriter(file);) {
				fw.write(data);
			} catch (Exception e) {
				System.out.println("Item 파일 저장 실패");
				e.printStackTrace();
				return;
			}
		}

		System.out.println("파일 저장 성공");
	}

}
