package webtech.foodspotsapp.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Foodspot {

  @Id @GeneratedValue private Long id;
  private String name;

  //  private String address;
  //  private String review;
  //  private String rating;

  // Getter & Setter
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  //  public String getAddress() {
  //    return address;
  //  }
  //
  //  public void setAddress(String address) {
  //    this.address = address;
  //  }
  //
  //  public String getReview() {
  //    return review;
  //  }
  //
  //  public void setReview(String review) {
  //    this.review = review;
  //  }
  //
  //  public String getRating() {
  //    return rating;
  //  }
  //
  //  public void setRating(String rating) {
  //    this.rating = rating;
  //  }
}
