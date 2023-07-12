package mini_projects.login;

import java.util.Scanner;

public class LoginMain {
    /*
    Project: Bir siteye uye olma ve giris yapma sayfasi yasarlayin
             menu: kullaniciya islem secimi icni menu gosterilir

             register: kullaniciidan ad soyad kullanici adi email ve sifre biligilerini alizniz
             kullanici adi email e sifre birer listede titilir ayni kullanici adi veya email kabul edilmez

             login:kullanici adi.email ve sifre girilir
             kullanici adi veya email bulunmazsa kayitli degil uye olun uyarisi verilir
             kullanici adi.email ile ayni indekste kayitli sifre dogrilanirsa siteue giris yapilir

             email validation: bosluk icermemeli
             gmail.com hotmail.com veya yahoo.cpm ile bitmeli
             mailin kullanici adi kisminda @den once veya sadece buyuk kucuk harf rakam yada -._gibi sembolleri alabilir

     */
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        int select;

        do {
            userService.showMenu();
            select = scanner.nextInt();
            switch (select) {
                case 1:
                userService.register();
                    break;
                case 2:
                userService.login();
                    break;
                case 3:
                    System.out.println("Iyi gunler dileriz");
                    break;
                default:
                    System.out.println("Hatali giris yeniden deneyiniz");
            }
        } while (select != 3);
    }
}
