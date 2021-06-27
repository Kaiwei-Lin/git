package entity;

import javafx.concurrent.Task;
import javafx.scene.layout.Pane;

public class CellRender extends Pane {
    //细胞是否活着，1为活着，0为死亡.
   private int isAlive;
    //细胞活着的状态.
   public static final  int ALIVE = 1;
   //细胞死亡的状态
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
    不断监听该细胞的生死状态，如果生，则绿色，死则白色
    
     */
    public  void  paintComponent(){
        Task<String> task =new Task<String> () {
            @Override
            protected String call() throws Exception {
                while (isAlive < 5) {
                    if (isAlive == DIEDED){
                        //细胞死亡
                    this.updateValue("-fx-background-color: white;");
                    }else{
                        //细胞活着
                        this.updateValue("-fx-background-color:green;");
                    }
                    //每隔100毫秒判定一次
                    Thread.sleep(100);
                }
                return null;
            }
        };
        //绑定样式
        this.styleProperty().bind(task.valueProperty());
        //任务线程启动
        new Thread(task).start();
}
    }

