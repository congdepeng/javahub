package depeng.reflection;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * 值对象是和字典都是数据的集合，区别是值对象做为编译时确定的集合，在编码的时候能增加可读性减少错误
 * 而字典是运行期可变的动态的，增加了灵活性
 * Web框架通过“反射”作为值对象和字典之间的桥梁，达到了自动的Form参数的解析，灵活而又保持可读性
 * 
 * TODO: 
 * - 其他数据结构的支持
 * - List和Array的支持
 */
public class App {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        HashMap<Object, Object> requestMap = Maps.newHashMap();
        requestMap.put("sPrivate", "sPrivate from map");
        requestMap.put("sProtected", "sProtected from map");
        requestMap.put("sDefault", "sDefault from map");
        requestMap.put("sPublic", "sPublic from map");
        Object o = buildVoByClass(SearchVo.class, requestMap);
        if (o instanceof SearchVo) {
            SearchVo searchVo = (SearchVo) o;
            String s = searchVo.getsDefault();
            System.out.println("default:"+s);
            String s1 = searchVo.getsPrivate();
            System.out.println("private "+s1);
        }
    }


    static Object buildVoByClass(Class glass, Map map) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object vo = glass.newInstance();
        //只列表自己和父类的public属性
        Field[] fields = glass.getFields();
        for (Field field : fields) {
//            System.out.println("getFields: " + field);
        }

        System.out.println("===========================================");
        //只列出本类的定义的属性
        Field[] declaredFields = glass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
//            System.out.println("getDeclaredFields: " + declaredField);
        }


        System.out.println("===========================================");
        //Spring的MVC如果想要将request里面的参数提取出来放到VO，就可以用这个方法
        Method[] methods = glass.getMethods();
        for (Method method : methods) {
//            if (method.getName().startsWith("get")) {
//                Class<?> returnType = method.getReturnType();
//                System.out.println(method + "--> " + returnType.getName());
//            }

            if (method.getName().startsWith("set")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class<?> parameterType : parameterTypes) {
//                    System.out.println(method.getName() + "-->" + parameterType);
                    String name = method.getName().replace("set", "");
                    CaseFormat fromFormat = CaseFormat.UPPER_CAMEL;
                    CaseFormat toFormat = CaseFormat.LOWER_CAMEL;
                    String to = fromFormat.to(toFormat, name);
                    Object o = map.get(to);
                    Object invoke = method.invoke(vo, o);
                }

            }
        }

        return vo;
    }

}
