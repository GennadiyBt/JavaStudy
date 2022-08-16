import java.util.ArrayList;
import java.util.List;

public class HomeWork3 {
    public static void main(String[] args) {
        List<String> task_list1 = create_new_list();   // Вызов метода по задаче 1.
        task_list1 = task2(task_list1); // Задача 2.
        task_list1.add(0, "white"); // Задача 3.
        System.out.println(task_list1);
        String element_ind = task_list1.get(3); // Задача 4.
        System.out.println(element_ind);
        System.out.println(renewal("green!", "orange", task_list1)); // Задача 5.
        task_list1.remove(3); // Задача 6
        System.out.println(task_list1);
        System.out.println(find_elem("grey", task_list1)); // Задача 8 - элемент отсутствует.
        System.out.println(find_elem("grey!", task_list1)); // Задача 8 - элемент присутствует.
        task_list1.sort(null); // Задача 9.
        System.out.println(task_list1);
        List <String> task_list_copy = new ArrayList <>(task_list1); // Задача 9.
        System.out.println("Это копия: " + task_list_copy);
    }

    static List<String> create_new_list(){
        List <String> al = new ArrayList <>();
        al.add("red");
        al.add("blak");
        al.add("green");
        al.add("grey");
        al.add("yellow");
        al.add("blue");
        return al;
    }

    static List<String> task2(List<String> list_arg){
        for (int index = 0; index < list_arg.size(); index++) {
                list_arg.set(index, list_arg.get(index) + "!");
        }
        return list_arg;
    }

    static List<String> renewal(String elem, String new_elem, List<String> list_arg){
        for (int index = 0; index < list_arg.size(); index++) {
            if (list_arg.get(index).equals(elem)) {
                list_arg.set(index, new_elem);
            }
        }
        return list_arg;
    }
    static String find_elem(String elem, List<String> list_arg){
        String result = "Элемент " + elem + " отсутствует в данном массиве";
        for (int index = 0; index < list_arg.size(); index++) {
            if (list_arg.get(index).equals(elem)) {
                result = "Элемент " + elem + " присутствует в данном массиве на позиции " + index;
            }
        }
        return result;
    }
    
}