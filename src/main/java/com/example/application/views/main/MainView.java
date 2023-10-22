package com.example.application.views.main;

import com.example.application.views.AppLayoutTemplateView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Main")
@Route(value = "main", layout = AppLayoutTemplateView.class)
@RouteAlias(value = "", layout = AppLayoutTemplateView.class)
public class MainView extends AppLayout {
    public MainView() {
        setContent(new Span("main info will be here"));
    }
}
