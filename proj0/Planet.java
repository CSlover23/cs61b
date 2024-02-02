public class Planet {
    /*
     * SAME TYPE VARIABLES CAN BE DECLARED IN ONE LINE BUT NOT RECOMMENDED
     * BECAUSE ONE DECLARIATION IN ONE LIEN IS FRIENDLY TO COMMENT
     */
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static final double G = 6.67e-11;

    // BEFORE COMPILING YOU NEED TO SAVE THE FILE IN EDITOR.

    /* this way is more elegant but "this." is a must */
    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;

        // public Planet(double xP, double yP, double xV, double yV, double m, String
        // img) {
        /*
         * OPTIONALLY YOU CAN ADD "this." TO THE LEFT VARIABLE such as
         * "this.xxPos = xP;"
         */
        // xxPos = xP;
        // yyPos = yP;
        // xxVel = xV;
        // yyVel = yV;
        // mass = m;
        // imgFileName = img;

    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt((xxPos - p.xxPos) * (xxPos - p.xxPos) + (yyPos - p.yyPos) * (yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p) {
        // return G * mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
        /*
         * NO NEED "this": Java implicitly assumes a reference to the current object for
         * methods called like this.
         */
        return G * mass * p.mass / (calcDistance(p) * calcDistance(p));
    }

    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double netForcex = 0;
        for (int i = 0; i < allPlanets.length; i += 1) {
            /*
             * equals(obejct x) IS A METHOD FORM CLASS OBJECT WHICH IS ROOT OF ALL THE
             * CLASS
             */
            if (!equals(allPlanets[i])) {
                netForcex += calcForceExertedByX(allPlanets[i]);
            }
        }
        return netForcex;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {// if Planet [] then after save, automatically becomes
                                                               // planet[]
        double netForcey = 0;

        /* USING Enhanced For Loop */
        for (Planet p : allPlanets) {
            if (equals(p) == false) // java 'true' 'false' are lowercase
                netForcey += calcForceExertedByY(p); // IF ONLY ONE LINE if TRUE THEN NO NEED TO USE BRACKET
        }

        // for (int i = 0; i < allPlanets.length; i += 1) {
        // if (!equals(allPlanets[i])) { // "not"logical operator IN JAVA IS REPRESENTED
        // BY "!" mark!
        // netForcey += calcForceExertedByY(allPlanets[i]);
        // }
        // }
        return netForcey;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel += aX * dt;
        yyVel += aY * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }

}