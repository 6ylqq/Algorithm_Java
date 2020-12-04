package SimpleFactoryPattern;

/**
 * @author ylqq
 */
public class Rectangle implements Shape {
    /**
     * 创建一个接口
     */
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method");
    }
}
