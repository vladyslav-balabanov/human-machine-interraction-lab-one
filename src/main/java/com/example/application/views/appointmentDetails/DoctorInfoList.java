package com.example.application.views.appointmentDetails;

import com.example.application.models.DoctorInfo;
import com.example.application.models.PriceTableItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

@Getter
public class DoctorInfoList extends VerticalLayout {
    private final Span name;
    private final Span age;
    private final Span exp;
    private final PriceTable prices;

    public DoctorInfoList(DoctorInfo doctorInfo) {
        name = new Span(doctorInfo.getName());
        age = new Span(String.format("Is %s years old. Has studied at %s.",
                doctorInfo.getAge(), doctorInfo.getEducation()));
        exp = new Span(doctorInfo.getWorkingPeriod());
        prices = PriceTable.forOne(doctorInfo.getId());

        add(name, age, exp, prices);
    }
}
