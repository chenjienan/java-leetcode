package ood.hotel2;

import java.util.*;

class ReservationRequest {
	private Date startDate;
	private Date endDate;
	private Map<RoomType, Integer> roomsNeeded;
	
	public ReservationRequest(Date startDate, Date endDate, Map<RoomType, Integer> roomsNeeded) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.roomsNeeded = roomsNeeded;
	}
	
	public Date getStartDate()
	{
		return startDate;
	}
	
	public Date getEndDate()
	{
		return endDate;
	}
	
	public Map<RoomType, Integer> getRoomsNeeded()
	{
		return roomsNeeded;
	}
}