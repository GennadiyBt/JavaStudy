package HomeWork1;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class JavaHomeWork1 {
    public static void main(String[] args) throws IOException {
        int i = randomNum();
        System.out.println(i);
        while (i == 0) {    // Здесь лучше, наверноеб делать через try, но я с исключениями пока не очень
            i = randomNum();
        }
        int n = numPos(i);
        int m1_size = arraySize1(i, n);
        int m2_size = arraySize2(i, n);
        int[] m1 = new int[m1_size];
        m1 = m1_complete(m1, i, n);
        writeFile("HomeWork1/m1.txt", m1);
        int[] m2 = new int[m2_size];
        m2 = m2_complete(m2, i, n);
        writeFile("HomeWork1/m2.txt", m2);
    }
    static short randomNum(){
        Random random = new Random();
        short ran = (short)random.nextInt();
        return ran;   
    }

    static int numPos(int num){
        return (int)(Math.log(Math.abs(num)) / Math.log(2))+1;
    }
    static int arraySize1(int a, int b){
        int size;
        if (a > 0) {
            size = Short.MAX_VALUE/b - a/b;
        }
        else {
            size = Short.MAX_VALUE/b + Math.abs(a)/b;   
        }
        
        return size;
    }

    static int arraySize2(int a, int b){      
        int size;
        if (a > 0) {
            size = a - Short.MIN_VALUE - Math.abs(Integer.MIN_VALUE)/b - a/b; 
        }
        else {
            size = Math.abs(Short.MIN_VALUE/b - a/b);   
        }
        
        return size;
    }

    static int[] m1_complete(int[] array , int i, int n){
        int pos = 0;
        for (int index = i+1; index <= Short.MAX_VALUE; index++) {
            if (index%n == 0 && index != 0) {
                array[pos] = index;
                pos++;
            }
        }
        return array;
    }

    static int[] m2_complete(int[] array , int i, int n){
        int pos = 0;
        for (int index = Short.MIN_VALUE; index < i; index++) {
            if (index%n != 0 && index != 0) {
                array[pos] = index;
                pos++;
            }
        }
        return array;
    }

    static void writeFile(String filename, int[] array) throws IOException{
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        for (int j = 0; j < array.length; j++){
            outputWriter.write(Integer.toString(array[j]) + " ");
            
        }
        outputWriter.flush();  
        outputWriter.close();
    }
}