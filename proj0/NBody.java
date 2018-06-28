public class NBody {       
        
    /** Return value corresponding to radius of universe from a file */
    public static double readRadius(String fileName) {        
        In in = new In(fileName);
        int totlPlanets = in.readInt();        ;
        double radiusUniverse = in.readDouble();

        return radiusUniverse; 
   }

    
}