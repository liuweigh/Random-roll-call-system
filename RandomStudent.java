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
    //��ȡѧ��������������
    public  static void init(){
        try {
            InputStream in = RandomStudent.class.getClassLoader().getResourceAsStream("students.txt");
            InputStreamReader isr = new InputStreamReader(in,"utf-8");
            BufferedReader br = new BufferedReader(isr);// ������
            String s = null;
            while((s=br.readLine())!=null&&s.trim().length()>0){
                list.add(s);
            }
            i=1;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("��ʼ��ʧ�ܣ�");
        }
    }
   
    public static void main(String[] args) {
        init();
        System.out.println("----------����ϵͳ����������ӭʹ��----------");
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        while(true){
            if(list.size()==0){
                System.out.println("ѧ�������б��Ѿ�Ϊ���ˣ����롮R�����³�ʼ�����������������˳�ϵͳ��");
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
            System.out.println("===���յ�"+ i++ +"λ����ѧ����:  "+s+"  ===");
            System.out.println("�س��������鿴��һλ����ѧ��...(����ok�˳�ϵͳ)");
            String n = sc.nextLine();
            if("ok".equalsIgnoreCase(n)){
                break;
            }
        }
        System.out.println("----------����ϵͳ�ѹرգ�ллʹ��----------");
    }
}
