package io.github.ronvohra.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Home extends PanacheEntityBase {
  public String url;
  public String streetAddress;
  public String nearestStation;
  public String directCentralStation;
  public String notes;
  public Integer walkTimeToStation;
  public Integer timeToCentral;
  public Integer numBedrooms;
  public Integer numBathrooms;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
}
