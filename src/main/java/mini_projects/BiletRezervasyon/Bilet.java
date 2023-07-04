package mini_projects.BiletRezervasyon;

public class Bilet {
    //mesafe, yolculuk tipi, fiyat, koltuk no
    public double distance;
    public int typeNo;
    public double price;
    public int seatNo;

    //5-Bileti yazdiralim
    public void printBilet(Bus bus){

        System.out.println("Toplam tutar: " + this.price);
        System.out.println("---Bilet Detayi---");
        System.out.println("Otobus plaka " + bus.numberPlate);
        System.out.println("Mesefa :" + this.distance);
        System.out.println("Yolculuk tipi :" + (this.typeNo==1 ? "Tek yon" : "Gidis donus"));
        System.out.println("Koltuk no :" + this.seatNo);
        System.out.println("Keyifli yolculuklar dileriz...");
    }

}
