package pswgen;

public class Model {
    private final String uniqueidchar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789$&%";
    public String generatePassword(int lenghtppsw) {
        char[] resultpsw = new char[lenghtppsw];
        for(int i = 0; i < lenghtppsw; ++i) {
            int n = 1 + (int)(Math.random() * lenghtppsw);
            resultpsw[i] = uniqueidchar.charAt(n);
        }
        return new String(resultpsw);
    }
}
