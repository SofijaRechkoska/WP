package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rating;
    private String comment;

    @ManyToOne
    private Song song;

    public Review(int rating, String comment) {
        this.rating=rating;
        this.comment=comment;
    }

    public Review(String comment) {
        this.comment=comment;
    }
}