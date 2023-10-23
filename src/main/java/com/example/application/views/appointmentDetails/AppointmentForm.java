package com.example.application.views.appointmentDetails;

import com.example.application.models.AppointmentDetails;
import com.example.application.models.DoctorInfo;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class AppointmentForm extends FormLayout {
    private AppointmentDetails details = new AppointmentDetails();
    private DateTimePicker dateField = new DateTimePicker();
    private TextArea descriptionField = new TextArea();
    private TextField doctorName = new TextField();
    private TextField patientNameField = new TextField();
    private DatePicker patientDateOfBirthField = new DatePicker();
    private TextField patientNumberField = new TextField();
    private TextField patientEmailField = new TextField();

    public AppointmentForm(DoctorInfo doctorInfo) {
        details.setDoctorDetails(doctorInfo);

        patientEmailField.setLabel("Enter your email");
        patientEmailField.setPattern("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
        patientEmailField.setPlaceholder("YourEmail@gmail.com");
        patientEmailField.setErrorMessage("Email is not correct");
        patientEmailField.addValueChangeListener(e -> details.setPatientEmail(e.getValue()));

        patientNumberField.setPattern("[0-9]{2}-[0-9]{3}-[0-9]{4}");
        patientNumberField.setPrefixComponent(new Span("+380"));
        patientNumberField.setErrorMessage("Number is not correct");
        patientNumberField.setAriaLabel("Enter phone number");
        patientNumberField.setPlaceholder("68-000-0000");
        patientNumberField.setRequiredIndicatorVisible(true);
        patientNumberField.setRequired(true);
        patientNumberField.setLabel("Enter your phone number");
        patientNumberField.addValueChangeListener(e -> details.setPatientNumber(e.getValue()));

        patientDateOfBirthField.setLabel("Pick date of birth");
        patientDateOfBirthField.addValueChangeListener(e -> details.setPatientDateOfBirth(e.getValue()));

        patientNameField.setLabel("Enter your full name");
        patientNameField.setPlaceholder("Surname First name Middle name (opt.) Patronymic (opt.)");
        patientNameField.setRequiredIndicatorVisible(true);
        patientNameField.setRequired(true);
        patientNameField.addValueChangeListener(e -> details.setPatientName(e.getValue()));

        add(patientNameField, patientDateOfBirthField, patientNumberField, patientEmailField);

        doctorName.setReadOnly(true);
        doctorName.setValue(doctorInfo.getName());
        doctorName.setLabel("Dentist");

        dateField.addValueChangeListener( event -> {
            details.setDatetime(event.getValue());
        });
        dateField.setLabel("Select appointment date and time");
        dateField.setRequiredIndicatorVisible(true);

        descriptionField.setLabel("Description");
        descriptionField.setPlaceholder("Write here about your condition. Have any questions? Ask us there.");
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

        getStyle().set("background-color", "orange").setBorder("2px solid black");
    }
}
