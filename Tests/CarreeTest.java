
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarreeTest {


    Carree c0, c1, c2, c3, c4, c5, c6, c12, c13, c14,
            c15, c16;

    @BeforeEach
    public void testCarree()
    {
        c0 = new Carree();
    }

    @BeforeEach
    public void testCarreeIntIntString()
    {
        // Tout valide
        c1 = new Carree(6, "bleu");

        // Tests sur largeur
        c2 = new Carree(Carree.DIM_MIN - 1, "bleu");
        c3 = new Carree(Carree.DIM_MIN, "bleu");
        c4 = new Carree(6,"bleu");
        c5 = new Carree(Carree.DIM_MAX, "bleu");
        c6 = new Carree(Carree.DIM_MAX + 1, "bleu");

        // Tests sur couleur
        c12 = new Carree(6, null);
        c13 = new Carree(6, "ver");
        c14 = new Carree(6, "vert");
        c15 = new Carree(6, "orangeRougePale");
        c16 = new Carree(6, "orangeRougeFonce");
    }



    @Test
    void getLargeur() {
        /*
		la largeur de r0 = largeur par defaut
		la largeur de r1 = 6
		la largeur de r2 = largeur par defaut
		la largeur de r3 = dimension minimale
		la largeur de r4 = 6
		la largeur de r5 = dimension maximale
		la largeur de r6 = largeur par defaut
		 */
        assertTrue(c0.getLargeur() == Carree.LARG_DEFAUT);
        assertTrue(c1.getLargeur() == 6);
        assertTrue(c2.getLargeur() == Carree.LARG_DEFAUT);
        assertTrue(c3.getLargeur() == Carree.DIM_MIN);
        assertTrue(c4.getLargeur() == 6);
        assertTrue(c5.getLargeur() == Carree.DIM_MAX);
        assertTrue(c6.getLargeur() == Carree.LARG_DEFAUT);
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
    void setLargeur() {
        c1.setLargeur(Carree.DIM_MIN - 1);
        assertTrue(c1.getLargeur() == Carree.DIM_MIN);
        c1.setLargeur(Carree.DIM_MIN);
        assertTrue(c1.getLargeur() == Carree.DIM_MIN);
        c1.setLargeur(7);
        assertTrue(c1.getLargeur() == 7);
        c1.setLargeur(Carree.DIM_MAX + 1);
        assertTrue(c1.getLargeur() == Carree.DIM_MAX);
    }


    @Test
    void validerLargeur() {
        assertFalse(Carree.validerLargeur(Carree.DIM_MIN-1));
        assertTrue(Carree.validerLargeur(Carree.DIM_MIN));
        assertTrue(Carree.validerLargeur(9));
        assertFalse(Carree.validerLargeur(Carree.DIM_MAX+1));


    }

    @Test
    void setCouleur() {
        c1.setCouleur(null);
        assertEquals(c1.getCouleur(),Carree.COUL_DEFAUT);
        c1.setCouleur("ver");
        assertEquals(c1.getCouleur(),Carree.COUL_DEFAUT);
        c1.setCouleur("vert");
        assertEquals(c1.getCouleur(),"vert");
        c1.setCouleur("orangeRougePale");
        assertEquals(c1.getCouleur(),"orangeRougePale");
        c1.setCouleur("orangeRougeFonce");
        assertEquals(c1.getCouleur(),Carree.COUL_DEFAUT);

    }
    @Test
    void validerCouleur() {
        assertFalse(Carree.validerCouleur(null));
        assertFalse(Carree.validerCouleur("ver"));
        assertTrue(Carree.validerCouleur("vert"));
        assertTrue(Carree.validerCouleur("orangeRougePale"));
        assertFalse(Carree.validerCouleur("orangeRougeFonce"));

    }
    @Test
    void aire() {
        assertEquals(c1.aire(),36);

    }
    @Test
    void perimetre() {
        assertEquals(c1.perimetre(),24);
        assertNotEquals(20, c1.perimetre());
    }
    @Test
    void memeLargeur() {
        c1.setLargeur(9);
        c2.setLargeur(9);
        assertTrue(c1.memeLargeur(c2));
        c2.setLargeur(7);
        assertFalse(c2.memeLargeur(c1));
    }
}