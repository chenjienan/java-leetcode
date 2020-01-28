package ood.hotel;

import java.util.*;

class Reservation {
	private final Date startDate;
	private final Date endDate;
	private final List<Room> rooms;
	
	public Reservation(final Date startDate, final Date endDate)
	{
		this.startDate = startDate;
		this.endDate = endDate;
		rooms = new ArrayList<>();
	}
	
	public Date getStartDate()
	{
		return startDate;
	}
	
	public Date getEndDate()
	{
		return endDate;
	}
	
	public List<Room> getRooms()
	{
		return rooms;
	}

	@Override
	public String toString() {
		String res = "Start date is: " + startDate + ", End date is: " + endDate
			+ ", rooms are: ";
		
		for(final Room room : rooms)
		{
			res += room.getId() + "; ";
		}
		res += ". ";
		
		return res;
	}
}