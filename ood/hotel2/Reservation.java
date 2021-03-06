package ood.hotel2;

import java.util.*;

class Reservation {
	private Hotel hotel = null;
	private Date startDate;
	private Date endDate;
	private List<Room> rooms;
	
	public Reservation(Date startDate, Date endDate)
	{
		this.startDate = startDate;
		this.endDate = endDate;
		rooms = new ArrayList<>();
	}
	
	public void setHotel(Hotel hotel)
	{
		this.hotel = hotel;
	}
	
	public Hotel getHotel()
	{
		return hotel;
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
		String res = "Hotel is: " + hotel.getId() + ", start date is: " + startDate + ", End date is: " + endDate
			+ ", rooms are: ";
		
		for(Room room : rooms)
		{
			res += room.getId() + "; ";
		}
		res += ". ";
		
		return res;
	}
}