package laporan2;

import java.util.Scanner;
public class ATM {
  private final String noRek;
  private int pin;
  private int saldo = 200000;
  private  String nama;
  private int kelipatan = 50000;
    Scanner in = new Scanner(System.in);
  public ATM(String a, int p, String n){
   noRek = a;
   pin = p;
   nama = n;
  }
  public void setNama(String n){
      nama = n;
  }
  public void setPin (int p){
        pin = p; 
  }
  public int getPin(){
   return pin;  
  }
  public void masukkanPin(){
       boolean valid = false;
        int ulang = 1;
        System.out.println("");
        System.out.println("MASUKKAN PIN ANDA");
        System.out.println("_______");
        System.out.println("|1|2|3|");
        System.out.println("-------");
        System.out.println("|4|5|6|");
        System.out.println("-------");
        System.out.println("|7|8|9|");
        System.out.println("-------");
        do{
            System.out.print("Masukkan PIN ");
            int pin = in.nextInt();
            if (ulang < 3) {
                if (pin == getPin()) {
                 displayMenuATM();
                } else {
                    System.err.println("PIN salah");
                    int i = 3 - ulang;
                    System.out.println("Kesempatan "
                     + "memasukkan PIN tinggal "+i+" kali");
                    valid = true;
                }
            } else{
                System.out.println("Batas memasukkan PIN anda telah habis");
                System.out.println("Kartu ATM telah terblokir");
                System.exit(0);
            } ulang++;
        } while (valid);
        System.out.println("\tTERIMA KASIH");
  }
  public void cekSaldo(){
      System.out.println("Sisa saldo anda adalah "+this.saldo);
  }
  public void penarikan(){
   int penarikan;
   boolean valid;
   do{
       System.out.println("");
       System.out.println("\tPENARIKAN TUNAI");
       System.out.println("*Hanya untuk "
               + "kelipatan Rp50.000");
       System.out.println("*Batas maksimal penarikan "
               + "tunai adalah Rp2.000.000");
       System.out.print("\nMasukkan nominal uang ");
       penarikan = in.nextInt();
       if (penarikan % kelipatan == 0) {
           if (penarikan <= 2000000) {
               if (saldo > penarikan) {
                   saldo -= penarikan;
                   System.out.println("Anda telah melakukan"
                 + " penarikan tunai sebesar Rp"+penarikan);
                   valid = false;
               }else{
                System.out.println("Saldo anda tidak mencukupi");
                   valid = true;
               }
           } else{
               System.out.println("Batas maksimal "
                     + "penarikan tunai adalah Rp2.000.000");  
           valid = true;
           }
       } else{
           System.out.println("Penarikan tunai hanya"
                   + " untuk kelipatan Rp50.000");
           valid = true;
       }
   } while  (valid);
  }
  public void transfer(){
      boolean valid = false;
      System.out.println("");
      System.out.println("\tTRANSFER UANG");
      System.out.print("\nMasukkan nomor rekening tujuan ");
        String rekening = in.next();
        do{
            System.out.print("Masukkan nominal uang yang ditransfer ");
            int nominal = in.nextInt();
            if (nominal > 0) {
                if (nominal < this.saldo) {
                  System.out.println("\tTransfer Berhasil");
                  System.out.println("\tTransfer kepada no.rekening "+rekening+" sebesar Rp"+nominal);
                this.saldo -= nominal;    
                } else{
                 System.err.println("Saldo tidak mencukupi");
                    valid = true;
                }
            } else{
                System.err.println("Nominal transfer uang harus lebih dari Rp0.");
                valid = true;
            }
        } while (valid);
  }
  public void ubahPin(){
      boolean valid = false;
      do{
          System.out.println("");
          System.out.println("\tUBAH PIN ATM");
          System.out.print("Masukkan PIN Anda ");
          int pin = in.nextInt();
          if (pin == this.pin) {
              do{
                  System.out.print("Masukkan PIN baru ");
                  int pinBaru = in.nextInt();
                  System.out.print("Masukkan kembali PIN ");
                  int pinBaru2 = in.nextInt();
                  if (pinBaru == pinBaru2) {
                  setPin(pinBaru2);
          System.out.println("PIN anda telah diperbaharui");
                      valid = false;
                  } else{
                      System.out.println("PIN tidak sesuai");
                      valid = true;
                  }
              } while (valid);
          } else{
              System.out.println("PIN salah");
              valid = true;
          }
      } while (valid);
  }
public void displayMenuATM(){
    System.out.println("");
    System.out.println("    SELAMAT DATANG "+this.nama);
    System.out.println("  Nomor Rekening anda "+this.noRek);
    System.out.println("");
    System.out.println("-- Menu Lainnya --");
    System.out.println("1. Cek Saldo");
    System.out.println("2. Penarikan Tunai");
    System.out.println("3. Transfer");
    System.out.println("4. Ubah PIN");
    System.out.println("5. Keluar");
    boolean valid;
    do {
        System.out.print("Masukkan pilihan anda ");
        int pilihan = in.nextInt();
        if ((pilihan <= 6 )&(pilihan > 0)) {
        valid = false;
        switch(pilihan){
            case 1: cekSaldo(); break;
            case 2: penarikan(); break;
            case 3: transfer(); break;
            case 4: ubahPin(); break;
            default:
                System.out.println("\tTERIMA KASIH");
                System.exit(0);
                break;
        } System.out.println("");
        System.out.println("Apa anda ingin melakukan transaksi lagi?[y/n]");
        String transaksi = in.next();
            if (transaksi.equalsIgnoreCase("y")) {
                displayMenuATM();                
            } else{
                System.out.println("\tTERIMA KASIH");
                System.exit(0);
            }
        } else{
            System.out.println("");
            valid = true;
        }
    } while (valid);   
}
}