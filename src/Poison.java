import java.util.Random;

public class Poison extends Cell{
    private Random random;
    private Snake snake;

    public Poison(Snake snake) {
        super(1, 1, GameSnake.CELL_SIZE, GameSnake.POISON_COLOR);
        random = new Random();
        this.snake = snake;
    }

    public boolean isPoison(int x, int y) {
        return (getX() == x && getY() == y);
    }
}
