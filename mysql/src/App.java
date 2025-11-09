
import javax.swing.JOptionPane;

public class App extends option {

	public App() {
		
		try {
			Option();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Input dalam String tidak dibenarkan!", "Error pada input", JOptionPane.WARNING_MESSAGE);
			Option();
		}
	}

	public static void main(String[] args) {
		new App();
	}
}