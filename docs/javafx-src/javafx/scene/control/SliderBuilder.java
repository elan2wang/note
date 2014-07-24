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

package javafx.scene.control;

/**
Builder class for javafx.scene.control.Slider
@see javafx.scene.control.Slider
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class SliderBuilder<B extends javafx.scene.control.SliderBuilder<B>> extends javafx.scene.control.ControlBuilder<B> implements javafx.util.Builder<javafx.scene.control.Slider> {
    protected SliderBuilder() {
    }
    
    /** Creates a new instance of SliderBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.control.SliderBuilder<?> create() {
        return new javafx.scene.control.SliderBuilder();
    }
    
    private int __set;
    private void __set(int i) {
        __set |= 1 << i;
    }
    public void applyTo(javafx.scene.control.Slider x) {
        super.applyTo(x);
        int set = __set;
        while (set != 0) {
            int i = Integer.numberOfTrailingZeros(set);
            set &= ~(1 << i);
            switch (i) {
                case 0: x.setBlockIncrement(this.blockIncrement); break;
                case 1: x.setLabelFormatter(this.labelFormatter); break;
                case 2: x.setMajorTickUnit(this.majorTickUnit); break;
                case 3: x.setMax(this.max); break;
                case 4: x.setMin(this.min); break;
                case 5: x.setMinorTickCount(this.minorTickCount); break;
                case 6: x.setOrientation(this.orientation); break;
                case 7: x.setShowTickLabels(this.showTickLabels); break;
                case 8: x.setShowTickMarks(this.showTickMarks); break;
                case 9: x.setSnapToTicks(this.snapToTicks); break;
                case 10: x.setValue(this.value); break;
                case 11: x.setValueChanging(this.valueChanging); break;
            }
        }
    }
    
    private double blockIncrement;
    /**
    Set the value of the {@link javafx.scene.control.Slider#getBlockIncrement() blockIncrement} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B blockIncrement(double x) {
        this.blockIncrement = x;
        __set(0);
        return (B) this;
    }
    
    private javafx.util.StringConverter<java.lang.Double> labelFormatter;
    /**
    Set the value of the {@link javafx.scene.control.Slider#getLabelFormatter() labelFormatter} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B labelFormatter(javafx.util.StringConverter<java.lang.Double> x) {
        this.labelFormatter = x;
        __set(1);
        return (B) this;
    }
    
    private double majorTickUnit;
    /**
    Set the value of the {@link javafx.scene.control.Slider#getMajorTickUnit() majorTickUnit} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B majorTickUnit(double x) {
        this.majorTickUnit = x;
        __set(2);
        return (B) this;
    }
    
    private double max;
    /**
    Set the value of the {@link javafx.scene.control.Slider#getMax() max} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B max(double x) {
        this.max = x;
        __set(3);
        return (B) this;
    }
    
    private double min;
    /**
    Set the value of the {@link javafx.scene.control.Slider#getMin() min} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B min(double x) {
        this.min = x;
        __set(4);
        return (B) this;
    }
    
    private int minorTickCount;
    /**
    Set the value of the {@link javafx.scene.control.Slider#getMinorTickCount() minorTickCount} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B minorTickCount(int x) {
        this.minorTickCount = x;
        __set(5);
        return (B) this;
    }
    
    private javafx.geometry.Orientation orientation;
    /**
    Set the value of the {@link javafx.scene.control.Slider#getOrientation() orientation} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B orientation(javafx.geometry.Orientation x) {
        this.orientation = x;
        __set(6);
        return (B) this;
    }
    
    private boolean showTickLabels;
    /**
    Set the value of the {@link javafx.scene.control.Slider#isShowTickLabels() showTickLabels} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B showTickLabels(boolean x) {
        this.showTickLabels = x;
        __set(7);
        return (B) this;
    }
    
    private boolean showTickMarks;
    /**
    Set the value of the {@link javafx.scene.control.Slider#isShowTickMarks() showTickMarks} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B showTickMarks(boolean x) {
        this.showTickMarks = x;
        __set(8);
        return (B) this;
    }
    
    private boolean snapToTicks;
    /**
    Set the value of the {@link javafx.scene.control.Slider#isSnapToTicks() snapToTicks} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B snapToTicks(boolean x) {
        this.snapToTicks = x;
        __set(9);
        return (B) this;
    }
    
    private double value;
    /**
    Set the value of the {@link javafx.scene.control.Slider#getValue() value} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B value(double x) {
        this.value = x;
        __set(10);
        return (B) this;
    }
    
    private boolean valueChanging;
    /**
    Set the value of the {@link javafx.scene.control.Slider#isValueChanging() valueChanging} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B valueChanging(boolean x) {
        this.valueChanging = x;
        __set(11);
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.scene.control.Slider} based on the properties set on this builder.
    */
    public javafx.scene.control.Slider build() {
        javafx.scene.control.Slider x = new javafx.scene.control.Slider();
        applyTo(x);
        return x;
    }
}
