
public class PhotoMagicDeluxe extends PhotoMagic {
    public static void main(String[] args) {
        Picture p = new Picture("C:/Users/amanb/Documents/CS3-Labs/Lab20-Cryptography/mystery.png");
        LFSR l = new LFSR((getRegister("OPENSESAME")), 58);
        Picture one = transform(p, l);
        one.show();
    }
    private static String getRegister(String s) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        String reg = "";
        for(char c : s.toCharArray())
            reg += String.format("%6s", Integer.toBinaryString((short)alpha.indexOf(c))).replace(' ', '0');;
        return reg;
    }
}
