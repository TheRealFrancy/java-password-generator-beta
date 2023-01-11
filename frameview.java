import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class frameview extends JFrame {
    private final JButton bottone = new JButton("genera");
    private final JTextArea textArea = new JTextArea();
    private final JTextField textField = new JTextField();

    public frameview() {
        super("psw gen");
        this.setLayout(new BorderLayout());
        this.add(this.textField, "First");
        this.add(this.bottone, "Last");
        this.add(this.textArea, "Center");
        this.textField.setToolTipText("inserisci lunghezza password ");
        this.textArea.setEditable(false);
        this.bottone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String lenghtppsw = frameview.this.textField.getText();

                try {
                    String uniqueidchar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789$&%";
                    char[] resultpsw = new char[Integer.parseInt(lenghtppsw)];

                    for(int i = 0; i < Integer.parseInt(lenghtppsw); ++i) {
                        int n = 1 + (int)(Math.random() * (double)Integer.parseInt(lenghtppsw));
                        resultpsw[i] = uniqueidchar.charAt(n);
                    }

                    String pswfinal = new String(resultpsw);
                    frameview.this.textArea.append(pswfinal + "\n");
                } catch (StringIndexOutOfBoundsException var7) {
                    JOptionPane.showMessageDialog((Component)null, "Non puoi inserire piu di 64 carrateri.", "Attenzione", 2);
                    var7.printStackTrace();
                } catch (NumberFormatException var8) {
                    JOptionPane.showMessageDialog((Component)null, "Errore non e un numero intero", "errore", 0);
                    var8.printStackTrace();
                    System.exit(1);
                }

            }
        });
        this.setResizable(false);
        this.setLocation(500, 400);
        this.setSize(800, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }
}
