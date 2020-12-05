package io.github.ronvohra.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;

@Entity
public class Home extends PanacheEntity {
  public String streetAddress;
  public String nearestStation;
  public String directCentralStation;
  public String notes;
  public int walkTimeToStation;
  public int timeToCentral;
  public int numBedrooms;
  public int numBathrooms;
}
