package depeng.jvm;

import sun.misc.Launcher;
import sun.misc.URLClassPath;

public class DisplayClassLoaderByLauncherApp {
    public static void main(String[] args) {

        URLClassPath bootstrapClassPath = Launcher.getBootstrapClassPath();
        System.out.println(bootstrapClassPath);
        
        //第一个是Launcher$AppClassLoader
        Launcher launcher = Launcher.getLauncher();
        ClassLoader appClassLoader = launcher.getClassLoader();
        System.out.println(appClassLoader);

        //第二个是Launcher$ExtClassLoader
        ClassLoader extClassLoader = appClassLoader.getParent();
        System.out.println(extClassLoader);

        ClassLoader bootClass = extClassLoader.getParent();
        System.out.println(bootClass);// boot 是null ， 由c++实现


    }
}
