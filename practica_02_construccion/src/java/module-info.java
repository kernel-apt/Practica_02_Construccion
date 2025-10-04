module controllers 
{ 
    requires org.kordamp.bootstrapfx.core;
    requires com.gluonhq.attach.lifecycle;
    requires com.gluonhq.attach.display;
    requires com.gluonhq.charm.glisten;
    requires transitive javafx.graphics;
    requires com.pixelduke.fxparallax;
    requires com.gluonhq.attach.util;
    requires eu.hansolo.fx.countries;
    requires eu.hansolo.fx.heatmap;
    requires eu.hansolo.toolboxfx;
    requires com.gluonhq.glisten;
    requires eu.hansolo.toolbox;
    requires javafx.controls;
    requires javafx.media;
    requires javafx.fxml;
    requires javafx.base;   
    requires jdk.javadoc;

    opens controllers to javafx.fxml;
    exports controllers;
}