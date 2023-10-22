package com.example.application.views.appointmentDetails;

import com.example.application.models.PriceTableItem;
import com.vaadin.flow.component.grid.Grid;

import java.util.List;

public class PriceTable extends Grid<PriceTableItem> {
    private PriceTable() {
    }
    public static PriceTable forOne(Long doctorId) {
        PriceTable priceTable = new PriceTable();

        priceTable.addColumn(PriceTableItem::getService).setHeader("Service").setAutoWidth(true);
        priceTable.addColumn(PriceTableItem::getPrice).setHeader("Price").setAutoWidth(true);

        priceTable.setItems(mockPrices());

        return priceTable;
    }

    public static List<PriceTableItem> mockPrices() {
        return List.of(
                new PriceTableItem("Consultation", 170),
                new PriceTableItem("Oral cavity examination", 0),
                new PriceTableItem("Checking after surgical procedures", 0),
                new PriceTableItem("Tooth extraction", 250),
                new PriceTableItem("Wisdom tooth extraction", 390),
                new PriceTableItem("Tooth chiseling", 590),
                new PriceTableItem("Detained tooth chiseling", 980),
                new PriceTableItem("Composite filling class 1", 310),
                new PriceTableItem("Composite filling class 2, 3, 4", 360),
                new PriceTableItem("Composite cervical filling", 240),
                new PriceTableItem("Composite multilayer filling", 400),
                new PriceTableItem("Composite filling of milk tooth", 220),
                new PriceTableItem("Root canal treatment", 800),
                new PriceTableItem("Reconstruction on anchors", 500),
                new PriceTableItem("Reconstruction on glass post", 500),
                new PriceTableItem("Whitening with Laser or Beyond Lamp", 1200),
                new PriceTableItem("Sandblasting", 240),
                new PriceTableItem("Porcelain crown on Co-Cr (fused to metal)", 1200),
                new PriceTableItem("Porcelain veneer", 1800),
                new PriceTableItem("Full-ceramic crown", 2000)
        );
    }
}
