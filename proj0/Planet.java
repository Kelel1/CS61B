public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double gravity = 6.67e-11;  

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {

                    xxPos = xP;
                    yyPos = yP;
                    xxVel = xV;
                    yyVel = yV;
                    mass = m;
                    imgFileName = img;

                  }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;

    }

    /** Calculate distance between two bodies */
    public double calcDistance(Planet p) {
        return Math.sqrt((p.xxPos - this.xxPos)*(p.xxPos - this.xxPos)
         + (p.yyPos - this.yyPos)*(p.yyPos - this.yyPos));
    }

    /** Return value describing the force exerted on this planet
     * by the given planet.
     */
    public double calcForceExertedBy(Planet p) {
        return (gravity*this.mass*p.mass)/(calcDistance(p)*calcDistance(p));
    }

    /** Return force exerted in the X directions */
    public double calcForceExertedByX(Planet p) {
        double xForce = calcForceExertedBy(p)*(p.xxPos - this.xxPos)
        /(calcDistance(p));

        if(xForce < 0.0) {
            return xForce*-1;
        }
        return xForce;

    }

    /** Return force exerted in the Y directions */
    public double calcForceExertedByY(Planet p) {
        double yForce= calcForceExertedBy(p)*(p.yyPos - this.yyPos)
        /(calcDistance(p));

        if(yForce < 0.0) {
            return yForce*-1;
        }
        return yForce;

    }

    /** Calculate the net X force exerted by all planets  */
    public double calcNetForceExertedByX(Planet[] p) {
        double netXForce = 0.0;
        for(int i = 0; i < p.length - 1; i++) {
            if(!p[i].equals(this)) {
                netXForce += calcForceExertedByX(p[i]);
            }           
        }
        return netXForce;
    }

    /** Calculate the net Y force exerted by all planets  */
    public double calcNetForceExertedByY(Planet[] p) {
        double netYForce = 0.0;
        for(int i = 0; i < p.length - 1; i++) {
            
            if(!p[i].equals(this)) {
                netYForce += calcForceExertedByY(p[i]);
            }           
        }
        return netYForce;
    }

    /** Updates planet position and velocity instance vars. */
    public void update(double dt, double fX, double fY){
        double aNetX = fX/mass;
        double aNetY = fY/mass;
        double vNewX = xxVel + dt*aNetX;
        double vNewY = yyVel + dt*aNetY;
        double pNewX = xxPos + dt*vNewX;
        double pNewY = yyPos + dt*vNewY;

        this.xxPos = pNewX;
        this.yyPos = pNewY;
        this.xxVel = vNewX;
        this.yyVel = vNewY;
    }
 
    



            
}