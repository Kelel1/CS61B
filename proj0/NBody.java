public class NBody {       
        
    /** Return value corresponding to radius of universe from a file */
    public static double readRadius(String fileName) {        
        In in = new In(fileName);
        int totlPlanets = in.readInt();        ;
        double radiusUniverse = in.readDouble();

        return radiusUniverse; 
   }

   /** Return an array of Planets corresponding to the planets in the file */
   public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int totlPlanets = in.readInt();
        Planet[] bodies = new Planet[totlPlanets];
        double radius = in.readDouble(); 
        
        
       for(int j = 0; j < bodies.length; j++ ) {      
       double xxPos = in.readDouble();
       double yyPos = in.readDouble();
       double xxVel = in.readDouble();
       double yyVel = in.readDouble();
       double mass = in.readDouble();
       String planetName = in.readString();
       
       Planet body = new Planet(xxPos, yyPos, xxVel,
                               yyVel, mass, planetName);  

       bodies[j] = body;
  
    } 
       return bodies;
   }
    
}