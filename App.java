
// bank system

import java.util.Scanner;

public class App {

    static Properties Prop = new Properties();
    static Update render = new Update();
    static Scanner scan = new Scanner(System.in);

    static int newUpdateAmount;

    public static void Bank() {
        System.out.print("Hello, Selamat Datang\nSila pilih pemilihan anda.\n\n1. Baki\n2. Keluarkan Duit\n3. Masukkan Duit\n\n");
    }

    public static void getUpdateAmount(int getNewUpdate){
        render.createFile("Properties", getNewUpdate);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nDuit anda hanya tinggal RM " + newUpdateAmount);
    }

    public static void main(String[] args) {
        var escape = false;
        int option = 0;

        App.Bank();

        while (escape == false) {
            System.out.print("option >>> ");
            option = scan.nextInt();
            if (option > 3){
                System.out.print("Tiada pemilihan nombor " + option + " di option");
            } else {
                escape = true;
            }
        }

        if (option == 1){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\nBaki anda ialah RM "+ Prop.amount + "\n");
        } 
        
        if (option == 2){
            try {
                System.out.print("Masukkan nilai -RM >>> ");
                int checkout = scan.nextInt();

                if (checkout >= Prop.amount){
                    escape = false;
                    while (escape == false) {
                        System.out.print("Anda tidak boleh keluarkan kerana baki hanya RM " + Prop.amount + " sahaja >>> ");
                        checkout = scan.nextInt();

                        if (checkout < Prop.amount){
                            escape = true;
                            newUpdateAmount = Prop.amount - checkout;
                            getUpdateAmount(newUpdateAmount);
                        }
                    }
                } else {
                    newUpdateAmount = Prop.amount - checkout;
                    getUpdateAmount(newUpdateAmount);
                }
            } catch (Exception e) {
                System.out.println("Tidak diterima dengan string");
            }
        }
        if (option == 3){
            try {
                System.out.print("Masukkan nilai RM >>> ");
                int duit_tambah = scan.nextInt();

                getUpdateAmount(duit_tambah + Prop.amount);
                System.out.println("Tambah nilai berjaya! RM " + duit_tambah);
            } catch (Exception e) {
                System.out.println("Tidak diterima dengan string");
            }
        }

    }
}