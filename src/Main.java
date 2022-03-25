import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> first = new ArrayList<>();
        var n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            first.add(sc.nextLine());
        }
        List<String> second = new ArrayList<>();
        var m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            second.add(sc.nextLine());
        }
        int maxSub = 0;
        int indexI = 0;
        int indexJ = 0;
        while(!first.isEmpty() && !second.isEmpty()) {
            for (int i = 0; i < first.size(); i++) {
                for (int j = 0; j < second.size(); j++) {
                    int subStr = findSubString(first.get(i), second.get(j));
                    if (subStr > maxSub) {
                        maxSub = subStr;
                        indexJ = j;
                        indexI = i;
                    }
                }
            }
            System.out.println(first.get(indexI)+":"+second.get(indexJ));
            first.remove(indexI);
            second.remove(indexJ);
            maxSub=0;
            indexI=0;
            indexJ=0;
        }
        if (!first.isEmpty())
            first.forEach(x -> System.out.println(x+":?"));
        if (!second.isEmpty())
            second.forEach(x->System.out.println("?:"+x));
    }

    public static int findSubString(String str1, String str2) {
        int[][] matrix = new int[str1.length()][str2.length()];
        int wordLength = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i != 0 && j != 0)
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    else
                        matrix[i][j] = 1;
                    if (matrix[i][j] > wordLength) {
                        wordLength = matrix[i][j];
                    }
                }
            }
        }
        return wordLength;
    }
}
