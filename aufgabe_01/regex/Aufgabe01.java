import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aufgabe01 {
    public static void main(String[] args) {

        String[] input = {
                "xxx %d yyy%n",
                "xxx%1$d yyy",
                "%1$-02.3dyyy"
        };


        String txt = "";
        String frmt = "";
        Pattern p = Pattern.compile("%([1-9][0-9]*\\$)?(-?[0-9]*)?\\.?([0-9]*)?[dn]");
        //Pattern p = Pattern.compile("\\$");
        for (String str : input) {
            int i = 0;
            Matcher m = p.matcher(str);
            while (m.find() == true) {
                if (i != m.start()) {
                    txt = str.substring(i, m.start());
                    System.out.print("TEXT(\"" + txt + "\")");
                }
                frmt = str.substring(m.start(), m.end());
                System.out.print("FORMAT(\"" + frmt + "\")");
                i = m.end();
            }
            if (i < str.length()) {
                txt = str.substring(i);
                System.out.print("TEXT(\"" + txt + "\")");
            }
            System.out.println("\n");
        }



    }
}