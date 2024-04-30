import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TriangleTest {

    Triangle t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14;

    @BeforeEach
    public void TriangleTest() {
        t1 = new Triangle();
        t2 = new Triangle(Triangle.LARG_DEFAUT,Triangle.HAUT_DEFAUT,Triangle.COTE_DEFAUT,Triangle.COUL_DEFAUT);
        t3 = new Triangle(Triangle.DIM_MAX,Triangle.DIM_MAX,Triangle.DIM_MAX,"eeeeeeeeeeeeeee"); //longeur de 15 pour la couleur
        t4 = new Triangle(Triangle.DIM_MAX +1,Triangle.DIM_MAX+1,Triangle.DIM_MAX +1,"eeeeeeeeeeeeeeee"); //longeur de 16 pour la couleur
        t5 = new Triangle(Triangle.DIM_MIN -1,Triangle.DIM_MIN-1,Triangle.DIM_MIN-1,"e");
        t6 = new Triangle(8,10,5,"bleu");
    }

    @Test
    void getLargeur() {
        assertEquals(t1.getLargeur(),Triangle.LARG_DEFAUT);
        assertTrue(t2.getLargeur() == Triangle.LARG_DEFAUT);
        assertTrue(t3.getLargeur() == Triangle.DIM_MAX);
        assertTrue(t4.getLargeur() == Triangle.LARG_DEFAUT);
        assertTrue(t5.getLargeur() == Triangle.LARG_DEFAUT);
        assertTrue(t6.getLargeur() == 8);
    }

    @Test
    void getHauteur() {
        assertTrue(t1.getHauteur() == Triangle.HAUT_DEFAUT);
        assertTrue(t2.getHauteur() == Triangle.HAUT_DEFAUT);
        assertTrue(t3.getHauteur() == Triangle.DIM_MAX);
        assertTrue(t4.getHauteur() == Triangle.HAUT_DEFAUT);
        assertTrue(t5.getHauteur() == Triangle.HAUT_DEFAUT);
        assertTrue(t6.getHauteur() == 10);
    }

    @Test
    void getCouleur() {
        assertEquals(t1.getCouleur(),Triangle.COUL_DEFAUT);
        assertEquals(t2.getCouleur(),Triangle.COUL_DEFAUT);
        assertEquals(t3.getCouleur(),"eeeeeeeeeeeeeee");
        assertNotEquals(t4.getCouleur(),"eeeeeeeeeeeeeeee");
        assertEquals(t4.getCouleur(),Triangle.COUL_DEFAUT);
        assertNotEquals(t5.getCouleur(),"e");
        assertEquals(t5.getCouleur(),Triangle.COUL_DEFAUT);
        assertEquals(t6.getCouleur(),"bleu");
    }

    @Test
    void getCote() {
        assertTrue(t1.getCote() == Triangle.COTE_DEFAUT);
        assertTrue(t2.getCote() == Triangle.COTE_DEFAUT);
        assertTrue(t3.getCote() == Triangle.DIM_MAX);
        assertTrue(t4.getCote() == Triangle.COTE_DEFAUT);
        assertTrue(t5.getCote() == Triangle.COTE_DEFAUT);
        assertTrue(t6.getCote() == 5);
    }

    @Test
    void setLargeur() {
        t1.setLargeur(Triangle.LARG_DEFAUT);
        assertEquals(t1.getLargeur(),Triangle.LARG_DEFAUT);
        t1.setLargeur(200);
        assertFalse(t1.getLargeur() == 200);
        t1.setLargeur(1);
        assertFalse(t1.getLargeur() == 1);
        t1.setLargeur(0);
        assertFalse(t1.getLargeur() == 0);
        assertTrue(t1.getLargeur() == Triangle.LARG_DEFAUT);
    }

    @Test
    void validerLargeur() {
        assertTrue(Triangle.validerLargeur(Triangle.DIM_MAX));
        assertTrue(Triangle.validerLargeur(Triangle.DIM_MIN));
        assertFalse(Triangle.validerLargeur(0));
        assertFalse(Triangle.validerLargeur(200));
        assertTrue(Triangle.validerLargeur(12));
    }

    @Test
    void setHauteur() {
        t1.setHauteur(Triangle.HAUT_DEFAUT);
        assertTrue(t1.getHauteur() == Triangle.HAUT_DEFAUT);
        t1.setHauteur(10);
        assertTrue(t1.getHauteur() == 10);
        t1.setHauteur(Triangle.DIM_MIN -1);
        assertTrue(t1.getHauteur() == Triangle.DIM_MIN);
        t1.setHauteur(Triangle.DIM_MAX + 1);
        assertTrue(t1.getHauteur() == Triangle.DIM_MAX);
        t1.setHauteur(Triangle.DIM_MAX);
        assertTrue(t1.getHauteur() == Triangle.DIM_MAX);
        t1.setHauteur(Triangle.DIM_MIN);
        assertTrue(t1.getHauteur() == Triangle.DIM_MIN);
    }

    @Test
    void validerHauteur() {
        assertTrue(Triangle.validerHauteur(Triangle.DIM_MAX));
        assertTrue(Triangle.validerHauteur(Triangle.DIM_MIN));
        assertFalse(Triangle.validerHauteur(0));
        assertFalse(Triangle.validerHauteur(200));
        assertTrue(Triangle.validerHauteur(12));
    }

    @Test
    void setCouleur() {
        t1.setCouleur(null);
        assertEquals(t1.getCouleur(),Carree.COUL_DEFAUT);
        t1.setCouleur("ver");
        assertEquals(t1.getCouleur(),Carree.COUL_DEFAUT);
        t1.setCouleur("vert");
        assertEquals(t1.getCouleur(),"vert");
        t1.setCouleur("orangeRougePale");
        assertEquals(t1.getCouleur(),"orangeRougePale");
        t1.setCouleur("orangeRougeFonce");
        assertNotEquals(t1.getCouleur(),"orangeRougeFonce");
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
    void setCote() {
        t1.setCote(Triangle.COTE_DEFAUT);
        assertTrue(t1.getCote() == Triangle.COTE_DEFAUT);
        t1.setCote(10);
        assertTrue(t1.getCote() == 10);
        t1.setCote(Triangle.DIM_MIN -1);
        assertTrue(t1.getCote() == Triangle.DIM_MIN);
        t1.setCote(Triangle.DIM_MAX + 1);
        assertTrue(t1.getCote() == Triangle.DIM_MAX);
        t1.setCote(Triangle.DIM_MAX);
        assertTrue(t1.getCote() == Triangle.DIM_MAX);
        t1.setCote(Triangle.DIM_MIN);
        assertTrue(t1.getCote() == Triangle.DIM_MIN);
    }

    @Test
    void validerCote() {
        assertTrue(Triangle.validerCote(Triangle.DIM_MAX));
        assertTrue(Triangle.validerCote(Triangle.DIM_MIN));
        assertFalse(Triangle.validerCote(0));
        assertFalse(Triangle.validerCote(200));
        assertTrue(Triangle.validerCote(12));
    }

    @Test
    void aire() {
        assertEquals(t1.aire(),7); //valeur est en int donc 7 et non 7.5
    }

    @Test
    void perimetre() {
        assertEquals(t1.perimetre(),15);
        assertNotEquals(20, t1.perimetre());
    }

    @Test
    void memeLargeur() {
        t1.setLargeur(9);
        t2.setLargeur(9);
        assertTrue(t1.memeLargeur(t2));
        t2.setLargeur(7);
        assertFalse(t2.memeLargeur(t1));
    }

    @Test
    void memeHauteur() {
        t1.setHauteur(9);
        t2.setHauteur(9);
        assertTrue(t1.memeHauteur(t2));
        t2.setHauteur(7);
        assertFalse(t2.memeHauteur(t1));
    }
}