package com.company.datastructure;

import com.company.Agents;

public class AgentAndNearestFood {
  private Agents agents;
  private NearestFood nearestFood;

  public AgentAndNearestFood(Agents agents) {
    this.agents = agents;
  }

  public AgentAndNearestFood(Agents agents, NearestFood nearestFood) {
    this.agents = agents;
    this.nearestFood = nearestFood;
  }

  public Agents getAgents() {
    return agents;
  }

  public void setAgents(Agents agents) {
    this.agents = agents;
  }

  public NearestFood getNearestFood() {
    return nearestFood;
  }

  public void setNearestFood(NearestFood nearestFood) {
    this.nearestFood = nearestFood;
  }
}
