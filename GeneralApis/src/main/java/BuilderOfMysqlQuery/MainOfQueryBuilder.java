package main.java.BuilderOfMysqlQuery;

public class MainOfQueryBuilder {
	static SingletonOfQueryBuilder s = SingletonOfQueryBuilder.getInstance();

	public static void main(String[] args) {
		select();
		delete();
		upsert();
	}

	/*
	 * SELECT A,B FROM tableName WHERE C='ZZZ' AND D='YYY' AND E='XXX' AND F>5;
	 */
	private static void select() {
		String tableName = "tableName";
		String[] columnsWillBeReturned = { "A", "B" };
		String[] whereClauseCoulmns = { "C", "D", "E", "F" };
		String[] whereClauseOperator = { "=", "=", "=", ">" };
		String[] whereClauseValues = { "'ZZZ'", "'YYY'", "'XXX'", "5" };

		String query = s.select(columnsWillBeReturned, tableName, whereClauseCoulmns, whereClauseOperator, whereClauseValues);
		System.out.println(query);
	}

	/*
	 * DELETE FROM tableName WHERE C='ZZZ' AND D='YYY' AND E='XXX' AND F>5;
	 */
	private static void delete() {
		String tableName = "tableName";
		String[] whereClauseCoulmns = { "C", "D", "E", "F" };
		String[] whereClauseOperator = { "=", "=", "=", ">" };
		String[] whereClauseValues = { "'ZZZ'", "'YYY'", "'XXX'", "5" };

		String query = s.delete(tableName, whereClauseCoulmns, whereClauseOperator, whereClauseValues);
		System.out.println(query);
	}

	/*
	 * INSERT INTO tableName(A,B,C,D,E) VALUES ('packageName','streamKey','hex',12345,67890) ON DUPLICATE KEY UPDATE A=VALUES(A),B=VALUES(B);
	 */
	private static void upsert() {
		String tableName = "tableName";
		String[] insertColumnsWithoutUserKey = { "A", "B", "C", "D", "E" };
		String[] valuesWithoutUserKey = { "'packageName'", "'streamKey'", "'hex'", "12345", "67890" };
		String[] updateColumns = { "A", "B" };
		String query = s.upsert(tableName, insertColumnsWithoutUserKey, valuesWithoutUserKey, updateColumns);
		System.out.println(query);
	}
}
