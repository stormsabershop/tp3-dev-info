

public class Cercle {

    public static final int DIM_MIN = 3;
    public static final int DIM_MAX = 20;
    public static final int RAY_DEFAUT = 3;
    public static final int HAUT_DEFAUT = 5;
    public static final String COUL_DEFAUT = "blanc";
    public static final int LONGUEUR_COUL_MIN = 4;
    public static final int LONGUEUR_COUL_MAX = 15;

    private int rayon;
    private String couleur;

    Cercle()
    {
        this(RAY_DEFAUT, HAUT_DEFAUT, COUL_DEFAUT);
    }

    Cercle(int pLarg, int pHaut, String pCoul)
    {
        boolean ok = setRayon(pLarg) && setHauteur(pHaut)
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
        if (ok)
            rayon = pRayo;
        return ok;
    }

    public static boolean validerRayon(int pRayo)
    {
        return (pRayo >= DIM_MIN && pRayo <= DIM_MAX);
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


    public static void main(String[] args)
    {
        Cercle cercle = new Cercle(3,5,"vert");
        System.out.println(cercle);


    }
}