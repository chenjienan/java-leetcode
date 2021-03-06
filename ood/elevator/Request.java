package ood.elevator;


class Request {
	private int level;
	
	public Request(int l)
	{
		level = l;
	}
	
	public int getLevel()
	{
		return level;
	}
}

class ExternalRequest extends Request{

	private Direction direction;
	
	public ExternalRequest(int l, Direction d) {
		super(l);
		this.direction = d;
	}
	
	public Direction getDirection()
	{
		return direction;
	}
}

class InternalRequest extends Request{

	public InternalRequest(int l) {
		super(l);
	}
}
