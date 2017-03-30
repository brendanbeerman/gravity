package dal.gravity;

public class GravityConstant implements GravityModel
{
	private double gravity;
	
	public GravityConstant(double g)
	{
		gravity = g;
	}
	
	@Override
	public double getGravitationalField()
	{
		return gravity;
	}

}
