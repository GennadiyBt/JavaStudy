import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class JavaHomeWork4 {
    public static void main(String[] args) {
        // Задача 1.
        long startLinked_task1 = System.currentTimeMillis();
        LinkedList <Integer> work_list = new LinkedList<>();
        work_list = random_list(work_list);
        long endLinked_task1 = System.currentTimeMillis();
        long timeLinked_task1 = endLinked_task1 - startLinked_task1;
        System.out.println("Time of task1 for LinkedList: " + timeLinked_task1);
        // Задача 2.
        long startLinked_task2 = System.currentTimeMillis();
        LinkedList <Integer> work_list1 = new LinkedList<>();
        work_list1 = del_negative(work_list);
        long endLinked_task2 = System.currentTimeMillis();
        long timeLinked_task2 = endLinked_task2 - startLinked_task2;
        System.out.println("Time of task2 for LinkedList: " + timeLinked_task2);
        // Задача 3.
        //LinkedList <Integer> work_list2 = change(work_list);
        // Задача 4.
        long startLinked_task4 = System.currentTimeMillis();
        work_list = change_all(work_list);
        long endLinked_task4 = System.currentTimeMillis();
        long timeLinked_task4 = endLinked_task4 - startLinked_task4;
        System.out.println("Time of task4 for LinkedList: " + timeLinked_task4);

        long startArray_task1 = System.currentTimeMillis();
        ArrayList <Integer> test_array = new ArrayList<>();
        test_array = random_array(test_array);
        long endArray_task1 = System.currentTimeMillis();
        long timeArray_task1 = endArray_task1 - startArray_task1;
        System.out.println("Time of task1 for ArrayList: " + timeArray_task1);
    
        ArrayList <Integer> test_array1 = new ArrayList<>();
        long startArray_task2 = System.currentTimeMillis();
        test_array1 = del_negative_array(test_array);
        long endArray_task2 = System.currentTimeMillis();
        long timeArray_task2 = endArray_task2 - startArray_task2;
        System.out.println("Time of task2 for ArrayList: " + timeArray_task2);

        long startArray_task4 = System.currentTimeMillis();
        test_array = change_all_array(test_array);
        long endArray_task4 = System.currentTimeMillis();
        long timeArray_task4 = endArray_task4 - startArray_task4;
        System.out.println("Time of task4 for ArrayList: " + timeArray_task4);

        // Исполнение оптимизированных вариантов

        work_list = random_list(work_list);
        long startLinked_task2_opt = System.currentTimeMillis();
        work_list1 = del_negative_opt(work_list);
        long endLinked_task2_opt = System.currentTimeMillis();
        long timeLinked_task2_opt = endLinked_task2_opt - startLinked_task2_opt;
        System.out.println("Time of task2 for LinkedList after optimisation: " + timeLinked_task2_opt);

        long startLinked_task4_opt = System.currentTimeMillis();
        work_list1 = change_all_opt(work_list);
        long endLinked_task4_opt = System.currentTimeMillis();
        long timeLinked_task4_opt = endLinked_task4_opt - startLinked_task4_opt;
        System.out.println("Time of task4 for LinkedList after optimisation: " + timeLinked_task4_opt);

        test_array = random_array(test_array);
        long startArray_task2_opt = System.currentTimeMillis();
        test_array1 = del_negative_array_opt(test_array);
        long endArray_task2_opt = System.currentTimeMillis();
        long timeArray_task2_opt = endArray_task2_opt - startArray_task2_opt;
        System.out.println("Time of task2 for ArrayList after optimisation: " + timeArray_task2_opt);

        long startArray_task4_opt = System.currentTimeMillis();
        test_array = change_all_array_opt(test_array);
        long endArray_task4_opt = System.currentTimeMillis();
        long timeArray_task4_opt = endArray_task4_opt - startArray_task4_opt;
        System.out.println("Time of task4 for ArrayList after optimisation: " + timeArray_task4_opt);
    }

    static LinkedList <Integer> random_list(LinkedList <Integer> list_arg){
        Random r = new Random();
        for (int index = 0; index < 100000; index++) {
            list_arg.add(r.nextInt(2048 + 1) - 1024);
        }
        return list_arg;
    }

    static LinkedList <Integer> del_negative(LinkedList <Integer> list_arg){
        for (int index = list_arg.size()-1; index >= 0; index--) { // Цикл с конца списка для ухода от необходимости корректировать индексю
            if (list_arg.get(index) < 0) {
                list_arg.remove(index);
            }
        }
        return list_arg;
    }

    static LinkedList <Integer> change(LinkedList <Integer> list_arg){
        int a = list_arg.get(0);
        int b = list_arg.get(1);
        list_arg.remove(1);
        list_arg.remove(0);
        list_arg.add(0, a+b);
        return list_arg;
    }

    static LinkedList <Integer> change_all(LinkedList <Integer> list_arg){
        int a; int b;
        for (int index = 0; index < list_arg.size()-1; index++) {
            a = list_arg.get(index);
            b = list_arg.get(index + 1);
            list_arg.remove(index);
            list_arg.remove(index);
            list_arg.add(index, a+b);
        }
        return list_arg;
    }

    // Метод для ArrayList
    static ArrayList <Integer> random_array(ArrayList <Integer> list_arg){
        Random r = new Random();
        for (int index = 0; index < 100000; index++) {
            list_arg.add(r.nextInt(2048 + 1) - 1024);
        }
        return list_arg;
    }

    static ArrayList <Integer> del_negative_array(ArrayList <Integer> list_arg){
        for (int index = list_arg.size()-1; index >= 0; index--){
            if (list_arg.get(index) < 0) {
                list_arg.remove(index);
            }
        }
        return list_arg;
    }

    static ArrayList <Integer> change_all_array(ArrayList <Integer> list_arg){
        int a; int b;
        for (int index = 0; index < list_arg.size()-1; index++) {
            a = list_arg.get(index);
            b = list_arg.get(index+1);
            list_arg.remove(index);
            list_arg.remove(index);
            list_arg.add(index, a+b);
        }
        return list_arg;
    }
    // Оптимизация

    static LinkedList <Integer> del_negative_opt(LinkedList <Integer> list_arg){
        ListIterator <Integer> iter = list_arg.listIterator();
        while (iter.hasNext()) {
            if (iter.next()<0) {
               iter.remove(); 
            } 
        }
        return list_arg;
    }

    static LinkedList <Integer> change_all_opt(LinkedList <Integer> list_arg){
        if (list_arg.size() %2 != 0) {  // В случае нечетного количества элементов код не сработает, поэтому проверяем на четность и 
                                        // при необходимости добавляем один элемент, не влияющий на сумму
            list_arg.add(0);
        }
        ListIterator <Integer> iter = list_arg.listIterator();
        int temp = 0;
        while (iter.hasNext()) {
           temp = iter.next();
           iter.remove();
           temp += iter.next();
           iter.remove();
           iter.add(temp); 
        }
        return list_arg;
    }

    static ArrayList <Integer> del_negative_array_opt(ArrayList <Integer> list_arg){
        list_arg.removeIf(i -> i < 0);
        return list_arg;
    }

    static ArrayList <Integer> change_all_array_opt(ArrayList <Integer> list_arg){
        if (list_arg.size() %2 != 0) { 
            list_arg.add(0);
        }
        ArrayList <Integer> temp_array = new ArrayList<>(list_arg.size()/2);
        int a; int b;
        for (int index = 0; index < list_arg.size()-1; index +=2) {
            a = list_arg.get(index);
            b = list_arg.get(index+1);
            temp_array.add(a+b);
        }

        return temp_array;
    }
}