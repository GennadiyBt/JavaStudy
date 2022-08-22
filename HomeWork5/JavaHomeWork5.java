import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class JavaHomeWork5 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Стругацкие", "Трудно быть богом");
        map.put("Беляев", "Звезда КЭЦ");
        map.put("Симонов", "Живые и мертвые");
        map.put("Рапов", "Зори над Русью");
        map.put("Гете", "Фауст");
        map.put("Крапивин", "Мальчик со шпагой");
        map.put("Митяев", "Книга будущих командиров");
        map.put("Булгаков", "Собачье сердце");
        map.put("Гоголь", "Вечера на хуторе близ Диканьки");
        map.put("Ницше", "Сумерки богов");

        System.out.println(map);
        System.out.println("");

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> e = iterator.next();
            map.put(e.getKey(), e.getValue() + "!");
        }
        System.out.println(map);
        System.out.println("");

        //map.putIfAbsent("Бхаргава", "Грокаем алгоритмы"); // Вариант решения задачи 4

        // Комплексное решение задач 4 и 5

        System.out.println(task4and5(map, "Стругацкие"));
        System.out.println("");
        System.out.println(task4and5(map, "Бхаргава"));
        System.out.println("");

        // Задача 6
        map.forEach((k,v) -> System.out.println(k + "-" + v)); 
        System.out.println("");

        // Задача 7
        for (Map.Entry<String, String> e: map.entrySet()) {
            map.put(e.getKey(), e.getValue() + "(просмотрен)");
            System.out.println(e);
        }

    }
    
    static HashMap<String, String> task4and5(HashMap<String, String> map_arg, String key){

        if (map_arg.containsKey(key)) {
            map_arg.put(key, map_arg.get(key).substring(map_arg.get(key).indexOf(' ')+1));
        }
        else{
            map_arg.putIfAbsent(key, "Грокаем алгоритмы"); // Можно заморочится и  ввсести в метод третий аргумент - название книги
                                                                    // с возможностью определения "по умолчанию", но это же не цель этого ДЗ )
        }
        return map_arg;
    }
}