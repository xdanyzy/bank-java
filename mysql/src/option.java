import javax.swing.JOptionPane;

public class option extends db {

    public static String title = "Selamat Datang ke Bank Negara";
	public static String option = "1. Pertanyaa Baki\n2. Tambah Wang\n3. Keluarkan Wang\n4. Pengaturan\n\n";
	public static String input = "Sila pilih : ";
	public static boolean condition = false;

    public static void Option(){

		while (condition == false) {

			String test = JOptionPane.showInputDialog(null, option + input, title, 3);

			Integer optionNumber = Integer.parseInt(test);

			if (optionNumber < 0 || optionNumber > 4){
				JOptionPane.showMessageDialog(null, "Tiada Opsi yang terpilih", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			else if (optionNumber == 1){
				FirstOption();
			} 

			else if (optionNumber == 2){
				SecondOption();
			}

			else if (optionNumber == 3){
				ThirdOption();
			}

			else {
				condition = true;
			}
		}
	}


    public static void FirstOption(){

		try {
			String cardaccess = JOptionPane.showInputDialog(null, "Masukkan nombor kad bank anda : ", "Kad bank", 0);
			int cardacessint = Integer.parseInt(cardaccess);

			db_query(cardacessint);

		} catch (Exception e) {}
	}

	public static void SecondOption(){
		try {
			String Money = JOptionPane.showInputDialog(null, "Berapakah nilai ingin anda masukkan?", "Ringgit", 3);
			int money = Integer.parseInt(Money);

			String CardNumber = JOptionPane.showInputDialog(null, "Masukkan nombor kad bank anda", "Nombor Kad bank", 3);
			int cardNumber = Integer.parseInt(CardNumber);

			db_Update(money, cardNumber);

			condition = true;


			// database

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Input dalam String tidak dibenarkan!", "Error pada input", JOptionPane.WARNING_MESSAGE);
			Option();
		}
	}

	public static void ThirdOption(){
		try {
			String Money = JOptionPane.showInputDialog(null, "Berapakah nilai ingin anda Keluarkan?", "Ringgit", 3);
			int money = Integer.parseInt(Money);

			String CardNumber = JOptionPane.showInputDialog(null, "Masukkan nombor kad bank anda", "Nombor Kad bank", 3);
			int cardNumber = Integer.parseInt(CardNumber);

			db_Update(-money, cardNumber);

			condition = true;


			// database

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Input dalam String tidak dibenarkan!", "Error pada input", JOptionPane.WARNING_MESSAGE);
			Option();
		}
	}
}
