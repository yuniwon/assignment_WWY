package dao;

import java.util.ArrayList;
import vo.User;

public class UserDAO {
    public ArrayList<User> users = new ArrayList<User>();

    public void join() {
        String id = Utils.InnputManger.inputStr("아이디를 입력해주세요.");
        // 아이디 중복체크
        if (checkId(id)) {
            System.out.println("이미 존재하는 아이디입니다.");
            return;
        }
        // 비밀번호 입력
        String pw = Utils.InnputManger.inputStr("비밀번호를 입력해주세요.");
        // 이름 입력
        String name = Utils.InnputManger.inputStr("이름을 입력해주세요.");
        // 회원 데이터 저장
        users.add(new User(id, pw, name));
        System.out.println(name + "님 회원가입이 완료되었습니다.");
        // 회원가입
    }

    public void delete(ItemDAO idao) {
        if (users.size() == 0) {
            System.out.println("탈퇴할 회원이 없습니다.");
            return;
        }
        // 회원탈퇴
        String id = Utils.InnputManger.inputStr("탈퇴할 아이디를 입력해주세요.");
        // 아이디 존재여부 확인
        if (!checkId(id)) {
            System.out.println("존재하지 않는 아이디입니다.");
            return;
        }
        // 비밀번호 확인
        String pw = Utils.InnputManger.inputStr("비밀번호를 입력해주세요.");
        // 비밀번호 일치여부 확인
        if (!checkPw(id, pw)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return;
        }
        // 회원 데이터 삭제
        for (User user : users) {
            if (user.getId().equals(id)) {
                users.remove(user);
                System.out.println(user.getName() + "님 탈퇴가 완료되었습니다.");
                idao.deleteItemById(id);
                return;
            }
        }
    }

    private boolean checkId(String id) { // 아이디 중복체크
        for (User user : users) {
            if (user.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPw(String id, String pw) {
        for (User user : users) {
            if (user.getId().equals(id) && user.getPw().equals(pw)) {
                return true;
            }
        }
        return false;
    }

    public String login() {
        String id = Utils.InnputManger.inputStr("아이디를 입력해주세요.");
        // 아이디 존재여부 확인
        if (!checkId(id)) {
            System.out.println("존재하지 않는 아이디입니다.");
            return "";
        }
        // 비밀번호 확인
        String pw = Utils.InnputManger.inputStr("비밀번호를 입력해주세요.");
        // 비밀번호 일치여부 확인
        if (!checkPw(id, pw)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return "";
        }
        System.out.println("로그인 성공");
        return id;
        // TODO Auto-generated method stub

    }

    public String logout() {
        System.out.println("로그아웃 되었습니다.");
        return "";
        // TODO Auto-generated method stub

    }

}
