package com.company;

import com.company.datastructure.Location;

public class Behavior {
  public boolean isLocationsEqual(Location locationFirst,Location locationSecond){
    if (locationFirst.getxIndis()==locationSecond.getxIndis() && locationFirst
    .getyIndis()==locationSecond.getyIndis()) return true;
    return false;
  }
}
