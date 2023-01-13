package pswgen;

import javax.swing.*;
public class Controller {

    private frameview frameView;
    private Model model;

    public Controller(frameview frameView, Model model) {
        this.frameView = frameView;
        this.model = model;
        frameView.setButtonActionListener(e -> {
            String lenghtppsw = frameView.getLenghtppsw();
            try {
                String pswfinal = model.generatePassword(Integer.parseInt(lenghtppsw));
                frameView.appendTextArea(pswfinal);
            } catch (StringIndexOutOfBoundsException e1) {
                frameView.showMessageDialog("Non puoi inserire piu di 64 carrateri.","Attenzione", JOptionPane.WARNING_MESSAGE);
                e1.printStackTrace();
                frameView.exitOnError();
            } catch (NumberFormatException e1) {
                frameView.showMessageDialog("Errore non e un numero intero","errore", JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
                frameView.exitOnError();
            }
        });
    }
}

