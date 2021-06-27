package view;

import controller.GameController;
import entity.CellRender;
import javafx.concurrent.Task;

import java.security.SecureRandom;
import java.util.Random;
import javafx.scene.layout.GridPane;

/*
 
��Ϸ��ͼ
 */
public class GameView extends GridPane {
    /**���Ĵ�С*/
    private static final int WIDTH = 800;
    private  static  final  int HIGHT = 800;
    /**ϸ����ά���ֵ��к�����*/
    private  static  final  int ROW =100;
    private  static  final  int COL= 100;
    /**ÿ��ϸ���Ŀ�͸�*/
    int cellWith = WIDTH /ROW;
    int cellhight = HIGHT /COL;
    /**��Ϸ�Ŀ�����*/
    private GameController gameController = null;
    public  static  final  int DEFAULT_CIRCLETIME = 100;
    /**ϸ������*/
    private int circleTime = DEFAULT_CIRCLETIME;
    /**ϸ���Ķ�ά����*/
    private  static CellRender[][] cellRenders = new CellRender[ROW][COL];
    public GameView() {
        //���ô�С
        this.setPrefSize(WIDTH, HIGHT);
        this.gameController = new GameController();
        //ϸ������ĳ�ʼ��
       init();

    }
 /*
 ϸ��������

 */
    public void grow() {
        for (int i = 0; i< cellRenders.length;i ++ ){
            for (int j = 0; j < cellRenders[0].length; j++) {
                //ϸ�������߳̿�ʼ����
                new Thread(new CellTask(i,j)).start();
            }
        }
    }
  /*   ��ʼ�����棬����ϸ���������״̬
  
   */
    private void init() {
      SecureRandom random = new SecureRandom();
        for (int i = 0; i< ROW;i ++ ){
            for (int j = 0; j < COL; j++) {
                //ʹ���������������ϸ����״̬
                cellRenders[i][j]=new CellRender(cellWith,cellhight,random.nextInt(3)==1?CellRender.ALIVE:CellRender.DIEDED);
                //��ϸ����ӵ������
                this.add(cellRenders[i][j],j,i);
            }
        }
    }
    /*
     ����ѭ���ж�ϸ�Ƿ�����������
    
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
                    //���� ϸ����״̬
                    cellRenders[row][col].setIsAlive(CellRender.ALIVE);
                }else{
                    //����ϸ����״̬
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

