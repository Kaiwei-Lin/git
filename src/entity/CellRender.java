package entity;

import javafx.concurrent.Task;
import javafx.scene.layout.Pane;

public class CellRender extends Pane {
    //ϸ���Ƿ���ţ�1Ϊ���ţ�0Ϊ����.
   private int isAlive;
    //ϸ�����ŵ�״̬.
   public static final  int ALIVE = 1;
   //ϸ��������״̬
   public  static  final int DIEDED = 0;
    public CellRender( int width, int hight,int isAlive) {
        this.isAlive = isAlive;
        this.setPrefSize(width,hight);
        paintComponent();
    }
    public int getIsAlive() {
        return isAlive;
    }
    public void setIsAlive(int isAlive)
    {
        this.isAlive = isAlive;
    }

    public void setCircleTime(int circleTime) {
    }

    /*
    ���ϼ�����ϸ��������״̬�������������ɫ�������ɫ
    
     */
    public  void  paintComponent(){
        Task<String> task =new Task<String> () {
            @Override
            protected String call() throws Exception {
                while (isAlive < 5) {
                    if (isAlive == DIEDED){
                        //ϸ������
                    this.updateValue("-fx-background-color: white;");
                    }else{
                        //ϸ������
                        this.updateValue("-fx-background-color:green;");
                    }
                    //ÿ��100�����ж�һ��
                    Thread.sleep(100);
                }
                return null;
            }
        };
        //����ʽ
        this.styleProperty().bind(task.valueProperty());
        //�����߳�����
        new Thread(task).start();
}
    }

