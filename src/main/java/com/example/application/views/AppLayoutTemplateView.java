package com.example.application.views;

import com.example.application.views.apply.ApplyView;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;

public class AppLayoutTemplateView extends AppLayout {
    public final Tabs drawerTabs;
    public AppLayoutTemplateView() {
        H1 title = new H1("Dentistry");

        addToNavbar(new DrawerToggle(), title);
        drawerTabs = createDrawer();
        addToDrawer(drawerTabs);

        setPrimarySection(Section.NAVBAR);
    }

    private Tabs createDrawer() {
        Tabs tabs = new Tabs();

        Tab main = new Tab(new RouterLink("Main", MainView.class));
        Tab apply = new Tab(new RouterLink("Apply", ApplyView.class));

        tabs.add(main, apply);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        return tabs;
    }
}
