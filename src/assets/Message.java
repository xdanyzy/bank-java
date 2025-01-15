package assets;

import javax.swing.JOptionPane;

public class Message extends JOptionPane {

    globalvar apply;

    String message;
    String title;
    int type;

    public Message(String message, String title, int type){
        this.message = message;
        this.title = title;
        this.type = type;

        showMessageDialog(null, this.message, this.title, this.type);
    }

    public static class ErrorMessage extends Message {
        final int type = 0;
        public ErrorMessage(String message, String title, int type){
            super(message, title, type);
        }
    }
}
