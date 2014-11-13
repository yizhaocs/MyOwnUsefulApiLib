package BuilderOfMysqlQuery;

public class MainOfQueryBuilder {
	static SingletonOfQueryBuilder s = SingletonOfQueryBuilder.getInstance();

	public static void main(String[] args) {
		select();
	}

	/*
	 * SELECT A,B FROM tableName WHERE C='ZZZ' AND D='YYY' AND E='XXX' AND F>5;
	 */
	private static void select() {
		String[] columnsWillBeReturned = { "A", "B" };
		String[] whereClauseCoulmns = { "C", "D", "E", "F" };
		String[] whereClauseOperator = { "=", "=", "=", ">" };
		String[] whereClauseValues = { "'ZZZ'", "'YYY'", "'XXX'", "5" };

		String query = s.select(columnsWillBeReturned, "tableName", whereClauseCoulmns, whereClauseOperator, whereClauseValues);
		System.out.println(query);
	}
}
