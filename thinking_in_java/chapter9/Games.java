package thinking_in_java.chapter9;

/**
 * Created by wangbin10 on 2019/1/14.
 * 想要创建框架
 * 假如正在创建一个对弈游戏系统，在相同的棋盘上下国际象棋和西洋跳棋
 */
public class Games {
    public static void main(String[] args) {
        playGame(new CheckersFactory());
        playGame(new ChessFactory());
    }

    public static void playGame(GameFactory fact) {
        Game game = fact.getGame();
        while (game.move()) {
            ;
        }
    }
}

interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

class Checkers implements Game {
    private int moves=0;
    private static final int MOVES=3;
    @Override
    public boolean move() {
        System.out.println("checkers move");
        return ++moves!=MOVES;
    }
}

class CheckersFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Checkers();
    }
}

class Chess implements Game {
    private int moves=0;
    private static final int MOVES=4;
    @Override
    public boolean move() {
        System.out.println("chess move");
        return ++moves!=MOVES;
    }
}

class ChessFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Chess();
    }
}