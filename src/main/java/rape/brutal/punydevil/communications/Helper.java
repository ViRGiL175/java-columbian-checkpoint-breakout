package rape.brutal.punydevil.communications;

import java.util.Scanner;

/**
 * Created by XXX on 23.02.2017.
 */
public class Helper {

    public static int SetNumber(){
        System.out.print("введи номер: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String SetText(){
        System.out.print("введи текст: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
