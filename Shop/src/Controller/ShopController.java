package Controller;

import dao.ItemDAO;
import dao.UserDAO;

public class ShopController {
	public ItemDAO idao;
	public UserDAO udao;
	private int menu;
	private String id;

	public ShopController() {
		idao = new ItemDAO();
		udao = new UserDAO();
		menu = 0;
		id = "";
	}

	public void run() {
		// 메인화면 출력 (가입 탈퇴 로그인 로그아웃 관리자)
		int start = 0;
		int end = 5;

		while (true) {
			if (menu == 0) {
				start = 0;
				end = 5;
				mainMenu();
			} else if (menu == 1) {
				start = 0;
				end = 2;
				userMenu();
			} else if (menu == 2) {
				start = 0;
				end = 3;
				cartMenu();
			} else if (menu == 3) {
				start = 0;
				end = 6;
				adminMenu();
			} else if (menu == 4) {
				start = 0;
				end = 4;
				itemMenu();
			} else if (menu == 5) {
				start = 0;
				end = 4;
				categoryMenu();
			}

			int sel = Utils.InnputManger.inputInt("", start, end);
			if (menu == 0) {
				switch (sel) { // 로그인 아닐시에는 가입/로그인/관리자/종료만 가능 // 로그인시에는 탈퇴/로그아웃/쇼핑/장바구니목록 가능
					case 1: // 가입
						udao.join();
						break;
					case 2: // 탈퇴
						udao.delete(idao); // 탈퇴시에는 장바구니도 삭제
						break;
					case 3: // 로그인
						id = udao.login();
						if (id.equals(""))
							System.out.println("로그인 실패");
						else
							menu = 1;
						break;
					case 4: // 로그아웃
						id = udao.logout();
						break;
					case 5: // 관리자
						menu = 3;
						break;
					case 0: // 종료
						return;
					default:
						continue;
				}
			} else if (menu == 1) {
				// 로그인 메뉴

				switch (sel) {
					case 1: // 쇼핑
						menu = 2;
						break;
					case 2: // 장바구니목록
						idao.cartList();
						break;
					case 0: // 뒤로가기
						menu = 0;
						break;
					default:
						continue;
				}
			} else if (menu == 2) {
				// 쇼핑메뉴
				switch (sel) {
					case 1: // 내 장바구니
						idao.cartList(id);
						break;
					case 2: // 삭제
						idao.deleteItemById(id);
						break;
					case 3: // 구입
						idao.buyItem(id);
						break;
					case 0: // 뒤로가기
						menu = 1;
						break;
					default:
						continue;
				}
			} else if (menu == 3) { // 관리자 메뉴
				switch (sel) {
					case 1: // 아이템관리
						menu = 4;
						break;
					case 2: // 카테고리관리
						menu = 5;
						break;
					case 3: // 장바구니관리 // 장바구니 리스트 출력. // 아이디, 아이템 이름 입력하여 삭제가능
						idao.cartList();
						break;
					case 4: // 유저관리 (유저리스트 출력. 유저 아이디 입력하여 삭제가능)
						udao.userList();
						break;
					case 5: // 데이터저장
						Utils.FileManager.saveFileFromData(udao, idao);
						break;
					case 6: // 데이터로드
						idao.loadItemDataFromFile();
						udao.loadUserDataFromFile();
						break;
					case 0: // 뒤로가기
						menu = 0;
						break;
					default:
						continue;
				}

			} else if (menu == 4) { // 아이템 관리 메뉴

				switch (sel) {
					case 1: // 아이템추가
						idao.addItem();
						break;
					case 2: // 아이템삭제
						idao.deleteItem();
						break;
					case 3: // 아이템수정
						idao.updateItem();
						break;
					case 4: // 아이템리스트
						idao.itemList();
						break;
					case 0: // 뒤로가기
						menu = 3;
						break;
					default:
						continue;

				}
			} else if (menu == 5) { // 카테고리 관리 메뉴

				switch (sel) {
					case 1: // 카테고리추가
						idao.addCategory();
						break;
					case 2: // 카테고리삭제
						idao.deleteCategory();
						break;
					case 3: // 카테고리수정
						idao.updateCategory();
						break;
					case 4: // 카테고리리스트
						idao.categoryList();
						break;
					case 0: // 뒤로가기
						menu = 3;
						break;
					default:
						continue;
				}
			} else {
				continue;
			}

		}
		// 관리자 화면 출력 메뉴
		// 사용자 화면 출력메뉴

	}

	private void mainMenu() {
		// 메인화면 출력 (가입 탈퇴 로그인 로그아웃 관리자)
		System.out.println("[1.가입] [2.탈퇴] [3.로그인] [4.로그아웃]" + "\n[5.관리자] [0.종료] ");
	}

	private void userMenu() {
		// 사용자 화면 출력메뉴
		System.out.println("[1.쇼핑] [2.장바구니목록] [0.뒤로가기]");
	}

	private void cartMenu() {
		// 장바구니 화면 출력 메뉴
		System.out.println("[1.내 장바구니] [2.삭제] [3.구입] [0.뒤로가기]");
	}

	private void adminMenu() {
		// 관리자 화면 출력 메뉴
		System.out.println("[1.아이템관리] [2.카테고리관리] [3.장바구니관리] [4.유저관리] [5.데이터저장] [6.데이터로드] [0.뒤로가기] ");

	}

	private void itemMenu() {
		// 아이템 관리 화면 출력 메뉴
		System.out.println("[1.아이템추가] [2.아이템삭제] [3.아이템수정] [4.아이템 리스트] [0.뒤로가기]");
	}

	private void categoryMenu() {
		// 카테고리 관리 화면 출력 메뉴
		System.out.println("[1.카테고리추가] [2.카테고리삭제] [3.카테고리수정] [4.카테고리 리스트] [0.뒤로가기]");
	}
	// 회원가입

	// System.out.println("[1.가입] [2.탈퇴] [3.로그인] [4.로그아웃]" + "\n[100.관리자] [0.종료] ");

	// System.out.println("[1.쇼핑] [2.장바구니목록] [0.뒤로가기]");

	// System.out.println("[1.내 장바구니] [2.삭제] [3.구입] [0.뒤로가기]");

	// System.out.println("[1.아이템관리] [2.카테고리관리] [3.장바구니관리] [4.유저관리] [0.뒤로가기] ");
}
