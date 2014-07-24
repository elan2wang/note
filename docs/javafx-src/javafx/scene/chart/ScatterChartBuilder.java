/* 
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package javafx.scene.chart;

/**
Builder class for javafx.scene.chart.ScatterChart
@see javafx.scene.chart.ScatterChart
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class ScatterChartBuilder<X, Y, B extends javafx.scene.chart.ScatterChartBuilder<X, Y, B>> extends javafx.scene.chart.XYChartBuilder<X, Y, B> {
    protected ScatterChartBuilder() {
    }
    
    /** Creates a new instance of ScatterChartBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static <X, Y> javafx.scene.chart.ScatterChartBuilder<X, Y, ?> create() {
        return new javafx.scene.chart.ScatterChartBuilder();
    }
    
    private javafx.scene.chart.Axis<X> XAxis;
    /**
    Set the value of the {@link javafx.scene.chart.ScatterChart#getXAxis() XAxis} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B XAxis(javafx.scene.chart.Axis<X> x) {
        this.XAxis = x;
        return (B) this;
    }
    
    private javafx.scene.chart.Axis<Y> YAxis;
    /**
    Set the value of the {@link javafx.scene.chart.ScatterChart#getYAxis() YAxis} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B YAxis(javafx.scene.chart.Axis<Y> x) {
        this.YAxis = x;
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.scene.chart.ScatterChart} based on the properties set on this builder.
    */
    public javafx.scene.chart.ScatterChart<X, Y> build() {
        javafx.scene.chart.ScatterChart<X, Y> x = new javafx.scene.chart.ScatterChart<X, Y>(this.XAxis, this.YAxis);
        applyTo(x);
        return x;
    }
}
