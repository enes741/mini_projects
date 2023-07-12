package mini_projects.LoginPageApp;
//user objesi ile ilgili islemler

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    //6-Kullanici bilgilerini tutmak icn list olusturalim
    List<User> userList = new ArrayList<>();
    //Tum methodlarda kullanicidan bilgi almak icin scanner objesi olustur
    Scanner sc = new Scanner(System.in);
    //7username veya email ile gerekli kullaniciyi getirme
    private User getUser(String usernameOrEmail){
        for(User user:userList){
            if(user.getUsername().equals(usernameOrEmail)){
                return user;
            }else if(user.getEmail().equals(usernameOrEmail)){
                return user;
            }
        }
        return null;
    }
    //8-Email validation
    private static boolean validateEmail(String email){
        boolean isValid;
        boolean isExistSpace = email.contains(" ");
        boolean isContainsAt = email.contains("@");
        if(isExistSpace){
            System.out.println("Email bosluk iceremez");
            isValid = false;
        }else if(!isContainsAt){
            System.out.println("Email @ icermelidir");
            isValid = false;
        }else {
            String firstPart = email.split("@")[0];
            String secPart = email.split("@")[1];

            boolean valid = firstPart.replaceAll("[A-Za-z_.-]","").isEmpty();
            boolean checkStart = valid && firstPart.length()>0;

            boolean checkEnd = secPart.equals("@gmail.com") || secPart.equals("@hotmail.com") || secPart.equals("@yahoo.com");

            if(!checkStart){
                System.out.println("Mailin kullanici adi kismi en az bir karakter icermelidir ve sadece kucuk buyuk harf rakam veya" +
                        "-._ icermelidir");
            }
            if(!checkEnd){
                System.out.println("email.com, hotmail.com veya yahoo.com ile bitmelidir");
            }
            isValid = checkStart && checkEnd;
        }
        if(!isValid){
            System.out.println("Tekrar deneyiniz");
        }

        return isValid;
    }
    //9 password validate islemi
    private static boolean validatePassword(String password){
        boolean isValid;
        boolean isExistsSpace = password.contains(" ");
        boolean isLengthGtSix = password.length()>6;
        boolean isExistUpperLetter = password.replaceAll("[^A-Z]","").length()>0;
        boolean isExistLowerLetter = password.replaceAll("[^a-z]","").length()>0;
        boolean isExistDigit = password.replaceAll("[//D]","").length()>0;
        boolean isExistSymbol = password.replaceAll("[//P]","").length()>0;

        if(isExistsSpace){
            System.out.println("Password bosluk iceremez");
            isValid = false;
        } else if (!isLengthGtSix) {
            System.out.println("Password 6karakterden fazla olmali");
            isValid = false;
        } else if (!isExistUpperLetter) {
            System.out.println("Sifre en az bir buyuk harf icermelidir");
            isValid = false;
        } else if (!isExistLowerLetter) {
            System.out.println("Sifre en az bir kucuk harf icermelidir");
            isValid = false;
        } else if (!isExistDigit) {
            System.out.println("Sifre en az bir sayi icermelidir");
        } else if (!isExistSymbol) {
            System.out.println("Sifre en az bir symbol icermelidir");
            isValid = false;
        }
        isValid = !isExistsSpace && isLengthGtSix &&isExistDigit &&!isExistSymbol && isExistLowerLetter && isExistUpperLetter;
        if(!isValid){
            System.out.println("Tekrar deneyiniz");
        }
        return isValid;
    }

    //10 register
    public void register(){
        System.out.println("Ad-Soyad: ");
        String name = sc.nextLine();
        //10-a username unique olmali
        String username = getUsername();
        //11 email unique olmali, ve gecerli olmali
        String email = getEmail();
        //12 password valid olmali
        String password = getPassword();
        //13 user objesini olusturalim
        User user = new User(name,username,email,password);
        //14 Olusturmus oldugumuz useri listeye kaydedelim
        this.userList.add(user);
        System.out.println("Tebrikler isleminiz basariyla gerkcelestirildi");
        System.out.println("Kullanici adi (veya) email ve sifrenizle sisteme giris yapabilirsiniz");
    }
    //10-a kullanicidan username alma
    private String getUsername(){
        String username;
        boolean existUsername;
        do{
            System.out.println("Kullanici adi giriniz");
            username = sc.nextLine();
            existUsername = getUser(username)!=null;
            if(existUsername){
                System.out.println("Bu kullanici adina sahip bir kullanici zaten var");
            }

        }while (existUsername);
        return username;
    }

    //11-a kullanicidan email alma
    private String getEmail(){
        String email;
        boolean isValid;
        boolean existEmail;
        do{
            System.out.println("Lutfen bir email giriniz..");
            email = sc.nextLine();
            isValid = validateEmail(email);//gecerli ise unique mi?
            existEmail = getUser(email)!=null;
            if(existEmail){
                System.out.println("Bu email zaten kullanilmis");
                isValid = false;
            }


        }while (!isValid);

        return email;
    }
    //12-a password olusturma
    private String getPassword(){
        String password;
        boolean isValidPassword;
        do{
            System.out.println("Sifrenizi giriniz");
            password = sc.nextLine();//gecerli bir sifre mi
            isValidPassword = validatePassword(password);

        }while (!isValidPassword);

        return  password;
    }
    //15-Email veya username ile giris yapma
    public void login(){
        System.out.println("Kullanici adi veya email giriniz");
        String usernameOrEmail = sc.nextLine();
        //16-Girilen deger email veya username ile user i bulmamiz gerekiyor
        if(getUser(usernameOrEmail)!=null){
            User user = getUser(usernameOrEmail);
            //user bulundu ise sifre kontrolu
            boolean isWrong = true;
            while (isWrong){
                System.out.println("Sifrenizi giriniz");
                String password = sc.nextLine();
                //Girilen sifre buldugumuz userin sifresi ile ayni mi
                if(user.getPassword().equals(password)){
                    System.out.println("Sisteme giris yaptiniz");
                    isWrong = false;
                }else{
                    System.out.println("Hatali sifre tekrar deneyiniz");
                }

            }
        }else{
            System.out.println("Sistemde kayitli kullanici adi veya email bulunamadi");
            System.out.println("Uyeyseniz bilgilerinizi kontrol ederek tekrar deneyiniz ");
            System.out.println("Uye degilseniz lutfen uye olunuz");
        }
    }
}





























