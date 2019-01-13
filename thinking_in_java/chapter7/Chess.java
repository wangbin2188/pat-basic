package thinking_in_java.chapter7;

/**
 * 子类创建对象时必须先创建父类的对象，如果父类没有无参构造方法，
 * 则必须在子类构造方法中用super(args)方法显式调用父类构造方法
 */
public class Chess extends BoardGame{
    public Chess() {
        super(1);
        System.out.println("Chess constructor");
    }

    public static void main(String[] args) {
        Chess chess = new Chess();
    }
}

class Game {
    public Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {
    public BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}

