package emp.model;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.PieChartModel;



public class ProjectReport {
	//charts
		private BarChartModel barModel;
	    private HorizontalBarChartModel horizontalBarModel;
	    private LineChartModel multiAxisModel;
	    private LineChartModel dateModel;
	    private PieChartModel pieModel;
	    private BubbleChartModel bubbleModel;
	    private MeterGaugeChartModel meterGaugeModel;
	    
	    

	    
		public BarChartModel getBarModel() {
			return barModel;
		}




		public void setBarModel(BarChartModel barModel) {
			this.barModel = barModel;
		}




		public HorizontalBarChartModel getHorizontalBarModel() {
			return horizontalBarModel;
		}




		public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
			this.horizontalBarModel = horizontalBarModel;
		}




		public LineChartModel getMultiAxisModel() {
			return multiAxisModel;
		}




		public void setMultiAxisModel(LineChartModel multiAxisModel) {
			this.multiAxisModel = multiAxisModel;
		}




		public LineChartModel getDateModel() {
			return dateModel;
		}




		public void setDateModel(LineChartModel dateModel) {
			this.dateModel = dateModel;
		}




		public PieChartModel getPieModel() {
			return pieModel;
		}




		public void setPieModel(PieChartModel pieModel) {
			this.pieModel = pieModel;
		}




		


		public BubbleChartModel getBubbleModel() {
			return bubbleModel;
		}




		public void setBubbleModel(BubbleChartModel bubbleModel) {
			this.bubbleModel = bubbleModel;
		}




		public MeterGaugeChartModel getMeterGaugeModel() {
			return meterGaugeModel;
		}




		public void setMeterGaugeModel(MeterGaugeChartModel meterGaugeModel) {
			this.meterGaugeModel = meterGaugeModel;
		}




		@Override
		public String toString() {
			return "ProgressReport [barModel=" + barModel
					+ ", horizontalBarModel=" + horizontalBarModel
					+ ", multiAxisModel=" + multiAxisModel + ", dateModel="
					+ dateModel + ", pieModel=" + pieModel +  ", bubbleModel=" + bubbleModel
					+ ", meterGaugeModel=" + meterGaugeModel + "]";
		}





		public ProjectReport(BarChartModel barModel,
				HorizontalBarChartModel horizontalBarModel,
				LineChartModel multiAxisModel, LineChartModel dateModel,
				PieChartModel pieModel,
				BubbleChartModel bubbleModel,
				MeterGaugeChartModel meterGaugeModel) {
			super();
			this.barModel = barModel;
			this.horizontalBarModel = horizontalBarModel;
			this.multiAxisModel = multiAxisModel;
			this.dateModel = dateModel;
			this.pieModel = pieModel;
			this.bubbleModel = bubbleModel;
			this.meterGaugeModel = meterGaugeModel;
		}




		public ProjectReport() {
			super();
		}
	    
	    
}
