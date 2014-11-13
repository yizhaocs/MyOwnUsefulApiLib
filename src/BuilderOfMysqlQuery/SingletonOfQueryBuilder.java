package BuilderOfMysqlQuery;

public class SingletonOfQueryBuilder {
	private static SingletonOfQueryBuilder instance = null;

	private SingletonOfQueryBuilder() {

	}

	public static SingletonOfQueryBuilder getInstance() {
		if (instance == null) {
			instance = new SingletonOfQueryBuilder();
		}
		return instance;
	}

	protected String insert(String table, String columns, String values) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(table);
		sb.append("(");
		sb.append(columns);
		sb.append(")");
		sb.append(" VALUES ");
		sb.append("(");
		sb.append(values);
		sb.append(")");
		sb.append(";");
		return sb.toString();
	}

	/*
	 * String tableName = "tableName";
	 * String[] insertColumnsWithoutUserKey = { "A", "B", "C", "D", "E" };
	 * String[] valuesWithoutUserKey = { "'packageName'", "'streamKey'", "'hex'", "12345", "67890" };
	 * String[] updateColumns = { "A", "B" };
	 */
	/*
	 * INSERT INTO tableName(A,B,C,D,E) VALUES ('packageName','streamKey','hex',12345,67890) ON DUPLICATE KEY UPDATE A=VALUES(A),B=VALUES(B);
	 */
	protected String upsert(String table, String[] insertColumns, String[] values, String[] updateColumns) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(table);
		sb.append("(");
		for (int i = 0; i < insertColumns.length; i++) {
			sb.append(insertColumns[i]);
			if (i + 1 < insertColumns.length) {
				sb.append(",");
			}
		}
		sb.append(")");
		sb.append(" VALUES ");
		sb.append("(");
		for (int i = 0; i < values.length; i++) {
			sb.append(values[i]);
			if (i + 1 < values.length) {
				sb.append(",");
			}
		}
		sb.append(")");
		sb.append(" ON DUPLICATE KEY UPDATE ");
		for (int i = 0; i < updateColumns.length; i++) {
			sb.append(updateColumns[i]);
			sb.append("=VALUES(");
			sb.append(updateColumns[i]);
			sb.append(")");
			if (i + 1 < updateColumns.length) {
				sb.append(",");
			}
		}
		sb.append(";");
		return sb.toString();
	}

	/*
	 * String tableName = "tableName";
	 * String[] columnsWillBeReturned = { "A", "B" };
	 * String[] whereClauseCoulmns = { "C", "D", "E", "F" };
	 * String[] whereClauseOperator = { "=", "=", "=", ">" };
	 * String[] whereClauseValues = { "'ZZZ'", "'YYY'", "'XXX'", "5" };
	 */
	/*
	 * SELECT A,B FROM tableName WHERE C='ZZZ' AND D='YYY' AND E='XXX' AND F>5;
	 */
	protected String select(String[] columnsWillBeReturned, String table, String[] whereClauseCoulmns, String[] whereClauseOperator, String[] whereClauseValues) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		for (int i = 0; i < columnsWillBeReturned.length; i++) {
			sb.append(columnsWillBeReturned[i]);
			if (i + 1 < columnsWillBeReturned.length) {
				sb.append(",");
			}
		}
		sb.append(" FROM ");
		sb.append(table);
		sb.append(" WHERE ");
		sb.append(whereClauseBuilder(whereClauseCoulmns, whereClauseOperator, whereClauseValues));
		sb.append(";");
		return sb.toString();
	}

	protected String update(String table, String[] updateCoulmns, String[] updateValues, String[] whereClauseCoulmns, String[] whereClauseOperator, String[] whereClauseValues) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ");
		sb.append(table);
		sb.append(" SET ");
		for (int i = 0; i < updateCoulmns.length; i++) {
			sb.append(updateCoulmns[i]);
			sb.append("=");
			sb.append(updateValues[i]);
			if (i + 1 < updateCoulmns.length) {
				sb.append(",");
			}
		}
		sb.append(" WHERE ");
		sb.append(whereClauseBuilder(whereClauseCoulmns, whereClauseOperator, whereClauseValues));
		sb.append(";");
		return sb.toString();
	}

	/*
	 * String tableName = "tableName";
	 * String[] whereClauseCoulmns = { "C", "D", "E", "F" };
	 * String[] whereClauseOperator = { "=", "=", "=", ">" };
	 * String[] whereClauseValues = { "'ZZZ'", "'YYY'", "'XXX'", "5" };
	 */
	/*
	 * DELETE FROM tableName WHERE C='ZZZ' AND D='YYY' AND E='XXX' AND F>5;
	 */
	protected String delete(String table, String[] whereClauseCoulmns, String[] whereClauseOperator, String[] whereClauseValues) {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ");
		sb.append(table);
		sb.append(" WHERE ");
		sb.append(whereClauseBuilder(whereClauseCoulmns, whereClauseOperator, whereClauseValues));
		sb.append(";");
		return sb.toString();
	}

	protected String whereClauseBuilder(String[] whereClauseCoulmns, String[] whereClauseOperator, String[] whereClauseValues) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < whereClauseCoulmns.length; i++) {
			sb.append(whereClauseCoulmns[i]);
			sb.append(whereClauseOperator[i]);
			sb.append(whereClauseValues[i]);
			if (i + 1 < whereClauseCoulmns.length) {
				sb.append(" AND ");
			}
		}
		return sb.toString();
	}
}
