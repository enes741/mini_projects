package mini_projects.LoginPageApp;

import java.util.Scanner;

public class LoginPageApp {
    //Project: Bir siteye uye olma ve giris yapma sayfasi tasarlayiniz
    //menu: kullaniciya islem secimi icin menu gosterilir
    //uye olma(register): kullanicidan ad-soyad, kullanici adi, mail, password biligileri alinir
    //kullanici adi email ve sifre birer listede tutulur
    //Ayni kullanici adi veya email kabul edilmez
    /*
    login page tasarlarken oncelikle start methodu ile menu gosterme methodunu main class da yaptim
    sonra user bilgilerini iceren bir pojo class kurdum, pojo classdaki name, username, email, psw bilgiulerini private yaptim
    bilgileri okuyabilmek icin getter methodlari olusturdum herbiri icin.
    bu bilgilerle obje olusturmak icin parametleri bir cons olusturdum.

    Sayfanin islevsellegi icin userService class i olusturdum. user service class inda olusturulan her user objesini listeye almak icin
    bir array list olusturdum.
    User data type da i create an getUser method..but method bir email veya username verilince eger list in icinde o username ya da
    email kayitli ise var olan user i bana return ediyor eger o email yada username list de eslesmiyorsa null return ediyor
    bu method register icin getUsername methodunun calismasi icin onemli

    register icin olusturdugum getUsername methodu kullanicidan bir username istiyor ve verilen username zaten list de yer aliyorsa
    bunu kabul olarak almiyor .. bunun icin list deki username leri kontrol ediyor
    nasil kontrol ediyor? getUser methoduna username parametresi veriyor eger bir username donuyorsa yani null degilse
    isExistUsername boolean true ya donuyor

     */
    public static void main(String[] args) {
        start();
    }
    public static void start(){
        Scanner sc = new Scanner(System.in);
        int select;
        do{
            select = sc.nextInt();
            System.out.println("1-Register Page");
            System.out.println("2-Log in page");
            System.out.println("3-Exit");
            switch (select){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Hatali giris!!!");
                    break;
            }
        }while (select!=0);
    }
    //Tum uselerin ortak ozellikleri icin bir user class acalim
}
