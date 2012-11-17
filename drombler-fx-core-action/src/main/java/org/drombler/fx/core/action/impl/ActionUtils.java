/*
 *         COMMON DEVELOPMENT AND DISTRIBUTION LICENSE (CDDL) Notice
 *
 * The contents of this file are subject to the COMMON DEVELOPMENT AND DISTRIBUTION LICENSE (CDDL)
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. A copy of the License is available at
 * http://www.opensource.org/licenses/cddl1.txt
 *
 * The Original Code is Drombler.org. The Initial Developer of the
 * Original Code is Florian Brunner (Sourceforge.net user: puce).
 * Copyright 2012 Drombler.org. All Rights Reserved.
 *
 * Contributor(s): .
 */
package org.drombler.fx.core.action.impl;

import javafx.application.Platform;
import javafx.scene.input.KeyCombination;
import org.drombler.acp.core.action.spi.ActionDescriptor;
import org.drombler.fx.core.action.FXAction;

/**
 *
 * @author puce
 */
public class ActionUtils {

    private ActionUtils() {
    }

    public static void configureAction(FXAction fxAction, ActionDescriptor actionDescriptor) {
        System.out.println(ActionUtils.class.getName()+": isFxApplicationThread: "+Platform.isFxApplicationThread());
        fxAction.setDisplayName(actionDescriptor.getDisplayName());
        if (actionDescriptor.getAccelerator() != null && !actionDescriptor.getAccelerator().equals("")) {
            fxAction.setAccelerator(KeyCombination.keyCombination(actionDescriptor.getAccelerator()));
        }
        if (actionDescriptor.getIcon() != null && !actionDescriptor.getIcon().equals("")) {
            fxAction.setIcon(actionDescriptor.getIcon());
        }
    }
}
