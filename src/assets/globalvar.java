package assets;

/**
 * Biasanya <code>globalvar</code> ini menyimpan maklumat tetap atau berubah
 * @param globalvar <code>globalvar</code> menyimpan semua element atau sifat2 element dalam bentuk variable baru samada variable itu bentuk <code>final</code> atau <code>static</code>
 */

public interface globalvar {

    public final static String title = "Bank Negaraku";
    public final static String Message = "Selamat Datang, Sila pilih option anda\n1. Akaun anda\n2. Baki\n3. Pengeluaran Wang\n4. Topup";

    public interface Newbie {
        public final static String title = "Selamat Datang";
        public final static String Message = "Kami berbesar hati untuk mengajak anda mendaftar bank ini. Terima kasih kerana ingin mendaftar disini. Tekan OK untuk kita mulakan.";
    }

    public interface JOptionPane {
        public final int Default = -1;
        public final int err = 0;
        public final int warn = 2;
    }

}
