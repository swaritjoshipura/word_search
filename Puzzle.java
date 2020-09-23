import java.io.*;
import java.util.Scanner;

public class Puzzle {
    /***
     *constructor: fn is the filename
     *where the puzzle is stored
     ***/
    private int [] to_return;
    private static char[][] puzzle;

    public Puzzle(String fn) {
        try {
            Scanner scanner = new Scanner(new File(fn));
            int dumb_size = scanner.nextInt();
            scanner.nextLine();
            String firstLine = scanner.nextLine();
            int grid = firstLine.length();
            puzzle = new char[dumb_size][dumb_size];
            for (int j = 0; j  < grid; j ++) {
                puzzle[0][j] = firstLine.charAt(j);
            }
            int till= 1;
            while (scanner.hasNextLine() && till  < dumb_size) {
                String line = scanner.nextLine();
                for (int j = 0; j < dumb_size; j++) {
                    puzzle[till][j] = line.charAt(j);
                }
                till ++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /***
     *search the puzzle for the given word
     *return {a, b, x, y} where (a, b) is
     *the starting location and (x, y) is 
     *the ending location
     *return null if the word can't be found
     *in the puzzle
     ***/
    public int[] search(String word) {
        boolean flag = false;
        for (int i = 0; i < puzzle[0].length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                if (puzzle[i][j] == word.charAt(0) && !flag) {
                    if(word_exists(word, i, j)) {
                        return to_return;
                    }
                }
            }
        }
        return null;
    }
    private boolean word_exists(String word, int row, int col) {
        int till = word.length() + col;
        if ((till) <= puzzle[0].length) {
            int index = 0;
            for (int i = col; i <= (till) - 1; i++) {
                if (word.charAt(index) != puzzle[row][i]) {
                    break;
                }
               else if (i == (till) - 1) {
                    to_return = new int[]{row, col, row, i};
                    return true;
                }
                index++;
            }
        }
        if ((col - word.length()) > 0) {
            int index = 0;
            for (int i = col; i >= (col - word.length()) + 1; i--) {
                if (word.charAt(index) != puzzle[row][i]) {
                    break;
                }
                 else if (i == (col - word.length()) + 1) {
                    to_return = new int[]{row, col, row, i};
                    return true;
                }
                index++;
            }
        }

        if ((row - word.length()) > 0) {
            int index = 0;
            for (int i = row; i >= (row - word.length()) + 1; i--) {
                if (word.charAt(index) != puzzle[i][col]) {
                    break;
                }
               else if (i == (row - word.length()) + 1) {
                    to_return = new int[]{row, col, i, col};
                    return true;
                }
                index++;
            }
        }
        if ((row - word.length()) > 0 && (col - word.length()) > 0) {
            int index = 0;
            int j = col;
            for (int i = row; i >= (row - word.length()) + 1; i--) {
                if (word.charAt(index) != puzzle[i][j]) {
                    break;
                }
                else if (i == (row - word.length()) + 1) {
                    to_return = new int[]{row, col, i, j};
                    return true;

                }
                index++;
                j--;
            }
        }
        if ((row + word.length()) <= puzzle[0].length) {
            int index = 0;
            for (int i = row; i <= (row + word.length()) - 1; i++) {
                if (word.charAt(index) != puzzle[i][col]) {
                    break;
                }
               else if (i == (row + word.length()) - 1) {
                    to_return = new int[]{row, col, i, col};
                    return true;
                }
                index++;
            }
        }
        if ((row - word.length()) > 0 && (col + word.length()) <= puzzle[0].length) {
            int index = 0;
            int j = col;
            for (int i = row; i >= (row - word.length()) + 1; i--) {
                if (word.charAt(index) != puzzle[i][j]) {
                    break;
                }
               else if (i == (row - word.length()) + 1) {
                    to_return = new int[]{row, col, i, j};
                    return true;
                }
                index++;
                j++;
            }
        }
        if ((row + word.length()) <= puzzle[0].length && (col - word.length()) > 0) {
            int index = 0;
            int j = col;
            for (int i = row; i <= (row + word.length()) - 1; i++) {
                if (word.charAt(index) != puzzle[i][j]) {
                    break;
                }
               else if (i == (row + word.length()) - 1) {
                    to_return = new int[]{row, col, i, j};
                    return true;

                }
                index++;
                j--;
            }
        }

        if ((row + word.length()) <= puzzle[0].length && (col + word.length()) <= puzzle[0].length) {
            int index = 0;
            int j = col;
            for (int i = row; i <= (row + word.length()) - 1; i++) {
                if (word.charAt(index) != puzzle[i][j]) {
                    break;
                }
              else if (i == (row + word.length()) - 1) {
                    to_return = new int[]{row, col, i, j};
                    return true;
                }
                index++;
                j++;
            }
        }
        return false;
    }
}
