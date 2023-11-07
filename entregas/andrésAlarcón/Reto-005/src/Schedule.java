public class Schedule {
  private Time openingTime;
  private Time closingTime;
  private boolean isOpen;

  public Schedule(Time openingTime, Time closingTime) {
    this.openingTime = openingTime;
    this.closingTime = closingTime;
    this.isOpen = false;
  }

  public Time getOpeningTime() {
    return openingTime;
  }

  public Time getClosingTime() {
    return closingTime;
  }

  public boolean isOpen() {
    return isOpen;
  }

  public void setOpen(boolean isOpen) {
    this.isOpen = isOpen;
  }

  public boolean isWithinSchedule(Time time) {
    if (time.getHour() < openingTime.getHour() || time.getHour() > closingTime.getHour()) {
      return false;
    } else if (time.getHour() == openingTime.getHour() && time.getMinute() < openingTime.getMinute()) {
      return false;
    } else if (time.getHour() == closingTime.getHour() && time.getMinute() > closingTime.getMinute()) {
      return false;
    }
    return true;
  }
}
