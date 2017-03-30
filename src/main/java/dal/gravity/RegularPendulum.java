package dal.gravity;

/**
 * Represents a pendulum
 */
public class RegularPendulum extends AbstractPendulum {
    public static final double GRAVITY = 9.80665;
	
    private double delta, iterations = 0;
    private double dissipation;
    private double lastTheta, lastVel, lastAccel;

    /**
     * Creates a new Pendulum instance 
     */
    public RegularPendulum (double inLength, double inMass, double inTheta0, 
		     double inDelta, double inDissn, double gravity) {
	super (inLength, inMass, inTheta0, gravity);
	delta=inDelta;
	dissipation = inDissn;
	lastVel = 0;
	lastTheta = this.getMaxAngularDisplacement ();
	lastAccel = -(this.getGravitationalField () / this.getStringLength ())*Math.sin (lastTheta);
    }

    public RegularPendulum (double inLength, double inMass, double inTheta0, 
		     double inDelta, double gravity) {
	this (inLength, inMass, inTheta0, inDelta, 0, gravity);
    }

    public void step () {
	iterations++;
	lastTheta = lastTheta + lastVel*delta;
	lastVel = lastVel + lastAccel*delta;
	lastAccel = - dissipation*lastVel - this.getGravitationalField () / this.getStringLength () * Math.sin (lastTheta);
    }

    public double getLastTheta () { return lastTheta; }
    public double getLastVelocity () { return lastVel; }
    public double getLastAcceleration () { return lastAccel; }
    public double getLastTime () { return iterations*delta; }
    public double getDissipationConstant () { return dissipation; }
    

}
