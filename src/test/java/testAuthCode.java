import cn.edu.zjut.authcode.AuthCodeService;

import java.util.Scanner;

public class testAuthCode {
    public static void main(String[] args) {
        AuthCodeService authCodeService = new AuthCodeService();
        String phone = "13646686983";
        authCodeService.sendMsg(phone);
        String authCode;
        Scanner scanner = new Scanner(System.in);
        authCode = scanner.nextLine();
        authCodeService.verifyCode(phone,authCode);
    }
}
