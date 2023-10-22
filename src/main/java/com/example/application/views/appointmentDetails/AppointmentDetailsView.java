package com.example.application.views.appointmentDetails;

import com.example.application.models.DoctorInfo;
import com.example.application.views.AppLayoutTemplateView;
import com.example.application.views.apply.ApplyView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;

import java.util.Objects;

@PageTitle("Appointment details")
@Route(value = "details", layout = AppLayoutTemplateView.class)
public class AppointmentDetailsView extends AppLayout implements HasUrlParameter<Long> {

    @Override
    public void setParameter(BeforeEvent beforeEvent, Long l) {
        ApplyView.mockDoctorInfo().stream()
                .filter(o -> Objects.equals(o.getId(), l))
                .findFirst().ifPresent(doctorInfo -> setContent(createAppointmentDetails(doctorInfo)));
    }

    private Component createAppointmentDetails(DoctorInfo doctorInfo) {
        VerticalLayout details = new VerticalLayout();

        DoctorInfoDetails info = new DoctorInfoDetails(doctorInfo);
        AppointmentForm form = new AppointmentForm(doctorInfo);

        details.add(info, form);
        return details;
    }
}
