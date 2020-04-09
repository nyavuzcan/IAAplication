package com.company.datastructure;

public class NearestFood {
  private StepAndLocation stepAndLocation;
  private Location location;
  private Integer differenceNumber;
  private Integer redOrGreen;

  public NearestFood(StepAndLocation stepAndLocation,Integer differenceNumber) {
    this.location=stepAndLocation.getLocation();
    this.differenceNumber = differenceNumber;

  }

  public StepAndLocation getStepAndLocation() {
    return stepAndLocation;
  }

  public void setStepAndLocation(StepAndLocation stepAndLocation) {
    this.stepAndLocation = stepAndLocation;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Integer getDifferenceNumber() {
    return differenceNumber;
  }

  public void setDifferenceNumber(Integer differenceNumber) {
    this.differenceNumber = differenceNumber;
  }

  public Integer getRedOrGreen() {
    return redOrGreen;
  }

  public void setRedOrGreen(Integer redOrGreen) {
    this.redOrGreen = redOrGreen;
  }
}
