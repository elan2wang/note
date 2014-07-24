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

package javafx.scene.control.cell;

/**
Builder class for javafx.scene.control.cell.CheckBoxListCell
@see javafx.scene.control.cell.CheckBoxListCell
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.2
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class CheckBoxListCellBuilder<T, B extends javafx.scene.control.cell.CheckBoxListCellBuilder<T, B>> extends javafx.scene.control.ListCellBuilder<T, B> {
    protected CheckBoxListCellBuilder() {
    }
    
    /** Creates a new instance of CheckBoxListCellBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static <T> javafx.scene.control.cell.CheckBoxListCellBuilder<T, ?> create() {
        return new javafx.scene.control.cell.CheckBoxListCellBuilder();
    }
    
    private int __set;
    public void applyTo(javafx.scene.control.cell.CheckBoxListCell<T> x) {
        super.applyTo(x);
        int set = __set;
        if ((set & (1 << 0)) != 0) x.setConverter(this.converter);
        if ((set & (1 << 1)) != 0) x.setSelectedStateCallback(this.selectedStateCallback);
    }
    
    private javafx.util.StringConverter<T> converter;
    /**
    Set the value of the {@link javafx.scene.control.cell.CheckBoxListCell#getConverter() converter} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B converter(javafx.util.StringConverter<T> x) {
        this.converter = x;
        __set |= 1 << 0;
        return (B) this;
    }
    
    private javafx.util.Callback<T,javafx.beans.value.ObservableValue<java.lang.Boolean>> selectedStateCallback;
    /**
    Set the value of the {@link javafx.scene.control.cell.CheckBoxListCell#getSelectedStateCallback() selectedStateCallback} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B selectedStateCallback(javafx.util.Callback<T,javafx.beans.value.ObservableValue<java.lang.Boolean>> x) {
        this.selectedStateCallback = x;
        __set |= 1 << 1;
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.scene.control.cell.CheckBoxListCell} based on the properties set on this builder.
    */
    public javafx.scene.control.cell.CheckBoxListCell<T> build() {
        javafx.scene.control.cell.CheckBoxListCell<T> x = new javafx.scene.control.cell.CheckBoxListCell<T>();
        applyTo(x);
        return x;
    }
}
