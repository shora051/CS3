
import java.awt.*;

public class PhotoMagic {
    public static void main(String[] args) {
     Picture p = new Picture("C:/Users/amanb/Documents/CS3-Labs/Lab20-Cryptography/pipe.png");
     //Picture p = new Picture("C:/Users/amanb/Documents/CS3-Labs/Lab20-Cryptography/Output.png");
       p.show();
        LFSR l = new LFSR("01101000010100010000", 16);
        Picture r = transform(p, l);
        r.show();

    }
    public static Picture transform(Picture pic,LFSR lfsr) {
        Picture base = new Picture(pic.width(), pic.height());
        for(int i = 0; i < pic.width(); ++i)
            for(int j = 0; j < pic.height(); ++j)
                base.set(i, j, new Color(
                        pic.get(i, j).getRed() ^ lfsr.generate(8),
                        pic.get(i, j).getGreen() ^ lfsr.generate(8),
                        pic.get(i, j).getBlue() ^ lfsr.generate(8)
                ));
         return  base;

    }
}
