package calculator;

import java.util.List;
import java.util.Random;

final public class RNG extends Operation{
	
	public RNG(List<Expression> elist) throws IllegalConstruction {
		super(elist);
		symbol = "Rng";
		neutral = 0;
		// TODO Auto-generated constructor stub
	}
	public RNG(List<Expression> elist, Notation n) throws IllegalConstruction {
		super(elist, n);
		symbol = "Rng";
		neutral = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int op(int max, int min) {
		// TODO Auto-generated method stub
		return (int)(Math.random()*(max-min)+min);
	}

	
}
