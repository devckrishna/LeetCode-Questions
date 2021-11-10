public class First {
  int big;
  int medium;
  int small;

  public First(int big, int medium, int small) {
    this.big = big;
    this.medium = medium;
    this.small = small;
  }

  public boolean addCar(int carType) {
    if (carType == 1) {
      if (--big >= 0) {
        return true;
      } else {
        return false;
      }
    } else if (carType == 2) {
      if (--medium >= 0) {
        return true;
      } else {
        return false;
      }
    } else {
      if (--small >= 0) {
        return true;
      } else {
        return false;
      }
    }
  }
}