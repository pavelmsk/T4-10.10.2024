import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filename = "input.txt";
        List<Integer> nums = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                nums.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println(minMoves(nums));
    }

    public static int minMoves(List<Integer> nums) {
        Collections.sort(nums);
        int median = nums.get(nums.size() / 2);
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        return moves;
    }
}
