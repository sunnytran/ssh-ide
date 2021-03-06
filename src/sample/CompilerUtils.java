package sample;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

class CompilerUtils extends ClassLoader{

    public static final CompilerUtils C_UTILS = new CompilerUtils();

    //Helps print what comes out of the programs when ran/compiled
    private void printLines(String cmd, InputStream ins) throws Exception{
        String line = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(ins));
        while((line = in.readLine()) != null){
//            System.out.println(cmd+ " " + line);
        }
    }

    public void setLines(String command, OutputAreaController outArea) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);

        ArrayList<String> lines = new ArrayList<String>();

        String line = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(pro.getInputStream()));
        while((line = in.readLine()) != null){
            lines.add(line);
        }

        line = null;
        in = new BufferedReader(new InputStreamReader(pro.getErrorStream()));
        while((line = in.readLine()) != null){
            lines.add(line);
        }

        pro.waitFor();

        outArea.setOutput(lines);
    }

    //Runs the commands needed to compile/run
    public void runProcess(String command) throws Exception{
        Process pro = Runtime.getRuntime().exec(command);

//        Class<?> cls = Class.forName("");
//        System.out.println("Class Name: " + cls.getName());
//        System.out.println("Package Name: " + cls.getPackage());
//        Method[] methods = cls.getDeclaredMethods();
//        for(Method method : methods)  {
//            System.out.println(method.getName());
//        }
//        printLines("stdout:",pro.getInputStream());
//        printLines("stderr:", pro.getErrorStream());
        pro.waitFor();
//        System.out.println("exitValue() " + pro.exitValue());
    }

}
