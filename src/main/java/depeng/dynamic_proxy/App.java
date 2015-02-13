package depeng.dynamic_proxy;

public class App {

    public static void main(String[] args) {

        // InvocationHandler
        // public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

        BookFacadeProxy bookFacadeProxy = new BookFacadeProxy();
        Object bind = bookFacadeProxy.bind(new BookFacadeImpl());
        BookFacade bookFacade = (BookFacade) bind;
        bookFacade.addBook();

        
        
        // - 如果没有实现接口，就无法动态代理
        // - cglib是针对类来实现代理的， 但是不能dai
        // - PowerMock 使用特殊的ClassLoader来修改字节码来代理final，但是生产环境不应该这样用
        
    }
}
