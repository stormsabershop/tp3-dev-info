import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TriangleTest {

    Triangle t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14;

    @BeforeEach
    public void TriangleTest() {
        t1 = new Triangle();
        t2 = new Triangle(Triangle.LARG_DEFAUT,Triangle.HAUT_DEFAUT,Triangle.COUL_DEFAUT);
        t3 = new Triangle(Triangle.DIM_MAX,Triangle.DIM_MAX,"eeeeeeeedeeeeeee"); //longeur de 16 pour la couleur

    }

    @Test
    void getLargeur() {
    }

    @Test
    void getHauteur() {
    }

    @Test
    void getCouleur() {
    }

    @Test
    void setLargeur() {
    }

    @Test
    void validerLargeur() {
    }

    @Test
    void setHauteur() {
    }

    @Test
    void validerHauteur() {
    }

    @Test
    void setCouleur() {
    }

    @Test
    void validerCouleur() {
    }

    @Test
    void aire() {
    }

    @Test
    void perimetre() {
    }

    @Test
    void memeLargeur() {
    }

    @Test
    void memeHauteur() {
    }
}