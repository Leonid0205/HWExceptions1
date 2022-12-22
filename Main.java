import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
 * и возвращающий новый массив, каждый элемент которого равен разности элементов
 * двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо
 * как-то оповестить пользователя.
 */

/**
 * Main
 */
public class Main {

    public static int[] CreateArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-100, 100);
        }
        return array;
    }

    public static int[] arraysSubtraction(int[] array1, int[] array2) {
        int[] array = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            array[i] = array1[i] - array2[i];
        }
        return array;
    }

    public static int check(String text) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(text);
                int size = scanner.nextInt();
                if (size == 0 || size < 0) {
                    throw new Exception();
                } else {
                    return size;
                }
            } catch (InputMismatchException  e) {
                System.out.print("\n");
                System.out.println("InputMismatchException! The size of an array must be an int number, try again!\n");
                scanner.nextLine();
                continue;
            } catch (Exception e) {
                System.out.print("\n");
                System.out.println("Exception! The size of an array must be more than zero, try again!\n");
                scanner.nextLine();
                continue;
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            try {
                int sizeFirstArray = check("Input size of a first array: ");
                System.out.print("\n");
                int sizeSecondArray = check("Input size of a second array: ");
                System.out.print("\n");
                int[] array1 = CreateArray(sizeFirstArray);
                System.out.println(String.format("%-10s= %s", "First array ", Arrays.toString(array1)));
                System.out.print("\n");
                int[] array2 = CreateArray(sizeSecondArray);
                System.out.println(String.format("%-10s= %s", "Second array ", Arrays.toString(array2)));
                System.out.print("\n");
                if (sizeFirstArray == sizeSecondArray) {
                    int[] array = arraysSubtraction(array1, array2);
                    System.out.println(String.format("%-10s= %s", "Result of a subtraction ", Arrays.toString(array)));
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Exception! Sizes of first and second arrays have to be equal!\n");
            }
        }
    }
}