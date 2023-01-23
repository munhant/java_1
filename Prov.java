import java.util.HashMap;
import java.util.Map;
public class Prov {


    // Проверка что числа Римские
    private final Map<String, Integer> romeArabMap = new HashMap<>();

    //соответствие римские-арабские наименования чисел
    private final int[] arabDigit = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] romeDigit = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public Prov() {
        romeArabMap.put("I", 1);
        romeArabMap.put("II", 2);
        romeArabMap.put("III", 3);
        romeArabMap.put("IV", 4);
        romeArabMap.put("V", 5);
        romeArabMap.put("VI", 6);
        romeArabMap.put("VII", 7);
        romeArabMap.put("VIII", 8);
        romeArabMap.put("IX", 9);
        romeArabMap.put("X", 10);
    }

    // Проверка оператора
    public boolean operator(String op){
        return "*".equals(op) || "/".equals(op) || "+".equals(op) || "-".equals(op);
    }

    //Проверка что числа арабские
    public boolean isArab (String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Проверка что числа Римские
    public boolean isRomen (String str){
        return romeArabMap.containsKey(str);
    }

    //Перевод Римских чисел в Арабские
    public Integer romeToArab(String st){
        if (romeArabMap.containsKey(st)){
            return romeArabMap.get(st);
        }
        return null;
    }

    //Перевод Арабских чисел в Римские
    public String arabToRome (int a){
        String rez = new String();
        for (int i = 0; i<arabDigit.length; i++){
            while((a - arabDigit[i])>=0){
                a -= arabDigit[i];
                rez +=(romeDigit[i]);
            }
        }
        return rez.toString();
    }
}
