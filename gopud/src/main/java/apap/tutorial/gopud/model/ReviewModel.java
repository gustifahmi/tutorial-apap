package apap.tutorial.gopud.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="review")
public class ReviewModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReview;

    @NotNull
    @Size(max = 10)
    @Column(name = "namaReviewer", nullable = false)
    private String namaReviewer;

    @NotNull
    @Size(max = 50)
    @Column(name = "isiReview", nullable = false)
    private String isiReview;

    @NotNull
    @Size(max = 50)
    @Column(name = "kritik", nullable = false)
    private String String;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private MenuModel menuModel;
}