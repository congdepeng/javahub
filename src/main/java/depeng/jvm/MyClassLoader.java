package depeng.jvm;

import java.io.*;
import java.util.HashSet;

class MyClassLoader extends ClassLoader {

    private String basedir; // 需要该类加载器直接加载的类文件的基目录
    private HashSet mustLoad; // 需要由该类加载器直接加载的类名

    public MyClassLoader(String basedir, String[] glasses) throws IOException {
        super(null); // 指定父类加载器为 null
        this.basedir = basedir;
        mustLoad = new HashSet();
        loadClassByMe(glasses);
    }

    private void loadClassByMe(String[] glass) throws IOException {
        for (int i = 0; i < glass.length; i++) {
            loadDirectly(glass[i]);
            mustLoad.add(glass[i]);
        }
    }

    private Class loadDirectly(String name) throws IOException {
        Class cls = null;
        StringBuilder sb = new StringBuilder(basedir);
        String classname = name.replace('.', File.separatorChar) + ".class";
        sb.append(File.separator + classname);
        File classF = new File(sb.toString());
        cls = instantiateClass(name, new FileInputStream(classF), classF.length());
        return cls;
    }

    private Class instantiateClass(String name, InputStream fin, long len) throws IOException {
        byte[] raw = new byte[(int) len];
        fin.read(raw);
        fin.close();
        return defineClass(name, raw, 0, raw.length);
    }

    protected Class loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        Class cls = null;
        cls = findLoadedClass(name);
        if (!this.mustLoad.contains(name) && cls == null)
            cls = getSystemClassLoader().loadClass(name);
        if (cls == null)
            throw new ClassNotFoundException(name);
        if (resolve)
            resolveClass(cls);
        return cls;
    }

}