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
	    private HorizontalBarChartModel horizontalBarModel;
	    private PieChartModel pieModel;
	    private MeterGaugeChartModel meterGaugeModel;
	    

		public HorizontalBarChartModel getHorizontalBarModel() {
			return horizontalBarModel;
		}


		public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
			this.horizontalBarModel = horizontalBarModel;
		}



		public PieChartModel getPieModel() {
			return pieModel;
		}

		public void setPieModel(PieChartModel pieModel) {
			this.pieModel = pieModel;
		}

		public MeterGaugeChartModel getMeterGaugeModel() {
			return meterGaugeModel;
		}

		public void setMeterGaugeModel(MeterGaugeChartModel meterGaugeModel) {
			this.meterGaugeModel = meterGaugeModel;
		}




		@Override
		public String toString() {
			return "ProgressReport  horizontalBarModel=" + horizontalBarModel
					+ ", pieModel=" + pieModel 
					+ ", meterGaugeModel=" + meterGaugeModel + "]";
		}





		public ProjectReport(HorizontalBarChartModel horizontalBarModel,
				PieChartModel pieModel,
				MeterGaugeChartModel meterGaugeModel) {
			super();
			this.horizontalBarModel = horizontalBarModel;
			this.pieModel = pieModel;
			this.meterGaugeModel = meterGaugeModel;
		}




		public ProjectReport() {
			super();
		}
	    
	    
}
