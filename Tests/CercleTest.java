
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CercleTest {


    Cercle c0, c1, c2, c3, c4, c5, c6, c12, c13, c14,
            c15, c16;

    @BeforeEach
    public void testCercle()
    {
        c0 = new Cercle();
    }

    @BeforeEach
    public void testCercleIntIntString()
    {
        // Tout valide
        c1 = new Cercle(6, "bleu");

        // Tests sur rayon
        c2 = new Cercle(Cercle.DIM_MIN - 1, "bleu");
        c3 = new Cercle(Cercle.DIM_MIN, "bleu");
        c4 = new Cercle(6,"bleu");
        c5 = new Cercle(Carree.DIM_MAX, "bleu");
        c6 = new Cercle(Carree.DIM_MAX + 1, "bleu");

        // Tests sur couleur
        c12 = new Cercle(6, null);
        c13 = new Cercle(6, "ver");
        c14 = new Cercle(6, "vert");
        c15 = new Cercle(6, "orangeRougePale");
        c16 = new Cercle(6, "orangeRougeFonce");
    }



    @Test
    void getRayon() {
        assertTrue(c0.getRayon() == Cercle.RAY_DEFAUT);
        assertTrue(c1.getRayon() == 6);
        assertTrue(c2.getRayon() == Cercle.RAY_DEFAUT);
        assertTrue(c3.getRayon() == Cercle.DIM_MIN);
        assertTrue(c4.getRayon() == 6);
        assertTrue(c5.getRayon() == Cercle.DIM_MAX);
        assertTrue(c6.getRayon() == Cercle.RAY_DEFAUT);
    }

    @Test
    void getCouleur() {
        assertEquals(c0.getCouleur(),Carree.COUL_DEFAUT);
        assertEquals(c1.getCouleur(),"bleu");
        assertEquals(c12.getCouleur(),Carree.COUL_DEFAUT);
        assertEquals(c13.getCouleur(),Carree.COUL_DEFAUT);
        assertEquals(c14.getCouleur(),"vert");
        assertEquals(c15.getCouleur(),"orangeRougePale");
        assertEquals(c16.getCouleur(),Carree.COUL_DEFAUT);
    }

    @Test
    void setRayon() {
        c1.setRayon(Cercle.DIM_MIN - 1);
        assertTrue(c1.getRayon() == Cercle.DIM_MIN);
        c1.setRayon(Carree.DIM_MIN);
        assertTrue(c1.getRayon() == Cercle.DIM_MIN);
        c1.setRayon(7);
        assertTrue(c1.getRayon() == 7);
        c1.setRayon(Carree.DIM_MAX + 1);
        assertTrue(c1.getRayon() == Cercle.DIM_MAX);
    }


    @Test
    void validerRayon() {
        assertFalse(Cercle.validerRayon(Cercle.DIM_MIN-1));
        assertTrue(Cercle.validerRayon(Cercle.DIM_MIN));
        assertTrue(Cercle.validerRayon(9));
        assertFalse(Cercle.validerRayon(Cercle.DIM_MAX+1));
        assertTrue(Cercle.validerRayon(Cercle.DIM_MAX));
    }

    @Test
    void setCouleur() {
        c1.setCouleur(null);
        assertEquals(c1.getCouleur(),Cercle.COUL_DEFAUT);
        c1.setCouleur("ver");
        assertEquals(c1.getCouleur(),Cercle.COUL_DEFAUT);
        c1.setCouleur("vert");
        assertEquals(c1.getCouleur(),"vert");
        c1.setCouleur("orangeRougePale");
        assertEquals(c1.getCouleur(),"orangeRougePale");
        c1.setCouleur("orangeRougeFonce");
        assertEquals(c1.getCouleur(),Cercle.COUL_DEFAUT);

    }
    @Test
    void validerCouleur() {
        assertFalse(Cercle.validerCouleur(null));
        assertFalse(Cercle.validerCouleur("ver"));
        assertTrue(Cercle.validerCouleur("vert"));
        assertTrue(Cercle.validerCouleur("orangeRougePale"));
        assertFalse(Cercle.validerCouleur("orangeRougeFonce"));

    }
    @Test
    void aire() {
        assertEquals(c1.aire(),113);

    }
    @Test
    void perimetre() {
        assertEquals(c1.perimetre(),36); //valeur en int donc pas exactement le bon mais c'est ok
        assertNotEquals(20, c1.perimetre());
    }
    @Test
    void memeRayon() {
        c1.setRayon(9);
        c2.setRayon(9);
        assertTrue(c1.memeRayon(c2));
        c2.setRayon(7);
        assertFalse(c2.memeRayon(c1));
    }
}