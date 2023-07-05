package telran.measure;

public enum LengthUnit {
	mm(0.1f), cm(1), inch(2.54f), dm(10), m(100), km(100_000);

	float value;

	LengthUnit(float value) {
		this.value = value;
	}

	public Length between(Length length1, Length length2) {

		Length newLength2 = length2.convert(this);
		Length newLength1 = length1.convert(this);

		float between = newLength2.getAmount() - newLength1.getAmount();

		return new Length(between, this);
	}
}
