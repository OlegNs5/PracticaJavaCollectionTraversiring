package practice.lambda;

import java.util.Objects;

public class VideoGame {
   private String name;
   private double rating;
   private Platform platform;

   public VideoGame(String name, double rating, Platform platform) {
      this.name = name;
      this.rating = rating;
      this.platform = platform;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getRating() {
      return rating;
   }

   public void setRating(double rating) {
      this.rating = rating;
   }

   public Platform getPlatform() {
      return platform;
   }

   public void setPlatform(Platform platform) {
      this.platform = platform;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof VideoGame)) return false;
      VideoGame videoGame = (VideoGame) o;
      return Double.compare(videoGame.getRating(), getRating()) == 0 && getName().equals(videoGame.getName()) && getPlatform() == videoGame.getPlatform();
   }

   @Override
   public int hashCode() {
      return Objects.hash(getName(), getRating(), getPlatform());
   }

   @Override
   public String toString() {
      return "VideoGame{" +
              "name='" + name + '\'' +
              ", rating=" + rating +
              ", platform=" + platform +
              '}';
   }
}