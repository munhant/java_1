import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Введите выражение соответсвующее условию 'число' пробел 'оператор' пробел 'число'\"");
        String primer = scanner.nextLine();
        Calc ch = new Calc();
        String rezult =ch.rezult(primer);
        System.out.println(rezult);
    }
}
