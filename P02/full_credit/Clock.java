public class Clock
{
	public Clock(int hours, int minutes, int seconds)
	{
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	@Override
	public String toString()
	{
		return hours + ":" + minutes + ":" + seconds;
	}
	private int hours;
	private int minutes;
	private int seconds;
}
