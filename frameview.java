package pswgen;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class frameview extends JFrame {
    private JButton bottone;
    private JTextArea textArea;
    private JTextField textField;

    public frameview() {
        super("psw gen");
        setLayout(new BorderLayout());
        textField = new JTextField();
        bottone = new JButton("genera");
        textArea = new JTextArea();
        add(textField, BorderLayout.PAGE_START);
        add(bottone, BorderLayout.PAGE_END);
        add(textArea, BorderLayout.CENTER);
        JScrollPane scrollbar= new JScrollPane(textArea);
        add(scrollbar);
        textField.setToolTipText("inserisci lunghezza password");
        textArea.setEditable(false);
        setResizable(false);
        setLocation(500, 400);
        setSize(800, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void setButtonActionListener(ActionListener listener){
        bottone.addActionListener(listener);
    }
    public String getLenghtppsw(){
        return textField.getText();
    }
    public void appendTextArea(String text){
        textArea.append(text + "\n");
    }
    public void showMessageDialog(String message,String title,int messageType){
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
    public void exitOnError(){
        System.exit(1);
    }
}
