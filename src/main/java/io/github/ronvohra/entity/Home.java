package io.github.ronvohra.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Home extends PanacheEntityBase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;

  public String url;
  public Integer rent;
  public String streetAddress;
  public String nearestStation;
  public String directCentralStation;
  public String notes;
  public Integer walkTimeToStation;
  public Integer timeToCentral;
  public Integer numBedrooms;
  public Integer numBathrooms;
}
