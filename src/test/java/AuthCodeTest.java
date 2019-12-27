//import cn.edu.zjut.authcode.AuthCodeService;
//import cn.edu.zjut.authcode.IAuthCodeService;
//
//import java.util.Scanner;
//
//public class AuthCodeTest {
//    private IAuthCodeService authCodeService;
//
//    public static void main(String[] args) {
//        String mobile = "17857699125";
//        AuthCodeTest test = new AuthCodeTest();
//        test.authCodeService = new AuthCodeService();
//        if (!test.authCodeService.sedMsg(mobile)){
//            System.out.println("发送失败");
//            return;
//        }
//        else
//            System.out.println("发送成功");
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("请输入你收到的验证码:");
//        String code = scanner.nextLine();
//        if (test.authCodeService.verifyCode(mobile, code)) {
//            System.out.println("校验成功");
//        } else {
//            System.out.println("校验失败");
//        }
//    }
//}
