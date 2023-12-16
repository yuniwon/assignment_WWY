package Utils;

import java.util.Scanner;

public class InnputManger {
    private static Scanner sc = new Scanner(System.in);

    public static int inputInt(String msg, int min, int max) {
        System.out.println(msg);
        while (true) {
            try {
                int num = sc.nextInt();
                if (num < min || num > max) {
                    System.out.println("(" + min + " ~ " + max + ")범위 내 숫자를 입력해주세요.");
                    continue;
                }
                return num;
            } catch (Exception e) {
                System.out.println("숫자만 입력해주세요.");
                sc.nextLine();
                continue;
            }
        }
    }

    public static String inputStr(String msg) {
        System.out.println(msg);
        return sc.next();
    }

    public static String inputLine() {
        return sc.nextLine();
    }

    public static void close() {
        sc.close();
    }

}
