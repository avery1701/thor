package com.advancedpwr.record.mock;

import java.util.ArrayList;

import java.sql.*;

public class SqlInterfaces extends ArrayList<Class>
{
	public SqlInterfaces()
	{
		add( Array.class );
		add( Blob.class );
		add( CallableStatement.class );
		add( Clob.class );
		add( Connection.class );
		add( DatabaseMetaData.class );
		add( NClob.class );
		add( ParameterMetaData.class );
		add( PreparedStatement.class );
		add( Ref.class );
		add( ResultSet.class );
		add( ResultSetMetaData.class );
		add( RowId.class );
		add( Savepoint.class );
		add( SQLXML.class);
		add( Statement.class );
		add( Struct.class );
		
	}
}
