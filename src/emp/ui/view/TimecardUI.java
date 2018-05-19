package emp.ui.view;

public class TimecardUI {
	private boolean disableTimeCard=false;
private String selectedMonth;
private String selectedYear;
	
	public boolean isDisableTimeCard() {
		return disableTimeCard;
	}

	public void setDisableTimeCard(boolean disableTimeCard) {
		this.disableTimeCard = disableTimeCard;
	}

	public String getSelectedMonth() {
		return selectedMonth;
	}

	public void setSelectedMonth(String selectedMonth) {
		this.selectedMonth = selectedMonth;
	}

	public String getSelectedYear() {
		return selectedYear;
	}

	public void setSelectedYear(String selectedYear) {
		this.selectedYear = selectedYear;
	}

	@Override
	public String toString() {
		return "TimecardUI [disableTimeCard=" + disableTimeCard
				+ ", selectedMonth=" + selectedMonth + ", selectedYear="
				+ selectedYear + "]";
	}

	
}
