

public class Triangle {

    public static final int DIM_MIN = 3;
    public static final int DIM_MAX = 20;
    public static final int LARG_DEFAUT = 3;
    public static final int HAUT_DEFAUT = 5;
    public static final String COUL_DEFAUT = "blanc";
    public static final int LONGUEUR_COUL_MIN = 4;
    public static final int LONGUEUR_COUL_MAX = 15;
    public static final int COTE_DEFAUT = 5;

    private int largeur;
    private int hauteur;
    private int cote;
    private String couleur;

    Triangle()
    {
        this(LARG_DEFAUT, HAUT_DEFAUT,COTE_DEFAUT, COUL_DEFAUT);
    }

    Triangle(int pLarg, int pHaut, int pCote, String pCoul)
    {
        boolean ok = setLargeur(pLarg) && setHauteur(pHaut)
                && setCouleur(pCoul) && setCote(pCote);
        if (!ok)
        {
            largeur = LARG_DEFAUT;
            hauteur = HAUT_DEFAUT;
            cote = COTE_DEFAUT;
            couleur = COUL_DEFAUT;
        }
    }

    public int getLargeur()
    {
        return largeur;
    }

    public int getHauteur()
    {
        return hauteur;
    }

    public int getCote()
    {
        return cote;
    }

    public String getCouleur()
    {
        return couleur;
    }

    public boolean setLargeur(int pLarg)
    {
        boolean ok = validerLargeur(pLarg);
        if (ok) {
            largeur = pLarg;
        } else if (pLarg > DIM_MAX) {
            largeur = DIM_MAX;
        } else {
            largeur = DIM_MIN;
        }
        return ok;
    }

    public static boolean validerLargeur(int pLarg)
    {
        return (pLarg >= DIM_MIN && pLarg <= DIM_MAX);
    }

    public boolean setHauteur(int pHaut)
    {
        boolean ok = validerHauteur(pHaut);
        if (ok) {
            hauteur = pHaut;
        } else if (pHaut > DIM_MAX) {
            hauteur = DIM_MAX;
        } else {
            hauteur = DIM_MIN;
        }
        return ok;
    }

    public static boolean validerHauteur(int pHaut)
    {
        return (pHaut >= DIM_MIN && pHaut <= DIM_MAX);
    }

    public boolean setCouleur(String pCoul)
    {
        boolean ok = validerCouleur(pCoul);
        if (ok)
            couleur = pCoul;
        return ok;
    }

    public boolean setCote (int pCote) {
        boolean ok = validerCote(pCote);
        if (ok) {
            cote = pCote;
        } else if(pCote > DIM_MAX) {
            cote = DIM_MAX;
        } else {
            cote = DIM_MIN;
        }
        return ok;
    }

    public static boolean validerCote (int pCote) {
        return (pCote >= DIM_MIN && pCote <= DIM_MAX);
    }

    public static boolean validerCouleur(String pCoul)
    {
        return (pCoul != null && pCoul.length() >= LONGUEUR_COUL_MIN
                && pCoul.length() <= LONGUEUR_COUL_MAX);
    }

    public int aire()
    {
        return (largeur * hauteur) / 2;
    }

    public int perimetre()
    {
        return cote*3;
    }

    public boolean memeLargeur(Triangle parTri)
    {
        return this.largeur == parTri.largeur;
    }

    public boolean memeHauteur(Triangle parRec)
    {
        return this.hauteur == parRec.hauteur;
    }

    @Override
    public boolean equals(Object pTri)
    {
        return pTri != null && pTri instanceof Triangle
                && this.largeur == ((Triangle) pTri).largeur
                && this.hauteur == ((Triangle) pTri).hauteur
                && this.couleur.equals(((Triangle) pTri).couleur);

    }

    @Override
    public String toString()
    {
        return "La largeur du triangle est: " + getLargeur()
                + "\nLa hauteur du triangle est: " + getHauteur()
                + "\nLa couleur du triangle est: " + getCouleur();
    }
}