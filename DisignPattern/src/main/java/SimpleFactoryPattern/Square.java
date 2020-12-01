package SimpleFactoryPattern;

/**
 * @author ylqq
 */
public class Square implements Shape{
    /**
     * 创建一个接口
     */
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
