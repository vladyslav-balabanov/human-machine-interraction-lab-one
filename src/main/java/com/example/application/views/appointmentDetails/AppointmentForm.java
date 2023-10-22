package com.example.application.views.appointmentDetails;

import com.example.application.models.AppointmentDetails;
import com.example.application.models.DoctorInfo;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

public class AppointmentForm extends FormLayout {
    private AppointmentDetails details = new AppointmentDetails();
    private DateTimePicker dateField = new DateTimePicker();
    private TextArea descriptionField = new TextArea();
    private TextField doctorName = new TextField();

    public AppointmentForm(DoctorInfo doctorInfo) {
        details.setDoctorDetails(doctorInfo);

        doctorName.setReadOnly(true);
        doctorName.setValue(doctorInfo.getName());
        doctorName.setLabel("Dentist");

        dateField.addValueChangeListener( event -> {
            details.setDatetime(event.getValue());
        });
        dateField.setLabel("Select appointment date and time");
        dateField.setRequiredIndicatorVisible(true);

        descriptionField.setLabel("Description");
        descriptionField.setPlaceholder("Write here about your condition.");
        descriptionField.setClearButtonVisible(true);
        descriptionField.addValueChangeListener(e -> details.setDescription(e.getValue()));

        Button submit = new Button("Submit");
        submit.addClickListener(click -> {
            Dialog dialog = new Dialog();
            dialog.setHeaderTitle("Appointment request submitted successfully");
            dialog.getFooter().add(new Button("Ok", e -> dialog.close()));
            dialog.getFooter().add(new Button("To main page", e -> {
                dialog.close();
                getUI().ifPresent(ui -> ui.navigate(MainView.class));
            }));
            dialog.open();
        });

        add(doctorName, dateField, descriptionField);
        setResponsiveSteps(
                new ResponsiveStep("0", 1),
                new ResponsiveStep("500px", 2)
        );
        setColspan(descriptionField, 2);
        setColspan(submit, 2);
        add(submit);
    }
}
