package emp.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LinearAxis;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.PieChartModel;

import emp.dao.ProjectReportDao;
import emp.daoImpl.ProjectReportDaoImpl;
import emp.model.ProjectReport;
import emp.service.ProjectReportService;

public class ProjectReportServiceImpl implements ProjectReportService {

	@Override
	public ProjectReport CreateCharts(int projectId) throws Exception {
		return new ProjectReport(createHorizontalBarModel(projectId),
				createPieModel(projectId),
				 createMeterGaugeModel(projectId));

	}

		// horizontal bar
	private HorizontalBarChartModel createHorizontalBarModel(int projectId) throws Exception {
		ProjectReportDao projReportDao = new ProjectReportDaoImpl();
		HashMap<String, Integer> taskStatus = projReportDao
				.GetTaskStatus(projectId);
		
		HorizontalBarChartModel horizontalBarModel = new HorizontalBarChartModel();

		ChartSeries actualData = new ChartSeries();
		ChartSeries predictedData = new ChartSeries();
		actualData.setLabel("Actual");
		predictedData.setLabel("Predicted");
		for (String key : taskStatus.keySet()) {
			actualData.set(key, (taskStatus.get(key)*10));
			predictedData.set(key, 100);
		}

		horizontalBarModel.addSeries(actualData);
		horizontalBarModel.addSeries(predictedData);

		horizontalBarModel.setTitle("Individual Task Progress");
		horizontalBarModel.setSeriesColors("009432,fbc531");
		horizontalBarModel.setLegendPosition("e");
		horizontalBarModel.setStacked(true);

		Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
		xAxis.setLabel("Status(in %)");
		xAxis.setMin(0);
		xAxis.setTickCount(6);
		xAxis.setMax(100);

		Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
		yAxis.setLabel("Task Name");
		return horizontalBarModel;
	}

	

	
	// pie chart
	private PieChartModel createPieModel(int projectId) throws Exception {
		PieChartModel pieModel = new PieChartModel();

		ProjectReportDao projReportDao = new ProjectReportDaoImpl();
		HashMap<String, Integer> resourcesMap = projReportDao
				.GetResourcesMap(projectId);
		for (String keyVal : resourcesMap.keySet()) {
			if (!keyVal.equals("No Access")) {
				pieModel.set(keyVal, resourcesMap.get(keyVal));
			}
		}

		pieModel.setTitle("Resources List");
		pieModel.setSeriesColors("1abc9c,F79F1F,EE5A24,006266,0652DD,2ecc71,6F1E51,D980FA,009432");
		pieModel.setLegendPosition("e");
		return pieModel;
	}

	
	// meter gauge
	private MeterGaugeChartModel initMeterGaugeModel(int projectId)
			throws Exception {
		List<Number> intervals = new ArrayList<Number>() {
			{
				add(25);
				add(50);
				add(75);
				add(100);
			}
		};

		ProjectReportDao projReportDao = new ProjectReportDaoImpl();
		return new MeterGaugeChartModel(
				projReportDao.GetProgressStatus(projectId), intervals);
	}

	private MeterGaugeChartModel createMeterGaugeModel(int projectId)
			throws Exception {

		MeterGaugeChartModel meterGaugeModel = initMeterGaugeModel(projectId);
		meterGaugeModel.setTitle("Progress Status");
		meterGaugeModel.setSeriesColors("EA2027,FFC312,1289A7,009432");
		meterGaugeModel.setGaugeLabelPosition("bottom");
		meterGaugeModel.setShowTickLabels(false);
		meterGaugeModel.setLabelHeightAdjust(110);
		meterGaugeModel.setIntervalOuterRadius(100);

		return meterGaugeModel;
	}
}
