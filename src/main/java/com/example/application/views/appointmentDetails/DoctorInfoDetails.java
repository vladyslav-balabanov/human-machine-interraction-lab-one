package com.example.application.views.appointmentDetails;

import com.example.application.models.DoctorInfo;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.dom.Style;

public class DoctorInfoDetails extends HorizontalLayout {
    private final Image image = new Image("images/placeholder-image.png", "Doctor's photo");
    public DoctorInfoDetails(DoctorInfo doctorInfo) {
        setSizeFull();
        image.setWidthFull();
        add(image);

        DoctorInfoList infoList = new DoctorInfoList(doctorInfo);
        add(infoList);
    }
}
