import javax.swing.*;

public class GamePlay {
    static GameSnake gameSnake = new GameSnake();
    static int snakeSize = gameSnake.snakeSize;

    public static int getSnakeSize() {
        return snakeSize;
    }

    public void game() {
        gameSnake.snake = new Snake(
                gameSnake.START_SNAKE_X,
                gameSnake.START_SNAKE_Y,
                gameSnake.START_SNAKE_SIZE,
                GameSnake.KEY_RIGHT);

        gameSnake.food = new Food(gameSnake.snake);
        gameSnake.poison = new Poison(gameSnake.snake);
        gameSnake.snake.setFood(gameSnake.food);
        gameSnake.snake.setPoison(gameSnake.poison);

        while(!GameSnake.gameOver){
            gameSnake.snake.move();
            if(gameSnake.snake.size() > snakeSize){
                snakeSize = gameSnake.snake.size();
                gameSnake.setTitle(gameSnake.TITLE_OF_PROGRAM + "   Your account: " + (snakeSize - gameSnake.START_SNAKE_SIZE));
            }

            if(gameSnake.food.isEaten()){
                gameSnake.food.appear();
            }
            gameSnake.canvas.repaint();
            sleep(gameSnake.SNAKE_DELAY);
        }
    }

    private void sleep(long ms) {    // method for suspending
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
