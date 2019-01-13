package thinking_in_java.chapter7;

/**
 * 代理是介于继承和组合之间的中庸之道。
 * 我们将一个成员变量置于所要构造的类中，这像组合；
 * 但与此同时，我们在新类中暴露类该成员变量的所有方法，这像继承。
 */
public class SpaceShipDelegation {
    private String name;
    private SpaceShipControls controls=new SpaceShipControls();

    public SpaceShipDelegation(String name) {
        this.name = name;
    }

    public void up(int velocity) {
        controls.up(velocity);
    }

    public void down(int velocity) {
        controls.down(velocity);
    }

    public void left(int velocity) {
        controls.left(velocity);
    }

    public void right(int velocity) {
        controls.right(velocity);
    }

    public void forward(int velocity) {
        controls.forward(velocity);
    }

    public void back(int velocity) {
        controls.back(velocity);
    }

    public static void main(String[] args) {
        SpaceShipDelegation protector = new SpaceShipDelegation("protector");
        protector.forward(100);
    }
}
