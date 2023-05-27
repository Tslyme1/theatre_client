package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "voucher", schema = "public", catalog = "theatre")
public class VoucherEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "tickets_left")
    private int ticketsLeft;
    @Basic
    @Column(name = "genre")
    private String genre;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private AuthorEntity authorByAuthorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getTicketsLeft() {
        return ticketsLeft;
    }

    public void setTicketsLeft(int ticketsLeft) {
        this.ticketsLeft = ticketsLeft;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoucherEntity that = (VoucherEntity) o;
        return id == that.id  && ticketsLeft == that.ticketsLeft && Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketsLeft, genre);
    }

    public AuthorEntity getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(AuthorEntity authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }
}
