package webadv.s99201105.p02;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;

/**
 * Hello world!
 */
public class App {
    private static String user;
    private static String pass;

    public static void main(String[] args)throws IOException {
        if (args.length < 2) {
            System.err.println("Please provide an input!");
            System.exit(0);
        }
        new App().read();
        String u = args[0];
        String p = sha256hex(args[1]);
        if(u.equals(user)&&p.equals(pass)){
            System.out.println("登录成功");
            return;
        }
        System.out.println("登录失败");
    }

    private void read()throws IOException {
        File file=new File("C:\\Users\\FIRE\\IdeaProjects\\p02\\src\\main\\java\\webadv\\s99201105\\p02\\pass.txt");
        if(!file.exists()){
            return;
        }
        FileInputStream inputStream=new FileInputStream(file);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        user=bufferedReader.readLine();
        pass=bufferedReader.readLine();
    }



    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }

}
