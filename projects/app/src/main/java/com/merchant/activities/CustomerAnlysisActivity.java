package com.merchant.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.UIUtil;
import com.merchant.utils.ViewParamsSetUtil;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.animation.ChartAnimationListener;
import lecho.lib.hellocharts.listener.LineChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * @name renwei
 * @time 2018/9/20 22:47
 * @class 顾客分析
 */
public class CustomerAnlysisActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout top_ll, title_ll;
    private LineChartView lineChartView, year_lineChartView, cj_lineChartView;

    private LineChartData data;
    private LineChartData yeardata;
    private int numberOfLines = 3;
    private int numberofLines_year = 1;
    private int maxNumberOfLines = 4;
    private int numberOfPoints = 8;

    float[][] randomNumbersTab = new float[maxNumberOfLines][numberOfPoints];

    private boolean hasAxes = true;
    private boolean hasAxesNames = false;
    private boolean hasLines = true;
    private boolean hasPoints = false;
    private ValueShape shape = ValueShape.CIRCLE;
    private boolean isFilled = false;
    private boolean hasLabels = false;
    private boolean isCubic = false;
    private boolean hasLabelForSelected = false;
    private boolean pointsHaveDifferentColor;
    private boolean hasGradientToTransparent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customeranalysis);
        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "顾客分析", this);
        UIUtil.setStautsBar(this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        top_ll = findViewById(R.id.top_ll);
        title_ll = findViewById(R.id.title_ll);
        ViewParamsSetUtil.setViewHight(top_ll, 0.28f, this);
        ViewParamsSetUtil.setViewHight(title_ll, 0.08f, this);

        lineChartView = findViewById(R.id.lineChartView);
        year_lineChartView = findViewById(R.id.year_lineChartView);
        cj_lineChartView = findViewById(R.id.cj_lineChartView);
        ViewParamsSetUtil.setViewHight(lineChartView, 0.3f, this);
        ViewParamsSetUtil.setViewHight(year_lineChartView, 0.3f, this);
        ViewParamsSetUtil.setViewHight(cj_lineChartView, 0.3f, this);

        setLineViewChart();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case HeaderViewControler.ID://返回
                finish();
                overTransition(1);
                break;
            default:
                break;
        }
    }

    public void setLineViewChart() {
        lineChartView.setOnValueTouchListener(new ValueTouchListener());
        year_lineChartView.setOnValueTouchListener(new ValueTouchListener());

        generateValues();

        generateData();

        lineChartView.setViewportCalculationEnabled(false);
        year_lineChartView.setViewportCalculationEnabled(false);
        resetViewport();

    }


    private void generateValues() {
        for (int i = 0; i < maxNumberOfLines; ++i) {
            for (int j = 0; j < numberOfPoints; ++j) {
                randomNumbersTab[i][j] = (float) Math.random() * 40f;
            }
        }
    }

    private void reset() {
        numberOfLines = 1;

        hasAxes = true;
        hasAxesNames = true;
        hasLines = true;
        hasPoints = true;
        shape = ValueShape.CIRCLE;
        isFilled = false;
        hasLabels = false;
        isCubic = false;
        hasLabelForSelected = false;
        pointsHaveDifferentColor = false;

        lineChartView.setValueSelectionEnabled(hasLabelForSelected);
        year_lineChartView.setValueSelectionEnabled(hasLabelForSelected);
        resetViewport();
    }

    private void resetViewport() {
        // Reset viewport height range to (0,100)
        final Viewport v = new Viewport(lineChartView.getMaximumViewport());
        v.bottom = 0;
        v.top = 45;
        v.left = 0;
        v.right = numberOfPoints - 1;
        lineChartView.setMaximumViewport(v);
        lineChartView.setCurrentViewport(v);

        final Viewport vyear = new Viewport(year_lineChartView.getMaximumViewport());
        vyear.bottom = 0;
        vyear.top = 45;
        vyear.left = 0;
        vyear.right = numberOfPoints - 1;
        year_lineChartView.setMaximumViewport(v);
        year_lineChartView.setCurrentViewport(v);

    }

    private void generateData() {

        List<Line> lines = new ArrayList<Line>();
        List<Line> yearlines = new ArrayList<Line>();
        for (int i = 0; i < numberOfLines; ++i) {

            List<PointValue> values = new ArrayList<PointValue>();
            for (int j = 0; j < numberOfPoints; ++j) {
                values.add(new PointValue(j, randomNumbersTab[i][j]));
            }

            Line line = new Line(values);
            line.setColor(ChartUtils.COLORS[i]);
            line.setShape(shape);
            line.setCubic(isCubic);
            line.setFilled(isFilled);
            line.setHasLabels(hasLabels);
            line.setHasLabelsOnlyForSelected(hasLabelForSelected);
            line.setHasLines(hasLines);
            line.setHasPoints(hasPoints);
            if (pointsHaveDifferentColor) {
                line.setPointColor(ChartUtils.COLORS[(i + 1) % ChartUtils.COLORS.length]);
            }
            lines.add(line);
        }

        for (int i = 0; i < numberofLines_year; ++i) {

            List<PointValue> values = new ArrayList<PointValue>();
            for (int j = 0; j < numberOfPoints; ++j) {
                values.add(new PointValue(j, randomNumbersTab[i][j]));
            }

            Line yearline = new Line(values);
            yearline.setColor(getResources().getColor(R.color.red_year));
            yearline.setShape(shape);
            yearline.setCubic(isCubic);
            yearline.setFilled(isFilled);
            yearline.setHasLabels(hasLabels);
            yearline.setHasLabelsOnlyForSelected(hasLabelForSelected);
            yearline.setHasLines(hasLines);
            yearline.setHasPoints(hasPoints);
            if (pointsHaveDifferentColor) {
                yearline.setPointColor(ChartUtils.COLORS[(i + 1) % ChartUtils.COLORS.length]);
            }
            yearlines.add(yearline);
        }

        data = new LineChartData(lines);
        yeardata = new LineChartData(yearlines);

        if (hasAxes) {
            Axis axisX = new Axis();
            Axis axisY = new Axis().setHasLines(true);
            if (hasAxesNames) {
                axisX.setName("Axis X");
                axisY.setName("Axis Y");
            }
            data.setAxisXBottom(axisX);
            data.setAxisYLeft(axisY);
            yeardata.setAxisXBottom(axisX);
            yeardata.setAxisYLeft(axisY);
        } else {
            data.setAxisXBottom(null);
            data.setAxisYLeft(null);
            yeardata.setAxisXBottom(null);
            yeardata.setAxisYLeft(null);
        }

        data.setBaseValue(Float.NEGATIVE_INFINITY);
        yeardata.setBaseValue(Float.NEGATIVE_INFINITY);

        lineChartView.setLineChartData(data);
        year_lineChartView.setLineChartData(yeardata);

    }

    private void addLineToData() {
        if (data.getLines().size() >= maxNumberOfLines) {
            Toast.makeText(this, "Samples app uses max 4 lines!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            ++numberOfLines;
        }

        generateData();
    }

    private void toggleLines() {
        hasLines = !hasLines;

        generateData();
    }

    private void togglePoints() {
        hasPoints = !hasPoints;

        generateData();
    }

    private void toggleGradient() {
        hasGradientToTransparent = !hasGradientToTransparent;

        generateData();
    }

    private void toggleCubic() {
        isCubic = !isCubic;

        generateData();

        if (isCubic) {
            // It is good idea to manually set a little higher max viewport for cubic lines because sometimes line
            // go above or below max/min. To do that use Viewport.inest() method and pass negative value as dy
            // parameter or just set top and bottom values manually.
            // In this example I know that Y values are within (0,100) range so I set viewport height range manually
            // to (-5, 105).
            // To make this works during animations you should use Chart.setViewportCalculationEnabled(false) before
            // modifying viewport.
            // Remember to set viewport after you call setLineChartData().
            final Viewport v = new Viewport(lineChartView.getMaximumViewport());
            v.bottom = -5;
            v.top = 45;
            // You have to set max and current viewports separately.
            lineChartView.setMaximumViewport(v);
            // I changing current viewport with animation in this case.
            lineChartView.setCurrentViewportWithAnimation(v);

            final Viewport vyear = new Viewport(year_lineChartView.getMaximumViewport());
            vyear.bottom = -5;
            vyear.top = 45;
            // You have to set max and current viewports separately.
            year_lineChartView.setMaximumViewport(vyear);
            // I changing current viewport with animation in this case.
            year_lineChartView.setCurrentViewportWithAnimation(vyear);
        } else {
            // If not cubic restore viewport to (0,100) range.
            final Viewport v = new Viewport(lineChartView.getMaximumViewport());
            final Viewport vyear = new Viewport(year_lineChartView.getMaximumViewport());
            v.bottom = 0;
            v.top = 45;

            vyear.bottom = 0;
            vyear.top = 45;

            // You have to set max and current viewports separately.
            // In this case, if I want animation I have to set current viewport first and use animation listener.
            // Max viewport will be set in onAnimationFinished method.
            lineChartView.setViewportAnimationListener(new ChartAnimationListener() {

                @Override
                public void onAnimationStarted() {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onAnimationFinished() {
                    // Set max viewpirt and remove listener.
                    lineChartView.setMaximumViewport(v);
                    lineChartView.setViewportAnimationListener(null);

                }
            });
            // Set current viewpirt with animation;
            lineChartView.setCurrentViewportWithAnimation(v);

            year_lineChartView.setViewportAnimationListener(new ChartAnimationListener() {
                @Override
                public void onAnimationStarted() {

                }

                @Override
                public void onAnimationFinished() {
                    year_lineChartView.setMaximumViewport(vyear);
                    year_lineChartView.setViewportAnimationListener(null);
                }
            });
        }

    }

    private void toggleFilled() {
        isFilled = !isFilled;

        generateData();
    }

    private void togglePointColor() {
        pointsHaveDifferentColor = !pointsHaveDifferentColor;

        generateData();
    }

    private void setCircles() {
        shape = ValueShape.CIRCLE;

        generateData();
    }

    private void setSquares() {
        shape = ValueShape.SQUARE;

        generateData();
    }

    private void setDiamonds() {
        shape = ValueShape.DIAMOND;

        generateData();
    }

    private void toggleLabels() {
        hasLabels = !hasLabels;

        if (hasLabels) {
            hasLabelForSelected = false;
            lineChartView.setValueSelectionEnabled(hasLabelForSelected);
            year_lineChartView.setValueSelectionEnabled(hasLabelForSelected);
        }

        generateData();
    }

    private void toggleLabelForSelected() {
        hasLabelForSelected = !hasLabelForSelected;

        lineChartView.setValueSelectionEnabled(hasLabelForSelected);
        year_lineChartView.setValueSelectionEnabled(hasLabelForSelected);

        if (hasLabelForSelected) {
            hasLabels = false;
        }

        generateData();
    }

    private void toggleAxes() {
        hasAxes = !hasAxes;

        generateData();
    }

    private void toggleAxesNames() {
        hasAxesNames = !hasAxesNames;

        generateData();
    }

    private void prepareDataAnimation() {
        for (Line line : data.getLines()) {
            for (PointValue value : line.getValues()) {
                // Here I modify target only for Y values but it is OK to modify X targets as well.
                value.setTarget(value.getX(), (float) Math.random() * 40);
            }
        }
    }

    private class ValueTouchListener implements LineChartOnValueSelectListener {

        @Override
        public void onValueSelected(int lineIndex, int pointIndex, PointValue value) {
        }

        @Override
        public void onValueDeselected() {
        }

    }
}
