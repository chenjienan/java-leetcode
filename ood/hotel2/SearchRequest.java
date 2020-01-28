package ood.hotel2;

import java.util.*;

class SearchRequest {
	private Date startDate;
	private Date endDate;
	
	public SearchRequest(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Date getStartDate()
	{
		return startDate;
	}
	
	public Date getEndDate()
	{
		return endDate;
	}
	
	@Override
	public String toString() {
		String res = "Start date is: " + startDate + ", End date is: " + endDate;
		
		return res;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if(!(obj instanceof SearchRequest)) return false;
		
		SearchRequest request = (SearchRequest) obj;
		
		return request.startDate == this.startDate && request.endDate == this.endDate;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + startDate.hashCode();
		result = 31 * result + endDate.hashCode();
		return result;
	}
}