

public class Cercle {

    public static final int DIM_MIN = 3;
    public static final int DIM_MAX = 20;
    public static final int RAY_DEFAUT = 3;
    public static final String COUL_DEFAUT = "blanc";
    public static final int LONGUEUR_COUL_MIN = 4;
    public static final int LONGUEUR_COUL_MAX = 15;

    private int rayon;
    private String couleur;

    Cercle()
    {
        this(RAY_DEFAUT,COUL_DEFAUT);
    }

    Cercle(int pRayo, String pCoul)
    {
        boolean ok = setRayon(pRayo)
                && setCouleur(pCoul);
        if (!ok)
        {
            rayon = RAY_DEFAUT;
            couleur = COUL_DEFAUT;
        }
    }

    public int getRayon()
    {
        return rayon;
    }

    public String getCouleur()
    {
        return couleur;
    }

    public boolean setRayon(int pRayo)
    {
        boolean ok = validerRayon(pRayo);
        if (ok) {
            rayon = pRayo;
        } else if (pRayo > DIM_MAX) {
            rayon = DIM_MAX;
        } else {
            rayon = DIM_MIN;
        }
        return ok;
    }

    public static boolean validerRayon(int pRayo)
    {
        return (pRayo >= DIM_MIN && pRayo <= DIM_MAX);
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
        return (int) (Math.PI * Math.pow(rayon,2));
    }

    public int perimetre()
    {
        return (int) (2 * Math.PI) * rayon;
    }

    public boolean memeRayon(Cercle parCer)
    {
        return this.rayon == parCer.rayon;
    }

    @Override
    public boolean equals(Object pCer)
    {
        return pCer != null && pCer instanceof Cercle
                && this.rayon == ((Cercle) pCer).rayon
                && this.couleur.equals(((Cercle) pCer).couleur);

    }

    @Override
    public String toString()
    {
        return "Le rayon du cercle est: " + getRayon()
                + "\nLa couleur du triangle est: " + getCouleur();
    }
}