package service;

import entity.CellRender;
/*
 判断细胞是否死亡的业务逻辑
 */

public class GameService {
    /*
      cellRenders：所有的细胞的二维数组
      row ：第row行
      col ：第col列
      boolean：返回细胞活着（true），死亡（false）
     */
    public int CountisAlive(CellRender[][] cellRenders, int row, int col) {
        //统计某个细胞周围细胞的总数
        int count = 0;
       //左上
        count+= ((row==0||col==0)?0:cellRenders[row-1][col-1].getIsAlive());
       //上
        count+= (row==0?0:cellRenders[row-1][col].getIsAlive());
        //右上
        count+= ((row==0||col==cellRenders[0].length-1)?0:cellRenders[row-1][col+1].getIsAlive());
        //左
        count+= (col==0?0:cellRenders[row][col-1].getIsAlive());
        //右
        count+= (col==cellRenders[0].length-1?0:cellRenders[row][col+1].getIsAlive());
        //左下
        count+= ((row==cellRenders.length-1||col==0)?0:cellRenders[row+1][col-1].getIsAlive());
        //下
        count+= (row==cellRenders.length-1?0:cellRenders[row+1][col].getIsAlive());
        //右下
        count+= ((row==cellRenders.length-1|| col==cellRenders[0].length-1)?0:cellRenders[row+1][col+1].getIsAlive());
        
        return count;
       
    }
    
    public boolean isAlive(CellRender[][] cellRenders, int row, int col) {
      int count=CountisAlive(cellRenders,row,col);
      
      if (count == 3) {
        //1.如果细胞的周围有3活着的个细胞则该细胞活着。
        return true;
    }
      
    if (count == 2) {
       // 2.如果有两个活着的细胞，则该细胞的状态不变，原来死亡的还是死亡，活着的还是活着。
        return cellRenders[row][col].getIsAlive() == 1;
    }
    
    //3.其它情况下该细胞军事死亡。
    return false;
      
    }
}
