import java.awt.BorderLayout;
import javax.swing.*;

public class frameview extends JFrame {
    private final JButton bottone = new JButton("genera");
    private final JTextArea textArea = new JTextArea();
    private final JTextField textField = new JTextField();

    public frameview() {
        super("psw gen");
        setLayout(new BorderLayout());
        add(textField, BorderLayout.PAGE_START);
        add(bottone, BorderLayout.PAGE_END);
        add(textArea, BorderLayout.CENTER);
        JScrollPane scrollbar= new JScrollPane(textArea);
        add(scrollbar);
        textField.setToolTipText("inserisci lunghezza password");
       textArea.setEditable(false);
      bottone.addActionListener(e -> {
          String lenghtppsw = textField.getText();

          try {
              String uniqueidchar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789$&%";
              char[] resultpsw = new char[Integer.parseInt(lenghtppsw)];

              for(int i = 0; i < Integer.parseInt(lenghtppsw); ++i) {
                  int n = 1 + (int)(Math.random() * (double)Integer.parseInt(lenghtppsw));
                  resultpsw[i] = uniqueidchar.charAt(n);
              }

              String pswfinal = new String(resultpsw);
              textArea.append(pswfinal + "\n");
          } catch (StringIndexOutOfBoundsException e1) {
              JOptionPane.showMessageDialog(null, "Non puoi inserire piu di 64 carrateri.", "Attenzione", JOptionPane.WARNING_MESSAGE);
              e1.printStackTrace();
          } catch (NumberFormatException e1) {
              JOptionPane.showMessageDialog(null, "Errore non e un numero intero", "errore", JOptionPane.ERROR_MESSAGE);
              e1.printStackTrace();
              System.exit(1);
          }

      });
        setResizable(false);
        setLocation(500, 400);
        setSize(800, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
