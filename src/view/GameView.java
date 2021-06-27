package view;

import controller.GameController;
import entity.CellRender;
import javafx.concurrent.Task;

import java.security.SecureRandom;
import java.util.Random;
import javafx.scene.layout.GridPane;

/*
 
游戏视图
 */
public class GameView extends GridPane {
    /**面板的大小*/
    private static final int WIDTH = 800;
    private  static  final  int HIGHT = 800;
    /**细胞二维数字的行和列数*/
    private  static  final  int ROW =100;
    private  static  final  int COL= 100;
    /**每个细胞的宽和高*/
    int cellWith = WIDTH /ROW;
    int cellhight = HIGHT /COL;
    /**游戏的控制类*/
    private GameController gameController = null;
    public  static  final  int DEFAULT_CIRCLETIME = 100;
    /**细胞周期*/
    private int circleTime = DEFAULT_CIRCLETIME;
    /**细胞的二维数组*/
    private  static CellRender[][] cellRenders = new CellRender[ROW][COL];
    public GameView() {
        //设置大小
        this.setPrefSize(WIDTH, HIGHT);
        this.gameController = new GameController();
        //细胞界面的初始化
       init();

    }
 /*
 细胞送生长

 */
    public void grow() {
        for (int i = 0; i< cellRenders.length;i ++ ){
            for (int j = 0; j < cellRenders[0].length; j++) {
                //细胞任务线程开始启动
                new Thread(new CellTask(i,j)).start();
            }
        }
    }
  /*   初始化界面，并给细胞随机设置状态
  
   */
    private void init() {
      SecureRandom random = new SecureRandom();
        for (int i = 0; i< ROW;i ++ ){
            for (int j = 0; j < COL; j++) {
                //使用随机生成数生成细胞的状态
                cellRenders[i][j]=new CellRender(cellWith,cellhight,random.nextInt(3)==1?CellRender.ALIVE:CellRender.DIEDED);
                //将细胞添加到面板中
                this.add(cellRenders[i][j],j,i);
            }
        }
    }
    /*
     不断循环判断细是否死亡的任务
    
     */
    class CellTask extends  Task{
        int row;
        int col;
        public  CellTask(int row, int col){
            this.row =row;
            this.col = col;
        }
        @Override
        protected Object call() throws Exception {
            while (true){
                boolean isAlive = gameController.isAliveControl(cellRenders, row, col);
                if (isAlive) {
                    //设置 细胞的状态
                    cellRenders[row][col].setIsAlive(CellRender.ALIVE);
                }else{
                    //设置细胞的状态
                    cellRenders[row][col].setIsAlive(CellRender.DIEDED);
                }
                Thread.sleep(circleTime);
            }
        }
    }
    public void setCircleTime(int circleTime) {
        this.circleTime = circleTime;
    }
}

