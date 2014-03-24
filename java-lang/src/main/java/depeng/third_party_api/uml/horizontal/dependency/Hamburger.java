package depeng.third_party_api.uml.horizontal.dependency;

/**
 * Created with IntelliJ IDEA.
 * User: depeng
 * Date: 12/6/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hamburger {

	private int calorie = 100;

	public Hamburger(int calorie) {
		this.calorie = calorie;
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

}
