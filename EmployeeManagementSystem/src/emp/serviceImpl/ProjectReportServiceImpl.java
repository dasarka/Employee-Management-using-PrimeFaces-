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
		return new ProjectReport(createBarModel(), createHorizontalBarModel(),
				createMultiAxisModel(), createDateModel(),
				createPieModel(projectId),
				createBubbleModel(), createMeterGaugeModel(projectId));

	}

	private BarChartModel createBarModel() {
		BarChartModel barModel = initBarModel();

		barModel.setTitle("Bar Chart");
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Gender");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Births");
		yAxis.setMin(0);
		yAxis.setMax(200);
		return barModel;
	}

	// bar chart
	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Boys");
		boys.set("2004", 120);
		boys.set("2005", 100);
		boys.set("2006", 44);
		boys.set("2007", 150);
		boys.set("2008", 25);

		ChartSeries girls = new ChartSeries();
		girls.setLabel("Girls");
		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 110);
		girls.set("2007", 135);
		girls.set("2008", 120);

		model.addSeries(boys);
		model.addSeries(girls);

		return model;
	}

	// horizontal bar
	private HorizontalBarChartModel createHorizontalBarModel() {
		HorizontalBarChartModel horizontalBarModel = new HorizontalBarChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Boys");
		boys.set("2004", 50);
		boys.set("2005", 96);
		boys.set("2006", 44);
		boys.set("2007", 55);
		boys.set("2008", 25);

		ChartSeries girls = new ChartSeries();
		girls.setLabel("Girls");
		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 82);
		girls.set("2007", 35);
		girls.set("2008", 120);

		horizontalBarModel.addSeries(boys);
		horizontalBarModel.addSeries(girls);

		horizontalBarModel.setTitle("Horizontal and Stacked");
		horizontalBarModel.setLegendPosition("e");
		horizontalBarModel.setStacked(true);

		Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
		xAxis.setLabel("Births");
		xAxis.setMin(0);
		xAxis.setMax(200);

		Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
		yAxis.setLabel("Gender");
		return horizontalBarModel;
	}

	// multiaxis chart
	private LineChartModel createMultiAxisModel() {
		LineChartModel multiAxisModel = new LineChartModel();

		BarChartSeries boys = new BarChartSeries();
		boys.setLabel("Boys");

		boys.set("2004", 120);
		boys.set("2005", 100);
		boys.set("2006", 44);
		boys.set("2007", 150);
		boys.set("2008", 25);

		LineChartSeries girls = new LineChartSeries();
		girls.setLabel("Girls");
		girls.setXaxis(AxisType.X2);
		girls.setYaxis(AxisType.Y2);

		girls.set("A", 52);
		girls.set("B", 60);
		girls.set("C", 110);
		girls.set("D", 135);
		girls.set("E", 120);

		multiAxisModel.addSeries(boys);
		multiAxisModel.addSeries(girls);

		multiAxisModel.setTitle("Multi Axis Chart");
		multiAxisModel.setMouseoverHighlight(false);

		multiAxisModel.getAxes().put(AxisType.X, new CategoryAxis("Years"));
		multiAxisModel.getAxes().put(AxisType.X2, new CategoryAxis("Period"));

		Axis yAxis = multiAxisModel.getAxis(AxisType.Y);
		yAxis.setLabel("Birth");
		yAxis.setMin(0);
		yAxis.setMax(200);

		Axis y2Axis = new LinearAxis("Number");
		y2Axis.setMin(0);
		y2Axis.setMax(200);

		multiAxisModel.getAxes().put(AxisType.Y2, y2Axis);
		return multiAxisModel;
	}

	// date chart
	private LineChartModel createDateModel() {
		LineChartModel dateModel = new LineChartModel();
		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Series 1");

		series1.set("2014-01-01", 51);
		series1.set("2014-01-06", 22);
		series1.set("2014-01-12", 65);
		series1.set("2014-01-18", 74);
		series1.set("2014-01-24", 24);
		series1.set("2014-01-30", 51);

		LineChartSeries series2 = new LineChartSeries();
		series2.setLabel("Series 2");

		series2.set("2014-01-01", 32);
		series2.set("2014-01-06", 73);
		series2.set("2014-01-12", 24);
		series2.set("2014-01-18", 12);
		series2.set("2014-01-24", 74);
		series2.set("2014-01-30", 62);

		dateModel.addSeries(series1);
		dateModel.addSeries(series2);

		dateModel.setTitle("Zoom for Details");
		dateModel.setZoom(true);
		dateModel.getAxis(AxisType.Y).setLabel("Values");
		DateAxis axis = new DateAxis("Dates");
		axis.setTickAngle(-50);
		axis.setMax("2014-02-01");
		axis.setTickFormat("%b %#d, %y");

		dateModel.getAxes().put(AxisType.X, axis);
		return dateModel;
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
		pieModel.setLegendPosition("e");
		return pieModel;
	}

	

	// bubble chart
	private BubbleChartModel createBubbleModel() {
		BubbleChartModel bubbleModel = initBubbleModel();
		bubbleModel.setTitle("Task List");
		bubbleModel.setShadow(false);
		bubbleModel.setBubbleGradients(true);
		bubbleModel.setBubbleAlpha(0.8);
		bubbleModel.getAxis(AxisType.X).setTickAngle(-50);
		Axis yAxis = bubbleModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(250);
		yAxis.setTickAngle(50);

		return bubbleModel;
	}

	private BubbleChartModel initBubbleModel() {
		BubbleChartModel model = new BubbleChartModel();

		model.add(new BubbleChartSeries("Acura", 70, 183, 55));
		model.add(new BubbleChartSeries("Alfa Romeo", 45, 92, 36));
		model.add(new BubbleChartSeries("AM General", 24, 104, 40));
		model.add(new BubbleChartSeries("Bugatti", 50, 123, 60));
		model.add(new BubbleChartSeries("BMW", 15, 89, 25));
		model.add(new BubbleChartSeries("Audi", 40, 180, 80));
		model.add(new BubbleChartSeries("Aston Martin", 70, 70, 48));

		return model;
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
		meterGaugeModel.setSeriesColors("cc6666,E7E658,93b75f,66cc66,");
		meterGaugeModel.setGaugeLabelPosition("bottom");
		meterGaugeModel.setShowTickLabels(false);
		meterGaugeModel.setLabelHeightAdjust(110);
		meterGaugeModel.setIntervalOuterRadius(100);

		return meterGaugeModel;
	}
}
