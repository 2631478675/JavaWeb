package javaweb.ioc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class MeReflect {
    List<Object> objects;

    public MeReflect(){
        objects = new ArrayList<Object>();
    }
    // 在这里其实最好的做法是先找出带有注解的类，判断带有@LikeService注解再传入。但是为了方便直接省略了
    public  void get_ref(Object object) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz =object.getClass();
        if(clazz.isAnnotationPresent(LikeService.class)){  //判断是否带有@LikeService注解
            Field[] fields =clazz.getDeclaredFields();  //获取其变量
            for(Field field :fields){
                if(field.isAnnotationPresent(LikeAutowired.class)){  //判断是否需要注入
                    Class<?> rainClass=Class.forName(field.getType().getName(),false,Thread.currentThread().getContextClassLoader());   // 这里先将Rain类加载
                    field.set(object,rainClass.newInstance()); //赋给rain
                    objects.add(object);   //最后将已将赋值后的Weather保存进容器
                }
            }
        }
    }

    public List<Object> returnList(){
        return objects;  //返回容器方便以后使用
    }
}
