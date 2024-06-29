import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Snake {

    private char[][] snakeBoard;
    Queue<Node> path = new LinkedList<>();
    Snake(int row , int col){
        this.snakeBoard = new char[row][col];
        path.add(new Node(0,0));
        this.snakeBoard[1][0] ='X';
        this.snakeBoard[2][2] ='X';
        this.snakeBoard[3][4] ='X';
        this.snakeBoard[5][2] ='X';

    }
    public void snakeMove(int row,int col){
        if(row >= 0 && row < snakeBoard.length && col < snakeBoard.length && col >=0) {
            if (snakeBoard[row][col] == '.') {
                System.out.println("Game Over!!!");
                System.exit(0);
            }
            path.add(new Node(row, col));
            if (snakeBoard[row][col] != 'X') {
                Node node = path.poll();
                int r = node.getRow();
                int c = node.getCol();
                snakeBoard[r][c] = '\0';
                //for changing the tail of the snake to the "0"
                snakeBoard[row][col] = '.';
            while (!path.isEmpty()) {
                displaySnake();
                System.out.print("Enter a position : ");
                Scanner s = new Scanner(System.in);
                char direction = s.next().charAt(0);

                if (direction == 'U') {
                    snakeMove(--row, col);
                }
                if (direction == 'D') {
                    snakeMove(++row, col);
                }
                if (direction == 'R') {
                    snakeMove(row, ++col);
                }
                if (direction == 'L') {
                    snakeMove(row, --col);
                }
            }
        }
            else {
                System.out.println("Invalid move");
                System.exit(0);
            }
        }

        }
    public void displaySnake() {
        for (char[] chars : snakeBoard) {
            for (int j = 0; j < snakeBoard[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }
}

