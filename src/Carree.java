

public class Carree {

    public static final int DIM_MIN = 2;
    public static final int DIM_MAX = 20;
    public static final int LARG_DEFAUT = 5;
    public static final String COUL_DEFAUT = "blanc";
    public static final int LONGUEUR_COUL_MIN = 4;
    public static final int LONGUEUR_COUL_MAX = 15;

    private int largeur;
    private String couleur;

    Carree()
    {
        this(LARG_DEFAUT, COUL_DEFAUT);
    }

    Carree(int pLarg,String pCoul)
    {
        boolean ok = setLargeur(pLarg)
                && setCouleur(pCoul);
        if (!ok)
        {
            largeur = LARG_DEFAUT;
            couleur = COUL_DEFAUT;
        }
    }

    public int getLargeur()
    {
        return largeur;
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
        } else if (pLarg < DIM_MIN) {
            largeur = DIM_MIN;
        }
        return ok;
    }

    public static boolean validerLargeur(int pLarg)
    {
        return (pLarg >= DIM_MIN && pLarg <= DIM_MAX);
    }

    public boolean setCouleur(String pCoul)
    {
        boolean ok = validerCouleur(pCoul);
        if (ok) {
            couleur = pCoul;
        } else {
            couleur = COUL_DEFAUT;
        }
        return ok;
    }

    public static boolean validerCouleur(String pCoul)
    {
        return (pCoul != null && pCoul.length() >= LONGUEUR_COUL_MIN
                && pCoul.length() <= LONGUEUR_COUL_MAX);
    }

    public int aire()
    {
        return (int) Math.pow(largeur,2);
    }

    public int perimetre()
    {
        return largeur * 4;
    }

    public boolean memeLargeur(Carree parRec)
    {
        return this.largeur == parRec.largeur;
    }

    @Override
    public boolean equals(Object pRec)
    {
        return pRec != null && pRec instanceof Carree
                && this.largeur == ((Carree) pRec).largeur
                && this.couleur.equals(((Carree) pRec).couleur);

    }

    @Override
    public String toString()
    {
        return "La largeur d'un cote du carre est: " + getLargeur()
                + "\nLa couleur du carree est: " + getCouleur();
    }
}