package com.project.periodental.adapter.di;

import com.project.periodental.adapter.di.activej.DIActiveJ;

/**
 * @author djimenez on 29/3/2022
 * periodental
 */
public class DIFactory {

    public static IDIAdapter getAdapter(DIType type) {
        switch (type) {
            default: return new DIActiveJ();
        }
    }
}
