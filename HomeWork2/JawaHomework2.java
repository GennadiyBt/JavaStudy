package HomeWork2;

import java.util.HashMap;
import java.util.Set;
import java.lang.StringBuffer;
import java.lang.String;

public class JawaHomework2 {
    public static void main(String[] args) {
        //String main_str = "this is a test string";
        //String test_str = "tist";
        //System.out.println(find_min_win(main_str, test_str));

        //String string1 = "skad";
        //String string2 = "daks";
        //System.out.println(palindrom(string1, string2));

        //computing_string();

        replace_str();
    }
    
    //Задача 1. Предполагается, что искомое окно в исходной строке присутствует минимум один раз
    static String find_min_win(String main_str, String test_str){
        String min_window = main_str;
        int min_size = main_str.length();
        String result = "";
        int size = 0;
        int num = 0;
        while (num <= (main_str.length() - test_str.length())) {
            HashMap<Character, Integer> map = new HashMap<>();   
            for (char i : test_str.toCharArray()) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) +1 );
                }
                else {
                    map.put(i,1);
                }
            }
            Set<Character> setKeys = map.keySet();
            if (setKeys.contains(main_str.charAt(num))){
                int start = num;
                int end = num;
                for (int index = num; index < main_str.length(); index++) {
                    boolean flag = true;
                    if (setKeys.contains(main_str.charAt(index))){ 
                        map.put(main_str.charAt(index), map.get(main_str.charAt(index)) - 1 );
                        for (int j : map.values()) {
                            if (j > 0){
                                flag = false;
                                break;
                            }
                        }  
                        if (flag){
                            end = index+1;
                            result = main_str.substring(start, end);
                            size = result.length();
                            break;
                        }  
                    }
                }    
            }
            if (size < min_size) {
                min_window = result;
                min_size = size;
            }
            num++;            
        }
        return min_window;    
    }

    //Задача 2
    static Boolean palindrom(String string1, String string2){
        String reverse = new StringBuffer(string1).reverse().toString();
        if (reverse.equals(string2)) {
            return true;
        } else {
            return false;
        }
    }

    //Задача 3
    public static String reverse_recursion(String string_arg) {
        String right;
        String left;
        int size = string_arg.length();

        if (size <= 1) {
            return string_arg;
        }
 
        left = string_arg.substring(0, size / 2);
        right = string_arg.substring(size / 2, size);
        return reverse_recursion(right) + reverse_recursion(left);
    }

    //Задача 4
    static void computing_string(){
        StringBuilder sum = new StringBuilder();
        sum.append(3);
        sum.append(" + ");
        sum.append(56);
        sum.append(" = ");
        sum.append(3+56);
        System.out.println(sum);
        sum.deleteCharAt(7);

        StringBuilder diff = new StringBuilder();
        diff.append(3);
        diff.append(" - ");
        diff.append(56);
        diff.append(" = ");
        diff.append(3-56);
        System.out.println(diff);

        StringBuilder mult = new StringBuilder();
        mult.append(3);
        mult.append(" * ");
        mult.append(56);
        mult.append(" = ");
        mult.append(3*56);
        System.out.println(mult);

        //Задача 5
        sum.insert(7, "равно");
        System.out.println(sum);

        //Задача 6
        diff.replace(7, 8, "равно");
        System.out.println(diff);
    }

    //Задача 7
    static void replace_str(){
        StringBuilder test_str = new StringBuilder();
        String test_str2 = "";
        for (int index = 0; index < 100000; index++) {
            test_str.append("=");
            test_str2 += "=";
        }

        long start_test_str = System.currentTimeMillis();
        for (int i = 0; i < test_str.length(); i+=5) {
            test_str.replace(i, i+1, "равно");
        }
        long fin_test_str = System.currentTimeMillis();
        long timeStringBuild = fin_test_str - start_test_str;
        System.out.println("Время выполнения с помощью StringBuilder: " + timeStringBuild);

        long start_test_str2 = System.currentTimeMillis();
        String new_test_str2 = test_str2.replace("=", "равно");
        //test_str2.replace("=", "равно");
        long fin_test_str2 = System.currentTimeMillis();
        long timeString = fin_test_str2 - start_test_str2;
        System.out.println("Время выполнения с помощью String: " + timeString);
    }


    
}
