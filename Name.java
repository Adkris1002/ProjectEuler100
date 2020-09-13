public class Name implements Comparable<Name> {
	private String name;
	private int position;
	
	public Name(String name, int position) {
		this.name = name;
		this.position = position;
	}
	
	@Override
	public int compareTo(Name o) {
		return o.getNameScore() - this.getNameScore();
	}

	private int getAlphabetiVal() {
		int sum = 0;
		int al = 0;
		for (int i = 0; i < this.name.length(); i++) {
			al = (int)(this.name.charAt(i))-64;
			sum+=al;
		}
		return sum;
	}

	public int getNameScore() {
		return this.getAlphabetiVal()*this.position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	

}
