package mini_projects.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    List<String> usernameList = new ArrayList<>();
    List<String> emailList = new ArrayList<>();
    List<String> passwordList = new ArrayList<>();

    public void showMenu(){
        System.out.println("-------Velcome--------");
        System.out.println("1-Uye ol");
        System.out.println("2-Giris Yap");
        System.out.println("3-Cikis");
        System.out.println("Seciminiz");
    }

    public void register(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ad soyad giriniz");
        String name = scanner.nextLine();

        String username;
        boolean existUsername;
        do{
            System.out.println("Kullanici adi giriniz");
            username = scanner.nextLine();
            existUsername = usernameList.contains(username);
            if(existUsername){
                System.out.println("Bu username daha once kullanilmistir tekrar deneyin");
            }
        }
        while (existUsername);
        String email;
        boolean isValid;
        boolean existEmail;
        do{
            System.out.println("Email giriniz");
            email = scanner.nextLine();
            isValid = validateEmail(email);
            existEmail = emailList.contains(email);
            if(existEmail){
                isValid = false;
                System.out.println("Bu email kullanilmis tekrar giriniz");
            }
        }while(!isValid);

        String password;
        boolean isValidPsw;
        do{
            System.out.println("Sifre giriniz");
            password = scanner.nextLine().trim();
            isValidPsw = validatePassword(password);
        }while (!isValidPsw);
        User user = new User(name,username,email,password);//burda alip cons ile objeye verdik
        usernameList.add(username);
        emailList.add(email);
        passwordList.add(password);
        System.out.println(user);
        System.out.println("Tebrikler kayit isleminiz gerceklesmistir");
        System.out.println("Kullanici adi veya email ve sifre ile sisteme giris yapabilirsiniz");
    }


    public void login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Kullanici adi ve email giriniz");
        String usernameOremail = sc.nextLine();
        boolean isMail = emailList.contains(usernameOremail);
        boolean isUserName = usernameList.contains(usernameOremail);
        if(isMail||isUserName){

            while(true){
                System.out.println("Sifrenizi giriniz");
                String password = sc.nextLine();
                int idx;
                if(isUserName){
                    idx = usernameList.indexOf(usernameOremail);
                }else {
                    idx = emailList.indexOf(usernameOremail);
                }
                if(passwordList.get(idx).equals(password)){
                    System.out.println("Sisteme giris yaptiniz");
                    break;
                }else{
                    System.out.println("Sifreniz yanlis. Tekrar deneyiniz");
                }
            }

        }else{
            System.out.println("Sisteme kayitli kullanici bulunamadi");
            System.out.println("Bilgileri kontrol ediniz ya da uye olunuz");
        }
    }




    public static boolean validateEmail(String email){
        boolean isValid;

        boolean space = email.contains(" ");
        boolean isContainAt = email.contains("@");

        if(space){
            System.out.println("Email bosluk iceremez");
            isValid = false;
        }else if(!isContainAt){
            System.out.println("Email @ icermeli");
            System.out.println("Email @ icermelidir");
            isValid = false;
        }else{
            String firstPart = email.split("@")[0];
            String secondPart = email.split("@")[1];

            boolean checkStart = firstPart.replaceAll("[a-zA-Z0-9_.-]","").length()==0;
            boolean checkEnd = secondPart.equals("gmail.com") ||secondPart.equals("hotmail.com")||secondPart.equals("yahoo.com");
            
            if(!checkStart){
                System.out.println("email kucuk harf buyuk harf rakam ve _.-  disinda karakter iceremez");
            } else if (!checkEnd) {
                System.out.println("Email gmail.com hotmail.com veya yahoo.cpm ile bitmeli");
            }
            isValid = checkEnd && checkStart;
        }
         return isValid;
    }



    public static boolean validatePassword(String password){
        boolean isValid;

        boolean space = password.contains(" ");
        boolean lengthGt6 = password.length()>=6;
        boolean existUpper = password.replaceAll("[^A-Z]]","").length()>0;
        boolean existLower = password.replaceAll("[^a-z]]","").length()>0;
        boolean existDigit = password.replaceAll("[^0-9]]","").length()>0;
        boolean existSymbol = password.replaceAll("[//P{Punct}]]","").length()>0;

        if(space){
            System.out.println("Sifre bosluk iceremez");
        }else if(!lengthGt6){
            System.out.println("Sifre en az 6 karakter icermelidir");
        } else if (!existUpper) {
            System.out.println("Sifre en az 1 buyuk harf icermelidir");
        } else if (!existLower) {
            System.out.println("Sifre en az 1 kucuk harf icermelidir");
        }else if(!existDigit){
            System.out.println("Sifre en az 1 rakam icermeleidir");
        } else if (!existSymbol) {
            System.out.println("Sifre en az 1 symbol icermelidir");
        }

        isValid = !space&&lengthGt6&&existUpper&&existUpper&&existDigit&&existSymbol;

        if(!isValid){
            System.out.println("Tekrar deneyiniz");
        }
        return isValid;
    }







}
