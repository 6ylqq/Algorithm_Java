package SimpleFactoryPattern;

/**
 * @author ylqq
 */
public class Circle implements Shape{
    /**
     * 创建一个接口
     */
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
