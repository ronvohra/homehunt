package io.github.ronvohra.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Home extends PanacheEntityBase {
  public String streetAddress;
  public String nearestStation;
  public String directCentralStation;
  public String notes;
  public int walkTimeToStation;
  public int timeToCentral;
  public int numBedrooms;
  public int numBathrooms;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
}
