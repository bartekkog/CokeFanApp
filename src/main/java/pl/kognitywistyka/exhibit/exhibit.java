package pl.kognitywistyka.exhibit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Anna on 10.07.2017.
 */

@Entity
@Table(name="exhibits")
public class exhibit {

    @Id
    @Column(name="ID", nullable = false)
    private String id;
    //identyfikator elementu kolekcji

    @Column(name="NAME",nullable = false)
    private String nazwaPrzedmiotu;

    @Column(name="DATE")
    private int dataProdukcji;

    @Column(name="COUNTRY")
    private String krajPochodzenia;

    @Column(name="COLLECTIBLE")
    private boolean czyKolekcjonerski;

    @Column(name="USABLE")
    private boolean czyUżytkowy;

    @Column(name="NEW")
    private boolean czyNowy;

    //jak chcesz rozwiązać zdjecia?
    // czy jeden element kolekcji moez miec duzo zdjec?
    // id zdjecia do id przedmiotu? i moze byc wiele zdjec?
    //
    public exhibit(String id, int dataProdukcji, String krajPochodzenia, String nazwaPrzedmiotu){

    }

    public exhibit(String id, String nazwaPrzedmiotu, int dataProdukcji, String krajPochodzenia, boolean czyKolekcjonerski,boolean czyUżytkowy, boolean czyNowy){
        this(id, dataProdukcji,krajPochodzenia, nazwaPrzedmiotu);

    }

}
