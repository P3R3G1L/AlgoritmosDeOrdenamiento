import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class GraficadorDeTiempo extends JFrame {

    public GraficadorDeTiempo(String title, String category, String valueLabel, long[] times, String[] algorithms) {
        super(title);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < times.length; i++) {
            dataset.addValue(times[i], "Execution Time", algorithms[i]);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                title, category, valueLabel, dataset);

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }
}
