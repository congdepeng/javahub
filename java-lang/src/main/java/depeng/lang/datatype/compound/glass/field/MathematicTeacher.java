package depeng.lang.datatype.compound.glass.field;

public class MathematicTeacher {
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MathematicTeacher(int age, String name) {
		this.age = age;
		this.name = name;
	}
}