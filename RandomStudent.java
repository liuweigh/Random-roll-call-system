import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class RandomStudent {
    private static List<String> list = new ArrayList<String>();
	private static int i=1;
    //读取学生姓名到集合中
    public  static void init(){
        try {
            InputStream in = RandomStudent.class.getClassLoader().getResourceAsStream("students.txt");
            InputStreamReader isr = new InputStreamReader(in,"utf-8");
            BufferedReader br = new BufferedReader(isr);// 缓冲流
            String s = null;
            while((s=br.readLine())!=null&&s.trim().length()>0){
                list.add(s);
            }
            i=1;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("初始化失败！");
        }
    }
   
    public static void main(String[] args) {
        init();
        System.out.println("----------点名系统已启动，欢迎使用----------");
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        while(true){
            if(list.size()==0){
                System.out.println("学生姓名列表已经为空了，输入‘R’重新初始化，输入其他内容退出系统！");
                String n = sc.nextLine();
                if("R".equalsIgnoreCase(n)){
                    init();
                    continue;
                }else {
                    break;
                }
            }
			Collections.shuffle(list);
            String s = list.remove(r.nextInt(list.size()));
            System.out.println("===今日第"+ i++ +"位幸运学生是:  "+s+"  ===");
            System.out.println("回车键继续查看下一位幸运学生...(输入ok退出系统)");
            String n = sc.nextLine();
            if("ok".equalsIgnoreCase(n)){
                break;
            }
        }
        System.out.println("----------点名系统已关闭，谢谢使用----------");
    }
}
