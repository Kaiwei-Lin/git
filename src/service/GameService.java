package service;

import entity.CellRender;
/*
 �ж�ϸ���Ƿ�������ҵ���߼�
 */

public class GameService {
    /*
      cellRenders�����е�ϸ���Ķ�ά����
      row ����row��
      col ����col��
      boolean������ϸ�����ţ�true����������false��
     */
    public int CountisAlive(CellRender[][] cellRenders, int row, int col) {
        //ͳ��ĳ��ϸ����Χϸ��������
        int count = 0;
       //����
        count+= ((row==0||col==0)?0:cellRenders[row-1][col-1].getIsAlive());
       //��
        count+= (row==0?0:cellRenders[row-1][col].getIsAlive());
        //����
        count+= ((row==0||col==cellRenders[0].length-1)?0:cellRenders[row-1][col+1].getIsAlive());
        //��
        count+= (col==0?0:cellRenders[row][col-1].getIsAlive());
        //��
        count+= (col==cellRenders[0].length-1?0:cellRenders[row][col+1].getIsAlive());
        //����
        count+= ((row==cellRenders.length-1||col==0)?0:cellRenders[row+1][col-1].getIsAlive());
        //��
        count+= (row==cellRenders.length-1?0:cellRenders[row+1][col].getIsAlive());
        //����
        count+= ((row==cellRenders.length-1|| col==cellRenders[0].length-1)?0:cellRenders[row+1][col+1].getIsAlive());
        
        return count;
       
    }
    
    public boolean isAlive(CellRender[][] cellRenders, int row, int col) {
      int count=CountisAlive(cellRenders,row,col);
      
      if (count == 3) {
        //1.���ϸ������Χ��3���ŵĸ�ϸ�����ϸ�����š�
        return true;
    }
      
    if (count == 2) {
       // 2.������������ŵ�ϸ�������ϸ����״̬���䣬ԭ�������Ļ������������ŵĻ��ǻ��š�
        return cellRenders[row][col].getIsAlive() == 1;
    }
    
    //3.��������¸�ϸ������������
    return false;
      
    }
}
