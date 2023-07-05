package telran.measure;

public class Length implements Comparable<Length> {
	private float amount;
	private LengthUnit lengthUnit;

	public Length(float amount, LengthUnit lengthUnit) {
		this.amount = amount;
		this.lengthUnit = lengthUnit;
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return lengthUnit;
	}
	
	@Override
	public boolean equals(Object o) {
		Length lengInThis = ((Length) o).convert(lengthUnit);
		return 	(lengInThis.amount == amount && lengInThis.lengthUnit == lengthUnit)?
				true : false;
	}

	@Override
	public String toString() {
		return String.format("%.1f%s", amount, lengthUnit);
	}

	@Override
	public int compareTo(Length leng) {
		int res = 0;
		Length lengInThis = leng.convert(lengthUnit);
		if ((amount - lengInThis.amount) > 0 && lengInThis.lengthUnit == lengthUnit) {
			res = 1;
		} else if ((amount - lengInThis.amount) < 0 && lengInThis.lengthUnit == lengthUnit) {
			res = -1;
		}
		return res;
	}

	public Length convert(LengthUnit lengthUnit) {

		return new Length((amount * this.lengthUnit.value) / lengthUnit.value, lengthUnit);
	}

}
