package com.company.datastructure;

public class StepAndLocation {
  private Integer step;
  private Location location;

  public StepAndLocation(Integer step, Location location) {
    this.step = step;
    this.location = location;
  }

  public StepAndLocation(Location location) {
    this.location = location;
  }

  public Integer getStep() {
    return step;
  }

  public void setStep(Integer step) {
    this.step = step;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }
}
