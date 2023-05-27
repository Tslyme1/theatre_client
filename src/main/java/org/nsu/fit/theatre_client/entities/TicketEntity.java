package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ticket", schema = "public", catalog = "theatre")
public class TicketEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "price")
    private BigInteger price;
    @Basic
    @Column(name = "sell_dt")
    private Timestamp sellDt;
    @Basic
    @Column(name = "row")
    private int row;
    @Basic
    @Column(name = "seat")
    private int seat;
    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
    private EventEntity eventByEventId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Timestamp getSellDt() {
        return sellDt;
    }

    public void setSellDt(Timestamp sellDt) {
        this.sellDt = sellDt;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketEntity that = (TicketEntity) o;
        return id == that.id && eventByEventId.getId() == that.eventByEventId.getId() && row == that.row && seat == that.seat && Objects.equals(price, that.price) && Objects.equals(sellDt, that.sellDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventByEventId, price, sellDt, row, seat);
    }

    public EventEntity getEventByEventId() {
        return eventByEventId;
    }

    public void setEventByEventId(EventEntity eventByEventId) {
        this.eventByEventId = eventByEventId;
    }
}
