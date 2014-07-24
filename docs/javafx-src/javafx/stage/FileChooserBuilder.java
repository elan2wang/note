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

package javafx.stage;

/**
Builder class for javafx.stage.FileChooser
@see javafx.stage.FileChooser
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public final class FileChooserBuilder implements javafx.util.Builder<javafx.stage.FileChooser> {
    protected FileChooserBuilder() {
    }
    
    /** Creates a new instance of FileChooserBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.stage.FileChooserBuilder create() {
        return new javafx.stage.FileChooserBuilder();
    }
    
    private int __set;
    public void applyTo(javafx.stage.FileChooser x) {
        int set = __set;
        if ((set & (1 << 0)) != 0) x.getExtensionFilters().addAll(this.extensionFilters);
        if ((set & (1 << 1)) != 0) x.setInitialDirectory(this.initialDirectory);
        if ((set & (1 << 2)) != 0) x.setTitle(this.title);
    }
    
    private java.util.Collection<? extends javafx.stage.FileChooser.ExtensionFilter> extensionFilters;
    /**
    Add the given items to the List of items in the {@link javafx.stage.FileChooser#getExtensionFilters() extensionFilters} property for the instance constructed by this builder.
    */
    public javafx.stage.FileChooserBuilder extensionFilters(java.util.Collection<? extends javafx.stage.FileChooser.ExtensionFilter> x) {
        this.extensionFilters = x;
        __set |= 1 << 0;
        return this;
    }
    
    /**
    Add the given items to the List of items in the {@link javafx.stage.FileChooser#getExtensionFilters() extensionFilters} property for the instance constructed by this builder.
    */
    public javafx.stage.FileChooserBuilder extensionFilters(javafx.stage.FileChooser.ExtensionFilter... x) {
        return extensionFilters(java.util.Arrays.asList(x));
    }
    
    private java.io.File initialDirectory;
    /**
    Set the value of the {@link javafx.stage.FileChooser#getInitialDirectory() initialDirectory} property for the instance constructed by this builder.
    */
    public javafx.stage.FileChooserBuilder initialDirectory(java.io.File x) {
        this.initialDirectory = x;
        __set |= 1 << 1;
        return this;
    }
    
    private java.lang.String title;
    /**
    Set the value of the {@link javafx.stage.FileChooser#getTitle() title} property for the instance constructed by this builder.
    */
    public javafx.stage.FileChooserBuilder title(java.lang.String x) {
        this.title = x;
        __set |= 1 << 2;
        return this;
    }
    
    /**
    Make an instance of {@link javafx.stage.FileChooser} based on the properties set on this builder.
    */
    public javafx.stage.FileChooser build() {
        javafx.stage.FileChooser x = new javafx.stage.FileChooser();
        applyTo(x);
        return x;
    }
}
