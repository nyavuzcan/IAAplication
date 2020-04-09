package com.company.datastructure;

public class EatValueAndLocation {
private Integer greenOrRed;
private Location location;

  public EatValueAndLocation(Integer greenOrRed, Location location) {
    this.greenOrRed = greenOrRed;
    this.location = location;
  }

  public Integer getGreenOrRed() {
    return greenOrRed;
  }

  public void setGreenOrRed(Integer greenOrRed) {
    this.greenOrRed = greenOrRed;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }
}

