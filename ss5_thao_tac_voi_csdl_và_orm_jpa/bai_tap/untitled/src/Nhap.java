import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nhap {
        public static void main(String[] args) {
            int l = 9;
            int r = 13;
            int[] array = new int[5];
            for (int i= 0; i<array.length;i++){
                array[i] = i+9;
            }

            System.out.printf(Arrays.toString(array));
    }
}
