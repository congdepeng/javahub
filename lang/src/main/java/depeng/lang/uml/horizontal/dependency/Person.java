package depeng.lang.uml.horizontal.dependency;




/**
 * Dependency 虚线箭头， 类之间的水平关系之一
 * #1, dependency 总是单向的 （双向依赖是反模式）
 * #2,
 * 在java中表现为局部变量，
 * 方法的参数，
 * 或者静态方法的调用
 *
 */
public class Person {

	private int calorie;

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

//	public Person(int calorie) {
//		this.calorie = calorie;
//	}

	/**
	 * 方法参数  （IDEA 生成 UML图不会显示）
	 * @param hamburger
	 */

	public void eatHamburger(Hamburger hamburger){
		this.calorie = this.calorie + hamburger.getCalorie();
	}


	/**
	 * 局部变量 （会显示， 因为是create了）
	 * @param calorie
	 * @return
	 */
	public Hamburger makeHamBurger(int calorie){
		Hamburger hamburger = new Hamburger(calorie);
		return hamburger;
	}


	/**
	 *  静态调用（IDEA 生成 UML图不会显示）
	 */
	public void findBeef(){
		if(BeefBurger.isBeefInside()){
			System.out.println("yes, I like beef");
		}
	}



}
