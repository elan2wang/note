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

package javafx.scene.shape;

/**
Builder class for javafx.scene.shape.PathElement
@see javafx.scene.shape.PathElement
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public abstract class PathElementBuilder<B extends javafx.scene.shape.PathElementBuilder<B>> {
    protected PathElementBuilder() {
    }
    
    
    private boolean __set;
    public void applyTo(javafx.scene.shape.PathElement x) {
        if (__set) x.setAbsolute(this.absolute);
    }
    
    private boolean absolute;
    /**
    Set the value of the {@link javafx.scene.shape.PathElement#isAbsolute() absolute} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B absolute(boolean x) {
        this.absolute = x;
        __set = true;
        return (B) this;
    }
    
}
