public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass; // weight
    public String imgFileName;

    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName =img;
    }

    public Planet(Planet p) {
        this(p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
    }

    public double calcDistance(Planet p) {
        // return Math.sqrt(Math.pow(this.xxPos - other.xxPos, 2) + Math.pow(this.yyPos - other.yyPos, 2));
        
        double x = xxPos - p.xxPos;
        double y = yyPos - p.yyPos;
        return Math.sqrt(x * x + y * y);
    }

    public double calcForceExertedBy(Planet p) {
        double distance = calcDistance(p);
        return G * mass * p.mass / (distance * distance);
    }

    public double calcForceExertedByX(Planet p) {
        double distance = calcDistance(p);
        double force = calcForceExertedBy(p);
        return (p.xxPos - xxPos) / distance * force;     
    }

    public double calcForceExertedByY(Planet p) {
        double distance = calcDistance(p);
        double force = calcForceExertedBy(p);
        return (p.yyPos - yyPos) / distance * force;     
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double total = 0;
        for (Planet each : p) {
            if (this.equals(each)) 
                continue;

            total += calcForceExertedByX(each);
        }
        return total;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double total = 0;
        for (Planet each : p) {
            if (this.equals(each))
                continue;

            total += calcForceExertedByY(each);
        }
        return total;
    }

    public void update(double duration, double xxForce, double yyForce) {
        /*Acceleration */
        double xA = xxForce / mass;
        double yA = yyForce / mass;
        double newxxVel = xxVel + duration * xA;
        double newyyVel = yyVel + duration * yA;
        xxVel = newxxVel;
        yyVel = newyyVel;
        xxPos = xxPos + duration * newxxVel;
        yyPos = yyPos + duration * newyyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
    
}