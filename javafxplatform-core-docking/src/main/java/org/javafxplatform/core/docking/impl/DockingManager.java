/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javafxplatform.core.docking.impl;

import javafx.application.Platform;
import javafx.scene.Node;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.References;
import org.apache.felix.scr.annotations.Service;
import org.javafxplatform.core.docking.DockablePane;
import org.javafxplatform.core.startup.ApplicationContentProvider;
import org.richclientplatform.core.docking.processing.DockingAreaDescriptor;
import org.richclientplatform.core.docking.processing.DockingDescriptor;

/**
 *
 * @author puce
 */
@Component
@Service
@References({
    @Reference(name = "dockingAreaDescriptor", referenceInterface = DockingAreaDescriptor.class,
    cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE, policy = ReferencePolicy.DYNAMIC),
    @Reference(name = "dockingDescriptor", referenceInterface = DockingDescriptor.class,
    cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE, policy = ReferencePolicy.DYNAMIC)
})
public class DockingManager implements ApplicationContentProvider {

    private final DockingPane dockingPane = new DockingPane();

    protected void bindDockingAreaDescriptor(DockingAreaDescriptor dockingAreaDescriptor) {
        DockingAreaPane dockingAreaPane = new DockingAreaPane();
        dockingPane.addDockingArea(dockingAreaPane);
    }

    protected void unbindDockingAreaDescriptor(DockingAreaDescriptor dockingAreaDescriptor) {
    }

    protected void bindDockingDescriptor(final DockingDescriptor dockingAreaDescriptor) {
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                DockablePane dockablePane = (DockablePane) dockingAreaDescriptor.getDockable();
                dockablePane.setTitle(dockingAreaDescriptor.getDisplayName());
                dockingPane.addDockable(dockablePane);
            }
        });
    }

    protected void unbindDockingDescriptor(DockingDescriptor dockingDescriptor) {
    }

    @Override
    public Node getContentPane() {
        return dockingPane;
    }
}
