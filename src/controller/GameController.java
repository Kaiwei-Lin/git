package controller;

import entity.CellRender;
import service.GameService;

/*
游戏控制器

 */

public class GameController {
  GameService gameService = new GameService();
  /*
   cellRenders：所有的细胞的二维数组
   row ：第row行
   col ：第col列
       返回细胞活着（true），死亡（false）
   
   */
  public  boolean isAliveControl(CellRender[][] cellRenders,int row,int col){
      return  gameService.isAlive(cellRenders,row,col);
  }

}

