package controller;

import entity.CellRender;
import service.GameService;

/*
��Ϸ������

 */

public class GameController {
  GameService gameService = new GameService();
  /*
   cellRenders�����е�ϸ���Ķ�ά����
   row ����row��
   col ����col��
       ����ϸ�����ţ�true����������false��
   
   */
  public  boolean isAliveControl(CellRender[][] cellRenders,int row,int col){
      return  gameService.isAlive(cellRenders,row,col);
  }

}

