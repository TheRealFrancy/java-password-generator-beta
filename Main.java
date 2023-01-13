package pswgen;

public class Main {

    public static void main(String[] args) {
        frameview frameView = new frameview();
        Model model = new Model();
        new Controller(frameView, model);

    }

}
