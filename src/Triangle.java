

public class Triangle {

    public static final int DIM_MIN = 3;
    public static final int DIM_MAX = 20;
    public static final int LARG_DEFAUT = 3;
    public static final int HAUT_DEFAUT = 5;
    public static final String COUL_DEFAUT = "blanc";
    public static final int LONGUEUR_COUL_MIN = 4;
    public static final int LONGUEUR_COUL_MAX = 15;

    private int largeur;
    private int hauteur;
    private String couleur;

    Triangle()
    {
        this(LARG_DEFAUT, HAUT_DEFAUT, COUL_DEFAUT);
    }

    Triangle(int pLarg, int pHaut, String pCoul)
    {
        boolean ok = setLargeur(pLarg) && setHauteur(pHaut)
                && setCouleur(pCoul);
        if (!ok)
        {
            largeur = LARG_DEFAUT;
            hauteur = HAUT_DEFAUT;
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

    public String getCouleur()
    {
        return couleur;
    }

    public boolean setLargeur(int pLarg)
    {
        boolean ok = validerLargeur(pLarg);
        if (ok)
            largeur = pLarg;
        return ok;
    }

    public static boolean validerLargeur(int pLarg)
    {
        return (pLarg >= DIM_MIN && pLarg <= DIM_MAX);
    }

    public boolean setHauteur(int pHaut)
    {
        boolean ok = validerHauteur(pHaut);
        if (ok)
            hauteur = pHaut;
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
        return (largeur + hauteur) * 2;
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


    public static void main(String[] args)
    {
        Triangle triangle = new Triangle(3,5,"vert");
        System.out.println(triangle);


    }
}