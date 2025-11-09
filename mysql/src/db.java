

import java.sql.*;

import javax.swing.JOptionPane;

public class db {

    public static void db_Update(int moneyadd, int cardnumbers){

		try {
			Connection connection = DriverManager.getConnection(Global.URL, Global.USERNAME, Global.PW);

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from " + Global.DB);

			while (rs.next()) {
				Integer moneyAdd = rs.getInt(2) + moneyadd;
				statement.executeUpdate("update bank set money = "+ moneyAdd + " where cardnumbers = " + cardnumbers );

				JOptionPane.showMessageDialog(null, "sila check kembali!", "Ditambah", JOptionPane.INFORMATION_MESSAGE);
			}

			connection.close();

		} catch (Exception e) {}
    }

	public static void db_query(int cardnumbers){

		try {
			Connection connection = DriverManager.getConnection(Global.URL, Global.USERNAME, Global.PW);

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from " + Global.DB + " where cardnumbers = " + cardnumbers );

			while (rs.next()) {
				if (cardnumbers == rs.getInt(2)){
					int x = JOptionPane.showConfirmDialog(null, "Baki anda ialah RM : " + rs.getInt(2), "Baki wang", JOptionPane.YES_NO_OPTION);

					if (x == JOptionPane.YES_OPTION){
						option.condition = false;
					}

					else if (x == JOptionPane.NO_OPTION){
						option.condition = true;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nombor kad bank yang anda masukkan\ntidak terdaftar. sila daftar kembali!", "Harap Maaf!", JOptionPane.ERROR_MESSAGE);
				}
			}

			connection.close();

		} catch (Exception e) {}
    }
}











/*
 * 
 * try {
			
			Connection connection = DriverManager.getConnection(Global.URL, Global.USERNAME, Global.PW);

			Statement statement = connection.createStatement();

			int rowsAffected = statement.executeUpdate("update bank set money = 9000 where cardnumbers = 12345678");

			System.out.println("Berjaya kemaskini " + rowsAffected + " rekod.");

            // while (resultSet.next()) {
            //     System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
            // }

			connection.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
 */