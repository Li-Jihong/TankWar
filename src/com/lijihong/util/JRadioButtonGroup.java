package com.lijihong.util;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 * \* Created with IntelliJ IDEA.
 * \* @ProjectName: TankWar
 * \* @FileName: JRadioButtonGroup
 * \* @author: li-jihong
 * \* Date: 2023-04-25 18:38
 */
public class JRadioButtonGroup extends ButtonGroup {
    /**
     * 获得选中的按钮
     */
    public JRadioButton getSelectedJRadioButton() {
        AbstractButton button;
        for (Iterator<AbstractButton> it = getElements().asIterator(); it.hasNext(); ) {
            button = it.next();
            if (isSelected(button.getModel())) {
                return (JRadioButton) button;
            }
        }
        return null;
    }
    public @Nullable String getSelectedActionCommand() {
        JRadioButton selectedJRadioButton = getSelectedJRadioButton();
        if (selectedJRadioButton == null) {
            return null;
        }
        return selectedJRadioButton.getActionCommand();
    }
    @Override
    public void add(AbstractButton b) {
        if (b instanceof JRadioButton) {
            super.add(b);
        } else {
            throw new IllegalArgumentException("Only JRadioButton supported.");
        }
    }
    /**
     * 为组内所有按钮都设置 ActionListener
     */
    public void addActionListener(ActionListener actionListener) {
        for (Iterator<AbstractButton> it = getElements().asIterator(); it.hasNext(); ) {
            AbstractButton button = it.next();
            button.addActionListener(actionListener);
        }
    }
}
