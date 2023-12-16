package Controller;

import java.util.ArrayList;

import dao.ItemDAO;
import dao.UserDAO;

public class ShopController {
	public ItemDAO idao;
	public UserDAO udao;
	private int menu;

	public ShopController() {
		idao = new ItemDAO();
		udao = new UserDAO();
		menu = 0;
	}

	public void run() {
		// 메인화면 출력 (가입 탈퇴 로그인 로그아웃 관리자)
		mainMenu();
		int start = 0;
		int end = 4;

		while (true) {
			int sel = Utils.InnputManger.inputInt("", start, end);
			switch (sel) {
				case 1: // 가입
					join();
					break;
				case 2: // 탈퇴
					break;
				case 3: // 로그인
					break;
				case 4: // 로그아웃
					break;
				case 100: // 관리자
					adminMenu();
					break;
				case 0: // 종료
					break;
				default:
					break;
			}

		}
		// 관리자 화면 출력 메뉴
		// 사용자 화면 출력메뉴

	}

	private void mainMenu() {
		// 메인화면 출력 (가입 탈퇴 로그인 로그아웃 관리자)
		System.out.println("[1.가입] [2.탈퇴] [3.로그인] [4.로그아웃]" + "\n[100.관리자] [0.종료] ");
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
		System.out.println("[1.아이템관리] [2.카테고리관리] [3.장바구니관리] [4.유저관리] [0.뒤로가기] ");

	}

	private void itemMenu() {
		// 아이템 관리 화면 출력 메뉴
		System.out.println("[1.아이템추가] [2.아이템삭제] [3.아이템수정] [0.뒤로가기]");
	}

	private void categoryMenu() {
		// 카테고리 관리 화면 출력 메뉴
		System.out.println("[1.카테고리추가] [2.카테고리삭제] [3.카테고리수정] [0.뒤로가기]");
	}

	// 회원가입
	private void join() {
		Utils.InnputManger.inputStr("아이디를 입력해주세요.");
		// 아이디 중복체크
		udao.checkId();

		// 비밀번호 확인
		// 회원가입
	}

	// System.out.println("[1.가입] [2.탈퇴] [3.로그인] [4.로그아웃]" + "\n[100.관리자] [0.종료] ");

	// System.out.println("[1.쇼핑] [2.장바구니목록] [0.뒤로가기]");

	// System.out.println("[1.내 장바구니] [2.삭제] [3.구입] [0.뒤로가기]");

	// System.out.println("[1.아이템관리] [2.카테고리관리] [3.장바구니관리] [4.유저관리] [0.뒤로가기] ");
}
