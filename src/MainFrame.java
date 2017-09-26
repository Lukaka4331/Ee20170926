import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame{
    private Button btn1=new Button("Add");
    private Button btn2=new Button("Exit");
    private Button btn3=new Button("Sub");
    private Label lab1=new Label("50,50");
    private int count=0,labX=50,labY=50,vX=0;
    private Timer t1;
    private boolean  flag=true;
    public MainFrame(){
        initComp();
    }
    private void initComp(){

        this.setBounds(800,300,800,800);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        btn1.setBounds(110,100,50,30);
        btn2.setBounds(170,100,50,30);
        btn3.setBounds(230,100,50,30);
        lab1.setBounds(50,50,50,30);
        lab1.setBackground(new Color(200, 200, 200));
        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.add(lab1);
        this.setLayout(null);
        vX=this.getWidth();

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //   count++;
                MainFrame.this.setTitle(Integer.toString(++count));

                t1.start();
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //   count++;
                MainFrame.this.setTitle(Integer.toString(--count));


            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

        t1=new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(labX<vX&&flag){

                    labX+=5;

                    int i=160;
                    int j=160;
                    int f=150;
                    i-=10;
                    j-=30;
                    f-=10;
                    lab1.setBackground(new Color(i,j,f));
                 if(labX==vX) {
                   flag=false;
                 }lab1.setLocation(labX,labY);
                }else{
                    labX-=5;
                    if(labX==0){
                        flag=true;
                    }lab1.setLocation(labX,labY);
                    int i=160;
                    int j=160;
                    int f=150;
                    i-=10;
                    j-=30;
                    f-=10;
                    lab1.setBackground(new Color(i,j,f));
                }
         lab1.setText(lab1.getX()+","+lab1.getY());







            }
        });

    }
}
