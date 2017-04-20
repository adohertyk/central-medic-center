package modal;

import utils.DateUtils;

public class AppointmentItems {
	private long date;
	private int type;
	private String description;
	private int appointmentId;
	
	public AppointmentItems(long date, String description,int type, int appointmentId) {		 
		this.date = date;
		this.type =type;
		this.description = description;
		this.appointmentId = appointmentId;
	}

	public long getDate() {
		return date;
	}
	
	public String getStringDate() {
		return DateUtils.getDateTtimeSringFromDate(date);
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getAppointmentId() {
		return appointmentId;
	}
}
