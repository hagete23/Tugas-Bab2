package laporan2;

import java.util.Scanner;
public class mainATM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ATM atm = new ATM("1324354668", 142325, "DI LAYANAN ATM APIK");
        System.out.println("\t      ATM");
        System.out.println("\tSELAMAT DATANG "); 
        atm.masukkanPin();
        atm.cekSaldo();
        atm.penarikan();
        atm.transfer();
        atm.ubahPin();
        atm.displayMenuATM();     
    }
}