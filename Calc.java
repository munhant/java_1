public class Calc {
   int num1, num2;
    String oper;
    String rezult (String ch){
        boolean rim; // Тригер римских чисел
        int res;
        Prov prov = new Prov();

        String [] primers = ch.split(" ");
        //Проверка что создалось три элемента
        if (primers.length!=3){
            return ("Выражение не соответсвует условию 'число' пробел 'оператор' пробел 'число'");
        }

        oper=primers[1];
        //  Проверка оператора, должен быть: + - * /
        if (!(prov.operator(oper))){
           return ("Оператор '"+oper+"' не подходит условиям");
        }

        // Проверка что оба числа или римские или арабские
        if (prov.isArab(primers[0]) && prov.isArab(primers[2])){      //---проверяем, что оба числа арабские
            num1 = Integer.parseInt(primers[0]);
            num2 = Integer.parseInt(primers[2]);
            rim = false;
        } else if (prov.isRomen(primers[0]) && prov.isRomen(primers[2])){   //---проверяем, что оба числа римские
            num1 = prov.romeToArab(primers[0]);
            num2 = prov.romeToArab(primers[2]);
            rim = true;
        } else {    //--- числа не соответствуют
            return ("Оба числа должы быть или римские или арабские");
        }
        // Проверка что числа в диапозоне от 1 до 10
        if ((num1<1 || num1>10) && (num2<1 || num2>10)){
            return ("Числа должны быть от 1 до 10");
        }
        // Выполнение арефмитических действий
        switch (oper) {
            case "+":
                res = num1+num2;
                break;
            case "-":
                res = num1-num2;
                break;
            case "*":
                res = num1*num2;
                break;
            case "/":
                res = num1/num2;
                break;
            default:
                throw new AssertionError();
        }
        //Возвращаем результат
        if (rim){
            if(res>0){
                return prov.arabToRome(res);
            } else {
                return ("В Римской системе счисления нет отрицательных значений");
            }
        }
        return String.valueOf(res);
    }

}