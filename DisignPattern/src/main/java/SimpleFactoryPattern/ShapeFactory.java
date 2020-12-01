package SimpleFactoryPattern;

/**
 * 实现一个工厂，通过给定信息的实体类生成指定对象
 * @author ylqq
 */
public class ShapeFactory {
    public Shape getShape(String shapeType){
        if("CIRCLE".equalsIgnoreCase(shapeType)){
            return new Circle();
        }else if("RECTANGLE".equalsIgnoreCase(shapeType)){
            return new Rectangle();
        }else if("SQUARE".equalsIgnoreCase(shapeType)){
            return new Square();
        }
        return null;
    }
}
