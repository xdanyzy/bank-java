import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


interface ComponentItf {
    default void childComponent(String text){
        System.out.println(text);
    }
}

class Component{

    static Scanner ioscan = new Scanner(System.in);
    static int input = 0;
    static Boolean Condition = true;

    public static void Main(){
        try {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nSelamat Datang ke Bank\nPilih pengaturan anda\n\n1. Baki\n2. Kondisi Wang\n3. Akaun\n\n1-2-3 >>> ");
            input = ioscan.nextInt();

            while (Condition == true) {
                if (input > 3) {
                    System.out.print("Tiada pengaturan lain >>> ");
                    input = ioscan.nextInt();
                } else {
                    SystemBK.system();
                }
            }

        } catch (Exception e) {
            System.out.println("Ralat : Input String!");
        }
    }
}

class SystemBK extends Component{

    static Prop prop = new Prop();
    static double Inputnew = 0;

    public static void system(){
        if (Component.input == 1){
            System.out.println("baki yang tertinggal di dalam bank ialah RM " + Prop.value);
            Condition = false;
        } 
        
        if (Component.input == 2){
            ComponentItf componentItf = new ComponentItf() {

                // choose option
                @Override
                public void childComponent(String text){
                    try {
                        System.out.print(text);
                        input = ioscan.nextInt();

                        while (Condition == true) {

                            // option : tambah nilai
                            if (input == 1){
                                ComponentItf componentItf_Bankin = new ComponentItf() {
                                    @Override
                                    public void childComponent(String text){
                                        try {
                                            System.out.print(text);
                                            Inputnew = ioscan.nextDouble();

                                            var x = Inputnew + prop.value;
                                            db.File("prop", x);
                                            System.out.println("Berjaya ditambah. Sila check kembali di bahagian utama");
                                            Condition = false;

                                        } catch (Exception e) {
                                            System.out.println("Not accept String");
                                            Condition = false;

                                            // user gain the exception after putting an input with String
                                        }
                                    }
                                };

                                componentItf_Bankin.childComponent("Masukkan nilai yang anda mahu tambah >>> ");
                            }

                            // option : keluarkan nilai
                            if (input == 2){
                                ComponentItf componentItf_Bankout = new ComponentItf() {
                                    @Override
                                    public void childComponent(String text){
                                        try {
                                            System.out.print(text);
                                            Inputnew = ioscan.nextDouble();

                                            if (Inputnew >= prop.value || Inputnew == 0){
                                                System.out.println("Baki tidak mencukupi! >>> ");
                                                Inputnew = ioscan.nextDouble();
                                            } else {
                                                var x = Prop.value - Inputnew;
                                                db.File("prop", x);
                                                System.out.print("Berjaya ditolak. Sila check kembali di bahagian utama");

                                                Condition = false;
                                            }

                                        } catch (Exception e) {
                                            System.out.println("Not accept String");
                                            Condition = false;

                                            // user gain the exception after putting an input with String
                                        }
                                    }
                                };

                                componentItf_Bankout.childComponent("Sila masukkan nilai yang anda mahu keluarkan >>> ");
                            } 
                            
                            if(input > 2 || input <= 0) {
                                System.out.print("Tiada input lain >>> ");
                                input = ioscan.nextInt();
                            }
                        }
                        
                    } catch (Exception e) {
                        System.out.println("not accept String");
                        Condition = false;
                    }
                }
            };

            componentItf.childComponent("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nSila pilih option anda\n\n1. Masukkan duit\n2. Keluarkan duit\n\n 1-2 >>> ");
        }

        if (input == 3){
            System.out.println("Akaun anda telah aktif.");
            Condition = false;
        }
    }
}

class db {
    public static void File(String FileName, double x){
        try {
            File findfile = new File(FileName + ".java");

            FileWriter fileWriter = new FileWriter(findfile);
            fileWriter.write("public class Prop {static double value = "+ x +";}");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("something error while write the file...");
        }
    }
}