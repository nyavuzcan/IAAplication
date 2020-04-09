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

        GameI gameI =new Game();
        gameI.startGame(agents);

            }

}
