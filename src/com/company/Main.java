package com.company;

import com.company.Interfaces.GameI;
import com.company.datastructure.Color;
import com.company.datastructure.Location;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();
        Agents agentX = new Agents(Color.AGENTX.getValue());
        Agents agentY = new Agents(Color.AGENTY.getValue());
        Agents agentZ = new Agents(Color.AGENTZ.getValue());

        board.SetAgentOnBoard(agentX);
        board.SetAgentOnBoard(agentY);
        board.SetAgentOnBoard(agentZ);

       // board.WriteBoard();
        ArrayList<Agents> agents =new ArrayList<>();
        agents.add(agentX);
        agents.add(agentY);
        agents.add(agentZ);



        GameI gameIAgentKnowEachOther = new Game();
        System.out.println("START GAME FOR AGENTS (THEY KNOW EACH OTHER)");
        gameIAgentKnowEachOther.startGame(agents);



        //HOCAM PROJE AJANLARIN BİRBİRLERİNİ TANIMADIĞI SENARYOYU YORUMA ALDIK
        //UZUN SÜRDÜĞÜ İÇİN BU HALİYLE İLK KISIM CIKTI VERİCEK
        //COMMENT'İ KALDIRARSANIZ İKİ OUTPUTU'DA GÖREBİLİRSİNİZ.

        Board boardSecond = new Board();
        Agents agentX1 = new Agents(Color.AGENTX.getValue());
        Agents agentY1 = new Agents(Color.AGENTY.getValue());
        Agents agentZ1 = new Agents(Color.AGENTZ.getValue());

        boardSecond.SetAgentOnBoard(agentX1);
        boardSecond.SetAgentOnBoard(agentY1);
        boardSecond.SetAgentOnBoard(agentZ1);


        ArrayList<Agents> agentsSecond =new ArrayList<>();
        agentsSecond.add(agentX1);
        agentsSecond.add(agentY1);
        agentsSecond.add(agentZ1);

        System.out.println("START GAME FOR AGENTS (THEY DON'T KNOW EACH OTHER)");
        GameI gameI =new GameUnknow();
       // gameI.startGame(agentsSecond);

            }

}
